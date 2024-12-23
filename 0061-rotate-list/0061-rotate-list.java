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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        int n = 1;
        //calculate the length
        ListNode currNode = head;
        ListNode tail = null;
        ListNode hd = head;
        while(currNode.next!=null){
            n++;
            currNode = currNode.next; 
        }
        tail = currNode;
        k=k%n;
        for(int i = 0;i<n-k;i++){
            ListNode temp = hd;
            hd=hd.next;
            temp.next = null;
            
            tail.next = temp;
            tail=tail.next;
        }
        return hd;
    }
}