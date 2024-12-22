class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyhead = new ListNode(-501);
        dummyhead.next = head;
        ListNode beforeleft = dummyhead;

        // Step 1: Find the node just before the "left" position
        for (int i = 0; i < left - 1; i++) {
            beforeleft = beforeleft.next;
        }

        // Step 2: Identify the node at the "left" position
        ListNode leftNode = beforeleft.next;
        ListNode one = null;
        ListNode two = leftNode;
        ListNode temp = null;

        // Step 3: Reverse the sublist from "left" to "right"
        for (int i = 0; i < right - left + 1; i++) {
            temp = two.next;  // Store next node
            two.next = one;   // Reverse the link
            one = two;        // Move one step forward in the reversed list
            two = temp;       // Move to the next node in the original list
        }

        // Step 4: Connect the reversed sublist back to the original list
        beforeleft.next = one;  // Connect the node before "left" to the new head
        leftNode.next = two;    // Connect the original "left" node to the node after "right"

        return dummyhead.next;  // Return the head of the modified list
    }
}
