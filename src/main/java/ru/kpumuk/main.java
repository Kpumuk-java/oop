package ru.kpumuk;

import ru.kpumuk.service.ArrayListCopy;
import ru.kpumuk.service.LinkedListCopy;

import java.lang.reflect.Array;
import java.util.*;

public class main {


    public static void main(String[] args) {
        /*ArrayListCopy<Integer> list = new ArrayListCopy<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.insert(3, 7);

        System.out.println(list.toString());

        list.remove(5);

        System.out.println(list.toString());*/

        List<Integer> list = new LinkedList<>();

        list.

        LinkedListCopy<Integer> linkedListCopy = new LinkedListCopy<>();
        linkedListCopy.add(1);
        linkedListCopy.add(2);
        linkedListCopy.add(3);
        linkedListCopy.add(4);
        linkedListCopy.add(5);

        linkedListCopy.print();

    }
}
