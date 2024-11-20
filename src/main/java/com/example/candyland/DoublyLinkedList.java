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

        double[][] coordinates = {
                {66, 624}, // GameStartSquare
                {116, 624}, // Red_1
                {166, 624}, // Green_1
                {216, 624}, // Blue_1
                {266, 624}, // Yellow_1
                {316, 624}, // Orange_1
                {366, 624}, // Purple_1
                {416, 624}, // Red_2
                {466, 624}, // Green_2
                {516, 624}, // Blue_2
                {566, 624}, // Yellow_2
                {615, 624}, // Orange_2
                {665, 624}, // Purple_2
                {714, 624}, // Pink_1_Peppermint
                {764, 624}, // Red_3
                {814, 624}, // Green_3
                {864, 624}, // Blue_3
                {914, 624}, // Yellow_3
                {964, 624}, // Orange_3
                {1014, 599}, // Purple_3
                {989, 549}, // Red_4
                {939, 524}, // Green_4
                {889, 499}, // Blue_4
                {839, 474}, // Yellow_4
                {789, 474}, // Orange_4
                {739, 474}, // Purple_4
                {689, 474}, // Pink_2_Cupcake
                {640, 474}, // Red_5
                {591, 474}, // Green_5
                {541, 474}, // Blue_5
                {491, 474}, // Yellow_5
                {441, 459}, // Orange_5
                {391, 434}, // Purple_5
                {341, 409}, // Red_6
                {291, 384}, // Green_6
                {241, 359}, // Blue_6
                {191, 335}, // Yellow_6
                {141, 334}, // Orange_6
                {91, 310}, // Purple_6
                {42, 287}, // Pink_3_Gingerbread
                {41, 238}, // Red_7
                {91, 213}, // Green_7
                {141, 213}, // Blue_7
                {191, 238}, // Yellow_7
                {241, 238}, // Orange_7
                {291, 213}, // Purple_7
                {341, 188}, // Red_8
                {391, 188}, // Green_8
                {441, 163}, // Blue_8
                {491, 163}, // Yellow_8
                {541, 138}, // Orange_8
                {591, 113}, // Purple_8
                {640, 113}, // Pink_4_Candy
                {690, 88}, // Red_9
                {739, 63}, // Green_9
                {789, 63}, // Blue_9
                {839, 88}, // Yellow_9
                {889, 88}, // Orange_9
                {939, 88}, // Purple_9
                {989, 113}, // Red_10
                {1039, 138}, // Green_10
                {1089, 163}, // Blue_10
                {1089, 213}, // Yellow_10
                {1114, 263}, // Orange_10
                {1139, 313}, // Purple_10
                {1164, 363} // GameEndSquare
        };

        if (coordinates.length == 0) {
            System.out.println("Error: Coordinates array is empty.");
            return;
        }
        head = new Node(0,"Rainbow", 0, "Start",coordinates[0][0]-Math.random()*2-20,coordinates[0][1]-60);
        Node current = head;

        for (int i=1; i<coordinates.length; i++) {
            String color = getColorForSpace(i);

            double x = coordinates[i][0]+Math.random() *2-20;
            double y = coordinates[i][1]+Math.random() *2-60;
            Node newNode = new Node(i, color, 0, "Space "+i,x,y);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        tail = current;

        Node temp = head;
        while (temp != null) {
            System.out.println("Node: "+temp.spaceNumber + ": {"+temp.getX()+", "+temp.getY() + ")");
            temp = temp.next;
        }
    }

    private String getColorForSpace(int spaceNumber) {
        String[] colors = {"Red","Green","Blue","Yellow","Orange","Purple"};
        return colors[spaceNumber % colors.length];
    }

}
