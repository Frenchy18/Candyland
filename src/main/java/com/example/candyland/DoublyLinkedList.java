package com.example.candyland;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 65;
    }
    // append method links squares to DLL
    public void append(int spaceNumber, String spaceColor) {
        Node newNode = new Node(spaceNumber, spaceColor);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * method will find the node/ space number
     * @param spaceNumber
     * @return the node that matches the space number
     */
    public Node findSpaceNumber(int spaceNumber){
        Node current = head;
        while (current != null){
            if (current.spaceNumber == spaceNumber){
                return current; // return found space
            }
            current = current.next; // move next
        }
        return null; // return if it was not found
    }
}
