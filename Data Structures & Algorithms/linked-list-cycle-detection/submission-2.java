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
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(-1, head);
        ListNode fast = head;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
