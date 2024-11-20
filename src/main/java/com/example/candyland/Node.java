package com.example.candyland;


import javafx.scene.image.ImageView;

// add event variable
public class Node {
    int spaceNumber;
    String spaceColor;
    Node prev;
    Node next;

    public Node(int spaceNumber, String spaceColor) {
        this.spaceColor = spaceColor;
        this.spaceNumber = spaceNumber;
        this.prev = null;
        this.next = null;
    }
    /**
     * method moves the player forward
     * @param currentSpace
     * @param spaceColor
     * @return the current node after traversing forwards on the list
     */
    public Node moveForward(Node currentSpace, String spaceColor) {
        Node current = currentSpace;
        while (current != null && !current.spaceColor.equals(spaceColor)) {
            current = current.next;
        }
        return current;
    }

    /**
     * Method moves the player backwards
     * @param currentSpace
     * @param spaceColor
     * @return the current node that is stopped on after traversal
     */
    public Node moveBackwards(Node currentSpace, String spaceColor) {
        Node current = currentSpace;
        while (current != null && !current.spaceColor.equals(spaceColor)) {
            current = current.prev;
        }
        return current;
    }
}
