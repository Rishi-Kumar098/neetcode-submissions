class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create cloned nodes and interweave them with original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers to the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list and the copied list
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            
            // Extract the copy node
            copyCurr.next = copy;
            copyCurr = copy;
            
            // Restore the original node's next pointer
            curr.next = copy.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
