package ru.kpumuk.service;

public class LinkedListCopy<T> {
    protected Node first;
    protected Node last;
    private int size;



    public LinkedListCopy() {

    }

    public void add (T o) {
        Node node = new Node<T>(o);
        if (first == null) {
            this.first = node;
            size++;
            return;
        }
        if (last == null) {
            node.prev = first;
            first.next = node;
            last = node;
            size++;
            return;
        }
        node.prev = last;
        last.next = node;
        last = node;
        size++;

    }

    public boolean remove(int point) {
        if (point > size) {
            return false;
        }
        Node node;
        if (point == 0) {
            node = first.next;
            node.prev = null;
            first.next = null;
            first = node;
            return true;
        } else if (point == size) {
            node = last.prev;
            last.prev = null;
            node.next = null;
            last = node;
            return true;
        }

        node = searchPoint(point, first);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
        return true;
    }

    private Node searchPoint(int pointer, Node node) {
        if (pointer == 0) {
            return node;
        }
        return searchPoint(--pointer, node.next);
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[ ");
        if (first != null) {
            first.print();
        }
        System.out.println("]");
    }
}

class Node<T> {
    private T element;
    protected Node next;
    protected Node prev;

    public Node(T element) {
        this.element = element;
    }

    public Node(T element, Node next, Node prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    void print() {
        if (next == null) {
            System.out.print(this.element.toString() + " ");
        } else {
            System.out.print(this.element.toString() + ", ");
            next.print();
        }
    }


}
