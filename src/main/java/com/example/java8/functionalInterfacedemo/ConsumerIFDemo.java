package com.example.java8.functionalInterfacedemo;

import java.util.Arrays;
import java.util.List;

public class ConsumerIFDemo {
    /*@Override
    public void accept(Integer integer) {

    }*/

    public static void main(String[] args) {
/*        Consumer<Integer> consumer =  (t) -> System.out.println("Consumer i/f - " +t);
        consumer.accept(245);*/

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,5);
        list1.stream().forEach(t -> System.out.println("List is - " + t));

    }
}
