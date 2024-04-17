package com.example.java8.functionalInterfacedemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PrdicateIFDemo {
    public static void main(String[] args) {

        Predicate<Integer> predicate =  (t) -> t%2 == 0;
        System.out.println(predicate.test(5));

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,5);
        list1.stream().filter((t) -> t%2 == 0).forEach(t-> System.out.println("Print evemn  -  "+ t));
    }
}
