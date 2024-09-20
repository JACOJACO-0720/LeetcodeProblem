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
        if(left==right){
            return head;
        }
        ListNode beforeleft = null;
        ListNode leftNode = head;
        if(left==1){
            beforeleft=  null;
            leftNode = head;
        }else{
            for (int i = 0; i < left-1; i++) {
                beforeleft = leftNode;
                leftNode =leftNode.next; 
            }
            
        }

        ListNode rightNode = leftNode;
        ListNode afterRight = leftNode.next;
        for (int i = 0; i < right-left; i++) {
            ListNode temp = rightNode;
            rightNode = afterRight;
            afterRight = afterRight.next;
            rightNode.next = temp;
        }
        if(beforeleft ==null){
            head = rightNode;
        }else{
            beforeleft.next = rightNode;
        }

        leftNode.next = afterRight;
        return head;
    }
}