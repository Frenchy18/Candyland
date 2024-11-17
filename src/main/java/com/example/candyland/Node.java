package com.example.candyland;


// add event variable
public class Node {
    int event;
    String eventMessage;
    int spaceNumber;
    String spaceColor;
    Node prev;
    Node next;

    public Node(int spaceNumber, String spaceColor, int event, String eventMessage) {
        this.event = event;
        this.eventMessage = eventMessage;
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
        do {
            current = current.next;
        } while (current != null && !current.spaceColor.equals(spaceColor));{
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
    public Node moveBackwards(Node currentSpace, String spaceColor){
        Node current = currentSpace;
        do {
            current = current.prev;
        } while (current != null && !current.spaceColor.equals(spaceColor));{
            current = current.prev;
        }
        return current;

    }


}
