package com.example.candyland;


// add event variable
public class Node {
    int event;
    String eventMessage;
    int spaceNumber;
    String color;
    Node prev;
    Node next;
    private double x;
    private double y;

    public Node(int spaceNumber, String color, int event, String eventMessage) {
        this.event = event;
        this.eventMessage = eventMessage;
        this.color = color;
        this.spaceNumber = spaceNumber;
        this.prev = null;
        this.next = null;
    }
    /**
     * method moves the player forward
     * @param currentSpace
     * @param color
     * @return the current node after traversing forwards on the list
     */
    public Node moveForward(Node currentSpace, String color) {
        Node current = currentSpace;
        while (current != null) {
            if (current.color.equals(color)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Method moves the player backwards
     * @param currentSpace
     * @param spaceColor
     * @return the current node that is stopped on after traversal
     */
    public Node moveBackwards(Node currentSpace, String spaceColor){
        Node current = currentSpace;
        do {
            current = current.prev;
        } while (current != null && !current.color.equals(spaceColor));{
            current = current.prev;
        }
        return current;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


}
