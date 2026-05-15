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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode curr = result;
        ListNode startA = list1;
        ListNode startB = list2;
        while (startA != null && startB != null) {
            if (startA.val <= startB.val) {
                curr.next = new ListNode(startA.val);
                startA = startA.next;
            } else {
                curr.next = new ListNode(startB.val);
                startB = startB.next;
            }
            curr = curr.next;
        }
        while (startA != null) {
            curr.next = new ListNode(startA.val);
            startA = startA.next;
            curr = curr.next;
        }
        while (startB != null) {
            curr.next = new ListNode(startB.val);
            startB = startB.next;
            curr = curr.next;
        }
        return result.next;
    }
}