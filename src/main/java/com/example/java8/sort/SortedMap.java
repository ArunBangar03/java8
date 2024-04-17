package com.example.java8.sort;

import com.example.java8.example.Employee;

import java.util.*;

public class SortedMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);


        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

  /*      for (Map.EntryCustomer<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/

        //Java8--> Stream API

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("**********************");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

//********************* If map key contains user object

   /*     Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getSalary() - o1.getSalary());
            }
        });*/
        //Using lambda
        Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));

        employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 50);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 40);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 60);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 90);
        employeeMap.put(new Employee(176, "Prakash", "SOCIAL", 1200000), 100);

//        System.out.println(employeeMap);


        //using lamda

        System.out.println(employeeMap);


        //Using the stream -> on the basis of any field dept/sal anything
employeeMap.entrySet().stream().
        sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
        .forEach(System.out::println);

    }
}
