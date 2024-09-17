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
    public ListNode sortList(ListNode head) {
        if(head==null ||head.next ==null){
            return head;
        }
        ListNode slow  = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            fast= fast.next;
        }
        ListNode secondhead = slow.next;
        slow.next = null;
        
        return merge(sortList(head),sortList(secondhead)) ;
    }
    
    ListNode merge(ListNode n1, ListNode n2){
        ListNode head =null;
        ListNode current = null;
        while(n1!=null&&n2!=null){
            if(head==null){

                if(n1.val<n2.val){
                    head = n1;
                    n1=n1.next;
                    head.next=null;
                    current = head;
                    
                }else{
                    head = n2;
                    n2=n2.next;
                    head.next=null;
                    current = head;
                }

            }else{
                 if(n1.val<n2.val){
                    current.next = n1;
                    n1 = n1.next;
                    current=current.next;
                    current.next =null;
                }else{
                    current.next = n2;
                    n2 = n2.next;
                    current=current.next;
                    current.next =null;
                }
            }
        }
        if(n1==null&&n2==null){
            return head;
        }else if(n2==null){
            while(n1!=null){
                    current.next = n1;
                    n1 = n1.next;
                    current=current.next;
                    
                    current.next =null;
            }

        }else{
                while(n2!=null){
                    current.next = n2;
                    n2 = n2.next;
                    current=current.next;
                    current.next =null;
                   
            }
        }
        return head;
    }



}