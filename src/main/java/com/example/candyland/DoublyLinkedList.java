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

    public Node getStart() {
        return head;
    }

    public Node getEnd() {
        return tail;
    }

    public void initializeBoard() {
        head = new Node(0,"Rainbow", 0, "Start");
        Node current = head;

        for (int i=1; i<64; i++) {
            String color = getColorForSpace(i);
            Node newNode = new Node(i, color, 0, "Space "+i);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        tail = current;
    }

    private String getColorForSpace(int spaceNumber) {
        String[] colors = {"Red","Green","Blue","Yellow","Orange","Purple"};
        return colors[spaceNumber % colors.length];
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
