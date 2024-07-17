
import java.util.Collection;/**
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
    // current  4, 2, 2
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        ListNode head  = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode ln1, ListNode ln2) -> Integer.compare( ln1.val,ln2.val));
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()){
            ListNode small = pq.poll();
            if(small.next!=null){
                pq.add(small.next);
            }
            if(res==null){
                res = small;
                head = small;
            }else{
                res.next = small;
                res = small;
            }
        }

        return head;
    }
}