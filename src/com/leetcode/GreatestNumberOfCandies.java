package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> candiesResult = new ArrayList<>();
        int maxNumOfCandy = Arrays.stream(candies).max().getAsInt();
        Arrays.stream(candies).parallel().forEach(x-> candiesResult.add(x+extraCandies >= maxNumOfCandy));
        return candiesResult;
    }

    public static void main (String[] args) {
        GreatestNumberOfCandies obj = new GreatestNumberOfCandies();
        int[] inputArr = {2,3,5,1,3};
        List<Boolean> result = obj.kidsWithCandies(inputArr, 3);
        result.forEach(System.out::println);
    }
}
