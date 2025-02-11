package com.leetcode;
import java.util.*;
import java.util.stream.IntStream;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        String shortLength = word1;
        String longLength = word2;
        if(word1.length() > word2.length()) {
            shortLength = word2; longLength = word1;
        }
        else {
            shortLength = word1; longLength = word2;
        }
        for(int i =0; i< shortLength.length(); i++) {
            result += String.valueOf(word1.charAt(i)) + word2.charAt(i);
        }
        if (shortLength.length() != longLength.length())
            result += longLength.substring(shortLength.length());
        return result;
    }

    public static void main (String[] args) {
        MergeStringsAlternately obj = new MergeStringsAlternately();
        System.out.println("The result : "+ obj.mergeAlternately("abcd", "pq"));


    }
}
