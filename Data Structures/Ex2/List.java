package Homework.Ex2;

public interface List<T> {

    void add(T data);

    void addFirst(T data);

    boolean isEmpty();

    boolean contains(T data);

    T get(int index);

    T getFirst();

    T getLast();

    T peek();

}
