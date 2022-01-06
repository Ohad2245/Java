package Homework.Ex2;

 public class Node<T> {
     int index;
     T data;
     Node next;
     Node prev;

    public Node(T data) {
        this.data =  data;
        this.next = null;
        this.prev = null;

    }

}
