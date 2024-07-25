/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node;
        ListNode beforeNode = null;
        while(node.next!=null){
            node.val= node.next.val;
            if(beforeNode ==null){
                beforeNode = node;
            }else{
                beforeNode = beforeNode.next;
            }
            node = node.next;
        }
        beforeNode.next=null;
    }
}