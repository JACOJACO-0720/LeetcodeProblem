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
    public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode n1, ListNode n2)->(Integer.compare(n1.val, n2.val)));
            ListNode res =null;
            ListNode current = null;
            if(lists.length==0){
                return null;
            }
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]==null){
                    continue;
                }
                pq.add(lists[i]);
            }
            while(!pq.isEmpty()){
                ListNode temp = pq.poll();
                if(res==null){
                    res = temp;
                    current = temp;
                }else{
                    current.next = temp;
                    current = current.next;
                }
                ListNode a = current.next;
                current.next =null;
                if(a!=null){
                    pq.add(a);
                }

            }
                return res;
    }
}