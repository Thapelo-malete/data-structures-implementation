package tech.thapelomalifi.stack;

import tech.thapelomalifi.linkedList.LinkedList;

/**
 * This is an implememtation of Stack using a singly linked list i implemented
 */

public class SecondStack {
    LinkedList list;

    public SecondStack() {
        this.list = new LinkedList();
    }

    public void push(int value) {
        list.addFirst(value);;
    }

    public int pop() {
        int value = list.get(0);
        list.removeFirst();
        return value;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
