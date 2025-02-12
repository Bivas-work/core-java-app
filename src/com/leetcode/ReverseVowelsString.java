package com.leetcode;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseVowelsString {

    public String reverseVowels(String s) {
        List<String> vowelsList = Stream.of(new String[]{"A", "E", "I", "O", "U"}).collect(Collectors.toList());
        char[] charArray = s.toCharArray();
        int right = s.length()-1;
        for(int left =0; left <= right; left++) {
            if (vowelsList.contains(String.valueOf(charArray[left]).toUpperCase())) {
                while (right > left && !vowelsList.contains(String.valueOf(charArray[right]).toUpperCase())) {
                    right--;
                }
                char c = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = c;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    public static void main (String[] args) {
        ReverseVowelsString obj = new ReverseVowelsString();
        System.out.println("The result : "+ obj.reverseVowels("a."));

    }
}
