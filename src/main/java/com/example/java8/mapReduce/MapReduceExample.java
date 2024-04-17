package com.example.java8.mapReduce;


import com.example.java8.example.Database;
import com.example.java8.example.Employee;
import com.example.java8.optional.EkartDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {

        List<Integer> numbers  = Arrays.asList(2,3,4,5,6,7,8,8);

        int sum = 0;
        for(int no : numbers){
            sum =sum+no;
        }
        System.out.println(sum);


        //Java8  - nos covert into stream

        numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);


        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodReference);

        Integer reduceMultipleResults = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("multiplica"+reduceMultipleResults);

        Integer maxValue = numbers.stream().reduce(1, (a, b) -> a > b ? a : b);
        System.out.println( maxValue);

        Optional<Integer> reduceMaxValueWithMethodRef = numbers.stream().reduce(Integer::max);
        System.out.println(reduceMaxValueWithMethodRef);

        //Longest String

        List<String> words = Arrays.asList("Arun", "Bangar");
        String longestWord = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(longestWord);


        //getEmployees with grade A
        //get sal
        double avgSal = Database.getEmployees().stream()
                .filter(employee -> employee.getDept().equalsIgnoreCase("IT"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgSal);


    }
}
