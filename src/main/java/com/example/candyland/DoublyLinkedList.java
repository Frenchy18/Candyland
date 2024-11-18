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
