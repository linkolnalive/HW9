package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.remove(2);
//        myLinkedList.remove(1);
//        myLinkedList.remove(0);

        System.out.println(myLinkedList.size());
        //System.out.println(myLinkedList.get(-2));
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(2));
        myLinkedList.clear();
        System.out.println(myLinkedList);
        //System.out.println(myLinkedList.get(6));


//        myArrayList.add(1);
//        myArrayList.add("2");
//        myArrayList.add("3");
//        myArrayList.add("4");
//        myArrayList.add("5");
//        myArrayList.add("6");
//        myArrayList.add("7");
//
//        System.out.println(myArrayList.get(3));
//        System.out.println(myArrayList.size());
//
//        myArrayList.remove(3);
//
//        System.out.println(myArrayList.get(3));
//        System.out.println(myArrayList.size());
//        System.out.println(myArrayList);
//
//        myArrayList.clear();
//
//        System.out.println(myArrayList.size());
    }
}