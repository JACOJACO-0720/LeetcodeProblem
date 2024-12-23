/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null){
            return null;
        }
        ListNode dummyhead = new ListNode(-101);
        dummyhead.next = head;
        ListNode beforecurhead = dummyhead; 
        ListNode curhead = head;
        ListNode cur = head;
        while(cur!=null){
            if(cur == curhead){
                cur =cur.next;
            }else{
                if(cur.val!=curhead.val){
                    if(curhead.next!=cur){
                        beforecurhead.next = cur;
                        curhead = cur;
                    }else{
                        beforecurhead = curhead;
                        curhead = cur;
                    }
                    
                }else{
                    cur = cur.next;
                }
            }
        }
                    if(curhead.next!=cur){
                        beforecurhead.next = null;
                    }
                    

        return dummyhead.next;
    }
}