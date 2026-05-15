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
        if (lists == null || lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            List<ListNode> list = new ArrayList<>();
            for (int i = 0; i < lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                list.add(mergeLists(l1, l2));
            }
            lists = list.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1, null);
        ListNode dummy = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val, null);
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null) {
            head.next = new ListNode(l1.val, null);
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null) {
            head.next = new ListNode(l2.val, null);
            l2 = l2.next;
            head = head.next;
        }
        return dummy.next;
    }
}
