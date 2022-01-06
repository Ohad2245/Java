package Homework.Ex2;

public class Q3<T> {
    private Node head;
    private int size = 0;
    private Node current;
    private Node tail;
//    private int data;


    public Q3() {
        this.head = null;    
        this.size = 0;
    }
    // סיבוכיות של o(n)
    public static void delete(Node head, int x){
        if(head.next == null) {
            return;
        } else if (head.next.data.equals(x)) {
            head.next = head.next.next;
        }
        delete(head.next,x);
    }


}
