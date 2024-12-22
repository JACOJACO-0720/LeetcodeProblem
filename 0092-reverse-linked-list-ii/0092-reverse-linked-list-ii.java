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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyhead = new ListNode(-501);
        dummyhead.next = head;
        ListNode beforeleft = dummyhead;
        for(int i =0;i<left-1;i++){
            beforeleft = beforeleft.next;
        }
        ListNode leftNode = beforeleft.next;
        beforeleft.next =null;

        ListNode one = null;
        ListNode two = leftNode;
        ListNode temp = null;
        for(int i =0;i<right-left+1;i++){
            if(one==null){
                one = two;
                two = two.next;
                one.next = null;
            }else{
                temp = two.next;
                two.next = one;
                one = two;
                two = temp;
            }
        }
        beforeleft.next = one;
        leftNode.next = two;
        return dummyhead.next;
    }
}