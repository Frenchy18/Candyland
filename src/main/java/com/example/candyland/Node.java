package com.example.candyland;


// add event variable
public class Node {
    int event;
    String eventMessage;
    int spaceNumber;
    String spaceColor;
    Node prev;
    Node next;

    public Node(int spaceNumber,String spaceColor, int event, String eventMessage){
        this.event = event;
        this.eventMessage = eventMessage;
        this.spaceColor = spaceColor;
        this.spaceNumber = spaceNumber;
        this.prev = null;
        this.next = null;
    }

}
