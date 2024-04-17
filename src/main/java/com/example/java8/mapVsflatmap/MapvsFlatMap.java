package com.example.java8.mapVsflatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {
    public static void main(String[] args) {
        List<Customer> customers = EkartDataBase.getAll();
        System.out.println(customers);
        //List of customer  -  convert List<String > -> Data transformation

        //mapping  :  customer -> customer.getEmail()
        //customer -> customer.getEmail()  == One to one mapping
        List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhonenumber()  ->> one many mapping
        //nested list  - we can go for flat map

        List<List<String>> phonenumbers = customers.stream().map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phonenumbers); //[[397937955, 21654725], [89563865, 2487238947], [38946328654, 3286487236], [389246829364, 948609467]]

        List<String> phonenumbers1 = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phonenumbers1); //[397937955, 21654725, 89563865, 2487238947, 38946328654, 3286487236, 389246829364, 948609467]


    }
}
