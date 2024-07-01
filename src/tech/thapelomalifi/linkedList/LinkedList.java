package tech.thapelomalifi.linkedList;

/**
 * This is the implimentation of a Singly Linked list
 */

public class LinkedList {
    class Node {
        int data;
        Node next;
    
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        this.size = 0;
    }
    public int size() {
        return this.size;
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = new Node(value);
        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAt(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bound");
        } else if (index == 0) {
            addFirst(value);
        }

        Node prevNode = head;
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        Node newNode = new Node(value);
        newNode.next = currentNode;
        prevNode.next = newNode;
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
        Node prevNode = null;
        for (int i = 0; i < index; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            removeLast();
        } else if (currentNode == head) {
            removeFirst();
        } else {
            prevNode.next = currentNode.next;
            size--;
        }
    }

    public void removeFirst() {
        if (size == 0) {
            throw new UnsupportedOperationException("List is empty");
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        Node currentNode = head;
        if (size == 1) {
            head = null;
            size--;
            return;
        } else if (size == 0) {
            throw new UnsupportedOperationException("List is empty");
        }

        Node prevNode = head;
        while (currentNode.next != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = null;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
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
}
