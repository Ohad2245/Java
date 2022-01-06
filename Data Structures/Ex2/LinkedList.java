package Homework.Ex2;

import java.util.Random;
import java.util.stream.IntStream;

public class LinkedList<T> implements List<T> {
    private Node head;
    private int size = 0;
    private Node current;
    private Node tail;
//    private int data;

    // When there is one value, it will be the first and last

    public LinkedList() {
        this.head = null; 
        this.size = 0;

    }


    @Override
    public void add(T data) {      
        if (this.head == null)   
            this.head = new Node(data);
        else { 
            Node new_Node = new Node(data); 
            Node temp_head = this.head; 
            while (temp_head.next != null) 
                temp_head = temp_head.next;  
            temp_head.next = new_Node; // 
        }
        size++; //
    }

    // o(n)
    @Override
    public void addFirst(T data) {
        Node temp = new Node(data);
        if (this.head == null)
            this.head = temp;
        else {
            temp.next = this.head; //
            this.head = temp;   
            while (temp.next != null) { 
                temp = temp.next;
            }
        }
        size++;
    }
    // o(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // o(n)
    @Override
    public boolean contains(T data) {
        if (isEmpty())
            return false;
        Node temp_head = this.head;
        while (temp_head != null && temp_head.data != data)
            temp_head = temp_head.next;
        return temp_head != null;
    }

    // o(n)
    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= this.size)
            return null;
        Node temp_head = this.head;
        while (temp_head != null && temp_head.index != index)
            temp_head = temp_head.next;

        assert temp_head != null;
        return (T) temp_head.data;
    }

    // o(1)
    @Override
    public T getFirst() {
        return this.head != null ? (T) this.head.data : null;
    }
    // o(n)
    @Override
    public T getLast() {
        Node temp_head = this.head;
        while (temp_head.next != null)
            temp_head = temp_head.next;
        return (T) temp_head.data;
    }
    // o(1)
    @Override
    public T peek() {
        return this.head != null ? (T) this.head.data : null;
    }



    //Q2
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
        add(this.head, data);   
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

    // Q3
    // o(n)
    public static void delete(Node head, int x){
        if(head.next == null) {
            return;
        } else if (head.next.data.equals(x)) {
            head.next = head.next.next;
        }
        delete(head.next,x);
    }


    // Q4
    // o(n)
    public static LinkedList mergeLists(LinkedList list1, LinkedList list2) {

        if (list1.head == null) return list2;
        if (list2.head == null) return list1;

        // 1, 2 ,3
        // 4, 5, 6

        LinkedList list3 = new LinkedList();
        if ((int) list1.head.data < (int) list2.head.data) {
            list3 = list1;
            list1.head = list1.head.next;
        } else {
            list3 = list2;
            list2.head = list2.head.next;
        }
        LinkedList current_node = list3;
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

