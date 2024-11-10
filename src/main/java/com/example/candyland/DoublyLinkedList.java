package src.main.java.com.example.candyland;

// create linked list size


public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void moveForward(){
        Node current = head;
        while(current != null){
            current = current.next;
        }
    }

    public void moveBackwards(){
        Node current = tail;
        while (current != null){
            current = current.prev;
        }
    }
}
