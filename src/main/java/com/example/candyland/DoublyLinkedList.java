package com.example.candyland;


public class DoublyLinkedList {
    private Node startNode;
    private Node endNode;

    public DoublyLinkedList(){
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public Node getStart() {
        return startNode;
    }

    public Node getEnd() {
        return endNode;
    }

    public void initializeBoard() {

        // Create nodes
        Node gameStart = new Node(0, "Start", 0, "Game Start", 66, 624);
        Node red1 = new Node(1, "Red", 0, "Red Square", 66, 574);
        Node yellow1 = new Node(2, "Yellow", 0, "Yellow Square", 116, 574);
        Node green1 = new Node(3, "Green", 0, "Green Square", 166, 574);
        Node blue1 = new Node(4, "Blue", 0, "Blue Square", 216, 574);
        Node orange1 = new Node(5, "Orange", 0, "Orange Square", 266, 574);
        Node purple1 = new Node(6, "Purple", 0, "Purple Square", 316, 574);
        Node red2 = new Node(7, "Red", 0, "Red Square", 366, 574);
        Node green2 = new Node(8, "Green", 0, "Green Square", 416, 574);
        Node blue2 = new Node(9, "Blue", 0, "Blue Square", 466, 574);
        Node yellow2 = new Node(10, "Yellow", 0, "Yellow Square", 516, 574);
        Node orange2 = new Node(11, "Orange", 0, "Orange Square", 566, 574);
        Node purple2 = new Node(12, "Purple", 0, "Purple Square", 615, 574);
        Node pink1Peppermint = new Node(13, "Pink", 0, "Peppermint Square", 665, 574);
        Node red3 = new Node(14, "Red", 0, "Red Square", 714, 574);
        Node green3 = new Node(15, "Green", 0, "Green Square", 764, 574);
        Node blue3 = new Node(16, "Blue", 0, "Blue Square", 814, 574);
        Node yellow3 = new Node(17, "Yellow", 0, "Yellow Square", 864, 574);
        Node orange3 = new Node(18, "Orange", 0, "Orange Square", 914, 574);
        Node purple3 = new Node(19, "Purple", 0, "Purple Square", 964, 549);
        Node red4 = new Node(20, "Red", 0, "Red Square", 989, 499);
        Node green4 = new Node(21, "Green", 0, "Green Square", 939, 474);
        Node blue4 = new Node(22, "Blue", 0, "Blue Square", 889, 449);
        Node yellow4 = new Node(23, "Yellow", 0, "Yellow Square", 839, 424);
        Node orange4 = new Node(24, "Orange", 0, "Orange Square", 789, 424);
        Node purple4 = new Node(25, "Purple", 0, "Purple Square", 739, 424);
        Node pink2Cupcake = new Node(26, "Pink", 0, "Cupcake Square", 689, 424);
        Node red5 = new Node(27, "Red", 0, "Red Square", 640, 424);
        Node green5 = new Node(28, "Green", 0, "Green Square", 591, 424);
        Node blue5 = new Node(29, "Blue", 0, "Blue Square", 541, 424);
        Node yellow5 = new Node(30, "Yellow", 0, "Yellow Square", 491, 424);
        Node orange5 = new Node(31, "Orange", 0, "Orange Square", 441, 409);
        Node purple5 = new Node(32, "Purple", 0, "Purple Square", 391, 384);
        Node red6 = new Node(33, "Red", 0, "Red Square", 341, 359);
        Node green6 = new Node(34, "Green", 0, "Green Square", 291, 334);
        Node blue6 = new Node(35, "Blue", 0, "Blue Square", 241, 309);
        Node yellow6 = new Node(36, "Yellow", 0, "Yellow Square", 191, 285);
        Node orange6 = new Node(37, "Orange", 0, "Orange Square", 141, 284);
        Node purple6 = new Node(38, "Purple", 0, "Purple Square", 91, 260);
        Node pink3Gingerbread = new Node(39, "Pink", 0, "Gingerbread Square", 42, 237);
        Node red7 = new Node(40, "Red", 0, "Red Square", 41, 188);
        Node green7 = new Node(41, "Green", 0, "Green Square", 91, 163);
        Node blue7 = new Node(42, "Blue", 0, "Blue Square", 141, 163);
        Node yellow7 = new Node(43, "Yellow", 0, "Yellow Square", 191, 188);
        Node orange7 = new Node(44, "Orange", 0, "Orange Square", 241, 188);
        Node purple7 = new Node(45, "Purple", 0, "Purple Square", 291, 163);
        Node red8 = new Node(46, "Red", 0, "Red Square", 341, 138);
        Node green8 = new Node(47, "Green", 0, "Green Square", 391, 138);
        Node blue8 = new Node(48, "Blue", 0, "Blue Square", 441, 113);
        Node yellow8 = new Node(49, "Yellow", 0, "Yellow Square", 491, 113);
        Node orange8 = new Node(50, "Orange", 0, "Orange Square", 541, 88);
        Node purple8 = new Node(51, "Purple", 0, "Purple Square", 591, 63);
        Node pink4Candy = new Node(52, "Pink", 0, "Candy Square", 640, 63);
        Node red9 = new Node(53, "Red", 0, "Red Square", 690, 38);
        Node green9 = new Node(54, "Green", 0, "Green Square", 739, 13);
        Node blue9 = new Node(55, "Blue", 0, "Blue Square", 789, 13);
        Node yellow9 = new Node(56, "Yellow", 0, "Yellow Square", 839, 38);
        Node orange9 = new Node(57, "Orange", 0, "Orange Square", 889, 38);
        Node purple9 = new Node(58, "Purple", 0, "Purple Square", 939, 38);
        Node red10 = new Node(59, "Red", 0, "Red Square", 989, 63);
        Node green10 = new Node(60, "Green", 0, "Green Square", 1039, 88);
        Node blue10 = new Node(61, "Blue", 0, "Blue Square", 1089, 113);
        Node yellow10 = new Node(62, "Yellow", 0, "Yellow Square", 1089, 163);
        Node orange10 = new Node(63, "Orange", 0, "Orange Square", 1114, 213);
        Node purple10 = new Node(64, "Purple", 0, "Purple Square", 1139, 263);
        Node gameEnd = new Node(65, "End", 0, "Game End", 1164, 313);

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

        // Linking nodes into a doubly linked list
        gameStart.next = red1;

        red1.prev = gameStart;
        red1.next = green1;

        green1.prev = red1;
        green1.next = blue1;

        blue1.prev = green1;
        blue1.next = yellow1;

        yellow1.prev = blue1;
        yellow1.next = orange1;

        orange1.prev = yellow1;
        orange1.next = purple1;

        purple1.prev = orange1;
        purple1.next = red2;

        red2.prev = purple1;
        red2.next = green2;

        green2.prev = red2;
        green2.next = blue2;

        blue2.prev = green2;
        blue2.next = yellow2;

        yellow2.prev = blue2;
        yellow2.next = orange2;

        orange2.prev = yellow2;
        orange2.next = purple2;

        purple2.prev = orange2;
        purple2.next = pink1Peppermint;

        pink1Peppermint.prev = purple2;
        pink1Peppermint.next = red3;

        red3.prev = pink1Peppermint;
        red3.next = green3;

        green3.prev = red3;
        green3.next = blue3;

        blue3.prev = green3;
        blue3.next = yellow3;

        yellow3.prev = blue3;
        yellow3.next = orange3;

        orange3.prev = yellow3;
        orange3.next = purple3;

        purple3.prev = orange3;
        purple3.next = red4;

        red4.prev = purple3;
        red4.next = green4;

        green4.prev = red4;
        green4.next = blue4;

        blue4.prev = green4;
        blue4.next = yellow4;

        yellow4.prev = blue4;
        yellow4.next = orange4;

        orange4.prev = yellow4;
        orange4.next = purple4;

        purple4.prev = orange4;
        purple4.next = pink2Cupcake;

        pink2Cupcake.prev = purple4;
        pink2Cupcake.next = red5;

        red5.prev = pink2Cupcake;
        red5.next = green5;

        green5.prev = red5;
        green5.next = blue5;

        blue5.prev = green5;
        blue5.next = yellow5;

        yellow5.prev = blue5;
        yellow5.next = orange5;

        orange5.prev = yellow5;
        orange5.next = purple5;

        purple5.prev = orange5;
        purple5.next = red6;

        red6.prev = purple5;
        red6.next = green6;

        green6.prev = red6;
        green6.next = blue6;

        blue6.prev = green6;
        blue6.next = yellow6;

        yellow6.prev = blue6;
        yellow6.next = orange6;

        orange6.prev = yellow6;
        orange6.next = purple6;

        purple6.prev = orange6;
        purple6.next = pink3Gingerbread;

        pink3Gingerbread.prev = purple6;
        pink3Gingerbread.next = red7;

        red7.prev = pink3Gingerbread;
        red7.next = green7;

        green7.prev = red7;
        green7.next = blue7;

        blue7.prev = green7;
        blue7.next = yellow7;

        yellow7.prev = blue7;
        yellow7.next = orange7;

        orange7.prev = yellow7;
        orange7.next = purple7;

        purple7.prev = orange7;
        purple7.next = red8;

        red8.prev = purple7;
        red8.next = green8;

        green8.prev = red8;
        green8.next = blue8;

        blue8.prev = green8;
        blue8.next = yellow8;

        yellow8.prev = blue8;
        yellow8.next = orange8;

        orange8.prev = yellow8;
        orange8.next = purple8;

        purple8.prev = orange8;
        purple8.next = pink4Candy;

        pink4Candy.prev = purple8;
        pink4Candy.next = red9;

        red9.prev = pink4Candy;
        red9.next = green9;

        green9.prev = red9;
        green9.next = blue9;

        blue9.prev = green9;
        blue9.next = yellow9;

        yellow9.prev = blue9;
        yellow9.next = orange9;

        orange9.prev = yellow9;
        orange9.next = purple9;

        purple9.prev = orange9;
        purple9.next = red10;

        red10.prev = purple9;
        red10.next = green10;

        green10.prev = red10;
        green10.next = blue10;

        blue10.prev = green10;
        blue10.next = yellow10;

        yellow10.prev = blue10;
        yellow10.next = orange10;

        orange10.prev = yellow10;
        orange10.next = purple10;

        purple10.prev = orange10;
        purple10.next = gameEnd;

        gameEnd.prev = purple10;

        startNode = gameStart;
        endNode = gameEnd;

        if (coordinates.length == 0) {
            System.out.println("Error: Coordinates array is empty.");
            return;
        }

        Node temp = startNode;
        while (temp != null) {
            System.out.println("Node: "+temp.spaceNumber + ": {"+temp.getX()+", "+temp.getY() + ")");
            temp = temp.next;
        }
    }

}
