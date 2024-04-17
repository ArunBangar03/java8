package com.example.java8.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {
    public static List<Employee> evaluateTaxPayers(String input) {

        return (input.equalsIgnoreCase("tax"))
                ? Database.getEmployees().stream().filter(sal -> sal.getSalary() > 500000).collect(Collectors.toList())
                : Database.getEmployees().stream().filter(sal -> sal.getSalary() <= 500000)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(evaluateTaxPayers("non tax"));
    }

}
