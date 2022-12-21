package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Aman", "Kajal",
                "Joyita", "Das");
        System.out.println("before sorting");
        stringList.forEach(System.out::println);

        System.out.println("After sorting");
        stringList.sort(Comparator.reverseOrder());
        stringList.forEach(System.out::println);

        sortReverseNumber();
        comp();
    }

    public static void sortReverseNumber(){
        List<Integer> values = Arrays.asList(212, 324,
                435, 566,
                133, 100,
                121);

        values.sort(Comparator.reverseOrder());
        System.out.println(values);

    }
    public static void comp(){
        String[] arrayString = { "aman", "amar", "avik" };
        System.out.println("before sort : "
                + Arrays.toString(arrayString));
        Comparator<String> comper = (String::compareTo);
        Arrays.sort(arrayString,comper.reversed());
        System.out.println("after sort : "
                + Arrays.toString(arrayString));




    }
 }