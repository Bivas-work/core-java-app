package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseWordsString {
    public String reverseWords(String s) {
        List<String> value = Arrays.stream(s.trim().split(" ")).collect(Collectors.toList());
        value.removeIf(x-> x.equalsIgnoreCase(""));
        Collections.reverse(value);
        return String.join(" ",value);
    }

    public String reverseWordsBetter(String s) {
        String[] arr = s.trim().split(" ");
        StringBuilder result = new StringBuilder("");
        for(int i=arr.length-1;i>=0;i--) {
            if (!arr[i].equalsIgnoreCase(""))
                result.append(arr[i]).append(" ");

        }
        return  result.toString().trim();
    }

    public static void main (String[] args) {
        ReverseWordsString obj = new ReverseWordsString();
        System.out.println("The result : "+ obj.reverseWordsBetter("  the sky    is blue  "));

    }
}
