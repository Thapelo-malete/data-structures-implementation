package tech.thapelomalifi;

import tech.thapelomalifi.linkedList.DoublyLinkedList;
import tech.thapelomalifi.linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.add(5);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        list.addAt(1, 10);
        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        list.addAt(5, 26);
        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        list.addAt(6, 26);
        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        list.remove(6);
        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        System.out.print("print: ");
        list.print();
        System.out.print("print reverse: ");
        list.printBackwards();

        System.out.println(list.get(5));
        System.out.println(list.get(0));
    }
}