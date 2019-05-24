package com.company;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        int[] numbers = { 4, 6, 8, 3, 7, 9, 2, 12};
        System.out.println(findPairThatFormNumber(numbers, 11));
    }

    public static List<List<Integer>> findPairThatFormNumber(int[] numbers, int n) {
        List<List<Integer>> result = new ArrayList<>();


        Arrays.sort(numbers);
        List<Integer> integers =  Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        for(int i =0;i<integers.size(); i++){
            if(integers.get(i) >= n)
                return result;

            int indexSecondNumber = integers.indexOf(n - integers.get(i));

            if(indexSecondNumber != -1){
                result.add(Arrays.asList(integers.get(i), integers.get(indexSecondNumber)));
                integers = integers.subList(0, indexSecondNumber);
            }

        }
        return result;
    }


}