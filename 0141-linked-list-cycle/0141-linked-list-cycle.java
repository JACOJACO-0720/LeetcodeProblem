/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean result=false;
        while(head!=null){
            if(head.val!=Integer.MAX_VALUE){
                head.val=Integer.MAX_VALUE;
                head = head.next;
                
            }else{
                return true;
            }
        }
        return result;
    }
}