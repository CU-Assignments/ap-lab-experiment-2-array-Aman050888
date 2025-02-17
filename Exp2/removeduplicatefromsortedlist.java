class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // Method to deserialize a string to a ListNode
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] values = data.substring(1, data.length() - 1).split(",");
        ListNode head = new ListNode(Integer.parseInt(values[0].trim()));
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i].trim()));
            current = current.next;
        }
        return head;
    }

    // Method to serialize a ListNode to a string
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}