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
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newNode = new ListNode(-1, null);
        ListNode curr = newNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = new ListNode(list2.val, null);
                list2 = list2.next;
            } else {
                curr.next = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            curr = curr.next;
        }
        while (list1 != null) {
            curr.next = new ListNode(list1.val, null);
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = new ListNode(list2.val, null);
            list2 = list2.next;
            curr = curr.next;
        }
        return newNode.next;
    }
}