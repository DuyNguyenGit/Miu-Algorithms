package Labs.Lab1;

class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode current = head, prev = null;

        while (head.next != null) {
            current = head.next;
            head.next = prev;
            prev = head;
            head = current;
        }
        head.next = prev;
        return head;
    }
    public ListNode reverseListUsingRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Adjust the pointers
        head.next.next = head;  // Point the next node's next to the current node
        head.next = null;       // Set the current node's next to null (since it's the new end)

        // Return the new head of the reversed list
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}