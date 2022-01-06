package Homework.Ex2;

import java.util.Random;

public class Q2<T> extends LinkedList<T> {

    private Node head;
    private int size = 0;
    private Node current;
    private Node tail;
//    private int data;


    public Q2() {
        this.head = null; 
        this.size = 0;
    }
    // o(n)
    public void add(Node current, T data) {
        if (current.next == null) {
            Node new_node = new Node(data);
            new_node.prev = this.tail;
            current.next = new_node;
            this.tail = new_node;
        } else {
            add(current.next, data);
        }
    }
    // o(1)
    public void anotherAdd(T data) {
        if (this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node new_Node = new Node(data);
            Node temp_head = this.head;
        }
        add(this.head, data); // במקום הלולאה
        size++;
    }
    // o(1)
    public T remove(int index) {
        if (isEmpty() || index < 0 || index >= size)
            return null;
        if (index == 0) {
            Node temp_node = head;
            this.head = this.head.next;
            size--;
            return (T) temp_node.data;
        }
        return
                remove(head.next, 1, index);
    }

    // o(n)
    public T remove(Node node, int index, int current) {
        if (node == null) return null;
        if (current == index) {
            Node temp_node = node.prev; 
            temp_node.next = head.next; 
            Node temp_node2 = node.next;
            temp_node2.prev = temp_node;
            size--;
            return (T) node.data;
        }
        return
                remove(node.next, index, current + 1);
    }

    public static void main(String[] args) {
        Random rd = new Random();
        Q2 list = new Q2();
        for (int i = 0; i < 5; i++) {
            list.add(rd.nextInt(70));
        }
        System.out.println(list);
        System.out.println(list.remove(2));
        System.out.println(list);
    }


}
