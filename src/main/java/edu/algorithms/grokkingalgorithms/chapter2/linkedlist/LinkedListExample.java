package edu.algorithms.grokkingalgorithms.chapter2.linkedlist;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class Node<T> {
    private T item;
    private Node next;
    private Node prev;

    public Node(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

//TODO make implements Iterable
//TODO make implements List
public class LinkedListExample implements Iterable {

    private Node head;
    private Node tail;

    public static void main(String[] args) {
        LinkedListExample linkedListExample = new LinkedListExample();
        linkedListExample.add(new Node<>("qwe"));
        linkedListExample.add(new Node<>("asd"));
        linkedListExample.add(new Node<>("zxc"));

        System.out.println(linkedListExample.getHead().getItem());
        System.out.println(linkedListExample.getHead().getNext().getItem());
        System.out.println(linkedListExample.getHead().getNext().getNext().getItem());
    }

    public boolean add(Node item) {
        if (isEmpty()) {
            head = item;
            tail = item;
        } else {
            tail.setNext(item);
            item.setPrev(tail);
            tail = item;
        }
        return true;
    }

    public void removeLast(){
        tail = tail.getPrev();
        tail.setNext(null);
    }

    private boolean isEmpty() {
        return head == null;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
