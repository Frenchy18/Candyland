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

    public Node(int spaceNumber, String color, int event, String eventMessage, double x, double y) {
        this.event = event;
        this.eventMessage = eventMessage;
        this.color = color;
        this.spaceNumber = spaceNumber;
        this.x = x;
        this.y = y;
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
        Node current = currentSpace.next; // Start with the next node
        while (current != null) {
            System.out.println("Traversing Node: " + current.spaceNumber + " with color: " + current.color);
            if (current.color.equalsIgnoreCase(color)) {
                System.out.println("Found target node: " + current.spaceNumber + " (" + current.color + ")");
                return current; // Found the next node of the specified color
            }
            current = current.next; // Continue traversing
        }
        System.out.println("No matching node found for color: " + color);
        return null; // No matching node found
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getColor() {
        return color;
    }
}
