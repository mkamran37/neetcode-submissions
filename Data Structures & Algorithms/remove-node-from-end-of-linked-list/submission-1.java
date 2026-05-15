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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ref = head;
        while (n > 0) {
            ref = ref.next;
            n--;
        }
        ListNode slow = new ListNode(-1, head);
        ListNode dummy = slow;
        while (ref != null) {
            slow = slow.next;
            ref = ref.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
