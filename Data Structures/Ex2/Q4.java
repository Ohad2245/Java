package Homework.Ex2;

public class Q4 {

    private Node head;
    private int size = 0;
    private Node current;
    private Node tail;
//    private int data;


    public Q4() {
        this.head = null; 
        this.size = 0;

    }

    // o(n)
    public static Q4 mergeLists(Q4 list1, Q4 list2) {

        if (list1.head == null) return list2;
        if (list2.head == null) return list1;

        // 1, 2 ,3
        // 4, 5, 6

        Q4 list3 = new Q4();
        if ((int) list1.head.data < (int) list2.head.data) {
            list3 = list1;
            list1.head = list1.head.next;
        } else {
            list3 = list2;
            list2.head = list2.head.next;
        }
        Q4 current_node = list3;
        while (true) {
            if (list1.head == null || list2.head == null) break;
            if ((int) list1.head.data < (int) list2.head.data) {
                current_node.head.next = list1.head;
                list1.head = list1.head.next;
            } else {
                current_node.head.next = list1.head;
                list2.head = list2.head.next;
            }
            current_node.head = current_node.head.next;
        }
        if (list1 == null) {
            current_node.head.next = list2.head;
        } else {
            current_node.head.next = list1.head; //
        }
        return list3;
    }
}

