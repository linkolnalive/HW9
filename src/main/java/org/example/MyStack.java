package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack {
    private Object[] data = new Object[0];

    public void push(Object value) {
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = value;
    }
    public void remove(int index) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] res = new Object[data.length - 1];
        for(int i = 0; i < data.length; i++) {
            if(i < index) {
                res[i] = data[i];
            }
            if(i > index) {
                res[i - 1] = data[i];
            }
        }
        data = res;
    }
    public Object pop() {
        if (data.length == 0) {
            throw new NoSuchElementException();
        }
        Object res = data[data.length - 1];
        data = Arrays.copyOfRange(data, 0, data.length - 1);
        return res;
    }
    public void clear() {
        data = new Object[0];
    }
    public int size() {
        return data.length;
    }
    public Object peek() {
        if (data.length == 0) {
            throw new NoSuchElementException();
        }
        return data[data.length - 1];
    }
    @Override
    public String toString() {
        if (data.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length - 1; i++) {
            res.append(data[i]).append(",");
        }
        res.append(data[data.length - 1]);
        return res.toString();
    }
}