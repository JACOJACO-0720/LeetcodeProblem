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
    public ListNode sortList(ListNode head) {
        // 处理空链表或只有一个节点的链表
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割链表
        ListNode secondHead = slow.next;
        slow.next = null;

        // 递归排序两部分
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);

        // 合并排序后的两部分
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        // 哨兵节点（dummy node），简化链表的操作
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 合并两个链表
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 处理剩下的节点
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // 返回合并后的链表
        return dummy.next;
    }
}
