package org.example;

public class MyLinkedList {
    Node head = null;
    static class Node {
        private final Object data;
        private Node next = null;
        private Node previous;
        Node(Node previousNode, Object value) {
            data = value;
            previous = previousNode;
        }
    }
    public void add(Object value) {
        if (head == null) {
            head = new Node(null, value);
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(last, value);
        }
    }
    public void remove(int index) {
        int counter = 0;
        Node last = head;
        while(counter < index && last != null) {
            last = last.next;
            counter++;
        }
        if (last == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (last.previous == null) {
            if (last.next != null) {
                last.next.previous = null;
            }
            head = last.next;
        } else {
            last.previous.next = last.next;
            if (last.next != null) {
                last.next.previous = last.previous;
            }
        }
    }
    public void clear() {
        head = null;
    }
    public int size() {
        int res = 0;
        Node last = head;
        while(last != null) {
            last = last.next;
            res++;
        }
        return res;
    }
    public Object get(int index) {
        int counter = 0;
        Node last = head;
        while(counter < index && last != null) {
            last = last.next;
            counter++;
        }
        if (last == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return last.data;
    }
    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Node last = head;
        while (last.next != null) {
            res.append(last.data).append(",");
            last = last.next;
        }
        res.append(last.data);
        return res.toString();
    }
}