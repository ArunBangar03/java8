package com.example.java8.sort;

import com.example.java8.example.Database;
import com.example.java8.example.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(3);
        list.add(12);
        list.add(4);


        //traditional way ascending order
        Collections.sort(list);
        System.out.println(list);
        //Descending order
        Collections.reverse(list);
        System.out.println(list);

        //Ascending order
        list.stream().sorted().forEach(t -> System.out.println(t));
        //Desending order
        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.println(t));

        //Sort on specific field - using example package employee

        List<Employee> employees = Database.getEmployees();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
//                return (int) (o1.getSalary() - o2.getSalary());
                return (int) (o2.getSalary() - o1.getSalary());
            }
        });
//        System.out.println(employees);

        //java8 - lambda

        //Ascending order
        Collections.sort(employees,(o1,o2) -> (int)  (o1.getSalary() - o2.getSalary()));
        //Desecnding order
        Collections.sort(employees,(o1,o2) -> (int)  (o2.getSalary() - o1.getSalary()));
//        System.out.println(employees);

//Using Stream API - Lambda expression
//        employees.stream().sorted((o1,o2) -> (int)  (o1.getSalary() - o2.getSalary())).forEach(System.out::println);
//        employees.stream().sorted(Comparator.comparing(emp -> emp.getSalary())).forEach(System.out::println);

      //Sorting using Method reference - you can use any filed to sort the employee class
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

    }
}
