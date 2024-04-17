package com.example.java8.functionalInterfacedemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        //forEach method - internally uses consumer i/f  - void accept(input p)

        List<String> list = new ArrayList<>();
        list.add("john");
        list.add("piter");
        list.add("mark");
        list.add("mac");
        list.add("arun");
//Traditional Approach
//        for (String s :list){
//            System.out.println(s);
//        }
//using lambda
        //forEach  - accept method of Consumer
//        list.stream().forEach((t) -> System.out.println(t));

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach((key, value) -> System.out.println(key + " : " + value));
        map.entrySet().forEach((object) -> System.out.println(object));

        Consumer<String> consumer = (t) -> System.out.println(t);
        for (String s1 : list) {
            consumer.accept(s1);
        }


//filterMethod  -  used conditional check

        //traditional method
        for (String s : list) {
            if (s.startsWith("a")){
                System.out.println(s);
            }
        }

        //using java8 filter - It internally uses predicate i/f and (boolean test(input t) method)
        list.stream().filter(t -> t.startsWith("p")).forEach(t -> System.out.println(t));

        //filter the map

        map.entrySet().stream().filter(k ->k.getKey()%2==0).forEach(v -> System.out.println(v));

    }
}
