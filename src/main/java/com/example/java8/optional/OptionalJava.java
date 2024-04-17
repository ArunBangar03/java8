package com.example.java8.optional;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalJava {

    public static Customer getCustomerbyEmailID(String email) throws Exception {
        List<Customer> customers = EkartDataBase.getAll();

        return customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
//                .findAny().get();
                .findAny().orElseThrow(() -> new Exception("No customer presemt with email id"));
    }
        public static void main(String[] args) throws Exception {



//        Customer customer = new Customer(101, "john", null, Arrays.asList("33444", "789437"));
            Customer customer = new Customer(101, "john", null, Arrays.asList("33444", "789437"));
            //empty() -
            //of()  - If object is never null then got for it
            //ofNullable - If we know object is may or may not be null then go for of nullable

            Optional<Object> emptyOptional = Optional.empty();
            System.out.println(emptyOptional);

            Optional<String> emailOptional = Optional.ofNullable(String.valueOf(customer.getEmail()));
            System.out.println(emailOptional);

//        Optional<String> emailOprional1 = Optional.of(customer.getEmail());
//        System.out.println(emailOprional1);

            System.out.println(emailOptional);
            //orElseThrow
            //orElse
            //orElseGet with Map

            Optional.ofNullable(customer.getEmail());
            System.out.println(emailOptional.map(String::toUpperCase).orElseGet(() -> "Default email"));

            OptionalJava.getCustomerbyEmailID("fgc@test.com");

        }
    }