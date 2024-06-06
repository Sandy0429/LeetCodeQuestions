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
    public ListNode deleteDuplicates(ListNode head) {
         ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy; // Last node known to have unique value
        ListNode current = head; // Current node being processed

        while (current != null) {
            // Check if current node has duplicates
            boolean hasDuplicates = false;
            while (current.next != null && current.val == current.next.val) {
                hasDuplicates = true;
                current = current.next;
            }
            if (hasDuplicates) {
                // Skip all nodes with duplicate values
                prev.next = current.next;
            } else {
                // Move prev to current if no duplicates found
                prev = prev.next;
            }
            current = current.next; // Move to the next node
        }

        return dummy.next; 
    }
}
