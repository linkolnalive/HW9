package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue {
    private Object[] data = new Object[0];

    public void add(Object value){
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = value;
    }
    public Object poll() {
        if(data.length == 0){
            throw new NoSuchElementException();
        }
        Object res = data[0];
        data = Arrays.copyOfRange(data, 1, data.length);
        return res;
    }
    public void clear() {
        data = new Object[0];
    }
    public int size() {
        return data.length;
    }
    public Object peek() {
        if(data.length == 0){
            throw new NoSuchElementException();
        }
        return data[0];
    }
    @Override
    public String toString() {
        if (data.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < data.length - 1; i++) {
            res.append(data[i]).append(",");
        }
        res.append(data[data.length - 1]);
        return res.toString();
    }
}