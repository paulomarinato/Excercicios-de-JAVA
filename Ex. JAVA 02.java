class LinkedListNode {
    int data;
    LinkedListNode next;
  
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    public static int getNumber(LinkedListNode binary) {
        int decimal = 0;
        LinkedListNode current = binary;

        while (current != null) {
            decimal = decimal * 2 + current.data;
            current = current.next;
        }

        return decimal;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(0);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(1);
        head.next.next.next.next = new LinkedListNode(0);
        head.next.next.next.next.next = new LinkedListNode(1);
        head.next.next.next.next.next.next = new LinkedListNode(0);

        int decimal = getNumber(head);
        System.out.println(decimal);
    }
}
