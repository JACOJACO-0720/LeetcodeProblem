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
    public ListNode partition(ListNode head, int x) {
        ListNode smalldummyhead = new ListNode(-101);
        ListNode smallcur = smalldummyhead;
        ListNode bigdummyhead = new ListNode(-101);
        ListNode bigcur = bigdummyhead;

        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                smallcur.next = cur;
                smallcur = cur;
                cur=cur.next;
                smallcur.next = null;
            }else{
                bigcur.next = cur;
                bigcur = cur;
                cur = cur.next;
                bigcur.next = null;
            }
            
        }
        smallcur.next = bigdummyhead.next;
        return smalldummyhead.next;
    }
}