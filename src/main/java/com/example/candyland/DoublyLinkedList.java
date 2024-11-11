package src.main.java.com.example.candyland;

// create linked list size

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //add a space to the board
    public void addSpace(int spaceNumber, String spaceColor, int event, String eventMessage){
        Node newSpace = new Node(spaceNumber, spaceColor, event, eventMessage);

        if (head == null){
            head = newSpace;
            tail = newSpace;
        }
        else {
            tail.next = newSpace;
            newSpace.prev = tail;
            tail = newSpace;
        }
        size ++;
    }

    public Node moveForward(Node currentSpace, int steps) {
        Node current = currentSpace;
        for (int i = 0; i < steps && current != null; i++){
            current = current.next;
        }
        return current;
    }

    public void moveBackwards(){
        Node current = tail;
        while (current != null){
            current = current.prev;
        }
    }
}
