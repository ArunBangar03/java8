package com.example.java8.functionalInterfacedemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//public class SupplierIFDemo implements Supplier<String> {
public class SupplierIFDemo {

 /*   @Override
    public String get() {
        return "Hello";
    }*/

    public static void main(String[] args) {
  /*      Supplier<String>supplier = new SupplierIFDemo();
        System.out.println( supplier.get());*/

        Supplier<String> supplier = () -> "Hello with Lambda ";
//        System.out.println(supplier.get());

        List<String> list1 = Arrays.asList();
        System.out.println(list1.stream().findAny().orElseGet(() -> "lambda with hello"));

    }
}
