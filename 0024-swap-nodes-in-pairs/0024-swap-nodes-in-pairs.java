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
    public ListNode swapPairs(ListNode head) {
        return helperFunction(head);
    }
    ListNode helperFunction(ListNode start){
        if(start==null || start.next==null){
            return start;
        }
    ListNode realStart = start.next;
    ListNode next = realStart.next;
    realStart.next = start;
    start.next = helperFunction(next);
        return realStart;
    }
 }