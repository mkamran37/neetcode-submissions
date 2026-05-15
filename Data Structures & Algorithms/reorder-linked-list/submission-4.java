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
    public void reorderList(ListNode head) {
        // Step 1: find the second half
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: reverse the second half
        ListNode secondHalfHead = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge
        while (secondHalfHead != null) {
            ListNode tmp1 = head.next, tmp2 = secondHalfHead.next;
            head.next = secondHalfHead;
            secondHalfHead.next = tmp1;
            head = tmp1;
            secondHalfHead = tmp2;
        }

    }

    private ListNode reverse (ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
