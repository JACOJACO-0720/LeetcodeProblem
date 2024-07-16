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
    ListNode tailTail = null;
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            head.next = tailTail;
            return head;
        }
        else{
            ListNode second = head.next;
            ListNode tail = head;
            tail.next = tailTail;
            tailTail = tail;
            return reverseList(second);
        }
    }
}