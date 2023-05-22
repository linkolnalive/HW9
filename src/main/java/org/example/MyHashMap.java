package org.example;

import java.util.NoSuchElementException;

public class MyHashMap {
    private final int arraySize;
    Node[] data;
    static class Node {
        private final Object key;
        private final Object value;
        private Node next;

        Node (Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap(int arraySize) {
        this.arraySize = arraySize;
        this.data = new Node[arraySize + 1];
    }
    public void put(Object key, Object value) {
        if (key == null) {
            data[data.length - 1] = new Node(key, value, data[data.length - 1]);
        } else if (data[key.hashCode() % arraySize] == null) {
            data[key.hashCode() % arraySize] = new Node(key, value, null);
        } else {
            Node curr = data[key.hashCode() % arraySize];
            boolean found = false;
            while (curr != null) {
                if (key.equals(curr.key) && value.equals(curr.value)) {
                    found = true;
                    break;
                }
                curr = curr.next;
            }
            if (!found) {
                data[key.hashCode() % arraySize] = new Node(key, value, data[key.hashCode() % arraySize]);
            }
        }
    }
    public void remove(Object key) {
        if (key == null) {
            if (data[data.length - 1] == null) {
                throw new NoSuchElementException();
            } else {
                data[data.length - 1] = data[data.length - 1].next;
            }
        } else {
            Node curr = data[key.hashCode() % arraySize];
            if (key.equals(curr.key)) {
                data[key.hashCode() % arraySize] = curr.next;
            } else if (curr.next == null) {
                throw new NoSuchElementException();
            } else {
                Node prev = data[key.hashCode() % arraySize];
                curr = curr.next;
                while (curr != null) {
                    if (key.equals(curr.key)) {
                        prev.next = curr.next;
                        return;
                    }
                    curr = curr.next;
                    prev = prev.next;
                }
                throw new NoSuchElementException();
            }
        }
    }
    public void clear() {
        data = new Node[arraySize + 1];
    }
    public int size() {
        int res = 0;
        for (Node datum : data) {
            if (datum != null) {
                Node curr = datum;
                while (curr != null) {
                    res++;
                    curr = curr.next;
                }
            }
        }
        return res;
    }
    public Object get(Object key) {
        if (key == null) {
            if (data[data.length - 1] != null) {
                return data[data.length - 1].value;
            } else
                throw new NoSuchElementException();
        } else if (data[key.hashCode() % arraySize] == null) {
            throw new NoSuchElementException();
        } else {
            Node curr = data[key.hashCode() % arraySize];
            while (curr != null) {
                if (key.equals(curr.key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            throw new NoSuchElementException();
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node datum : data) {
            Node curr = datum;
            while (curr != null) {
                res.append(curr.key).append(" - ").append(curr.value).append('\n');
                curr = curr.next;
            }
        }
        return res.toString();
    }
}