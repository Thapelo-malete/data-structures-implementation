package tech.thapelomalifi.stack;

/**
 * This is an implememtation of Stack
 */
public class Stack {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public Stack() {
        this.size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }
}
