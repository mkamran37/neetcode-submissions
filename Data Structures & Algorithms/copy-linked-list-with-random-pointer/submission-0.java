/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node tmp = new Node(curr.val);
            map.put(curr, tmp);
            curr = curr.next;
        }
        curr = head;
        Node start = new Node(-1);
        Node dummy = start;
        while (curr != null) {
            start.next = map.get(curr);
            start.next.random = map.get(curr.random);
            start = start.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
