package tech.thapelomalifi.linkedList;

/**
 * This is the implimentation of a Doubly Linked list
 */

public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;
    
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            size++;
            return;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addAt(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bound");
        } else if (index == 0) {
            addFirst(value);
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(value);
        newNode.next = currentNode;
        newNode.prev = currentNode.prev;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bound");
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bound");
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            removeLast();
        } else if (currentNode == head) {
            removeFirst();
        } else {
            currentNode.prev.next = currentNode.next; 
            currentNode.next.prev = currentNode.prev;
            size--;
        }
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
            size--;
            return;
        } else if (size == 0) {
            throw new UnsupportedOperationException("List is empty");
        }

        tail = tail.prev;
        size--;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new UnsupportedOperationException("List is empty");
        }

        head = head.next;
        size--;
    }

    public boolean contains(int value) {
        boolean isPresent = false;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) {
                isPresent = true;
                break;
            }

            currentNode = currentNode.next;

        }
        return isPresent;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == null) {
                System.out.print(currentNode.data + "\n");
            } else {
                System.out.print(currentNode.data + " ");
            }
            
            currentNode = currentNode.next;
        }
    }

    public void printBackwards() {
        Node currentNode = tail;
        while (currentNode != null) {
            if (currentNode.prev == null) {
                System.out.print(currentNode.data + "\n");
            } else {
                System.out.print(currentNode.data + " ");
            }

            currentNode = currentNode.prev;
        }
    }
}
