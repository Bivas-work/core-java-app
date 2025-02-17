package com.leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxNumberVowelsSubstringGivenLength {

    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int maxVow = 0;
        for(int i =0;i< k; i++) {
            if(vowels.indexOf(s.charAt(i))>= 0)
                maxVow++;
        }
        int temp = maxVow;
        for(int i=1; i<= s.length()-k;i++) {
            temp += (vowels.indexOf(s.charAt(i+k-1))>= 0)?1:0;
            temp -= (vowels.indexOf(s.charAt(i-1))>= 0)?1:0;
            maxVow = Math.max(maxVow, temp);
        }
    return  maxVow;
    }

    public static void main(String[] args) {
        MaxNumberVowelsSubstringGivenLength obj = new MaxNumberVowelsSubstringGivenLength();
        System.out.println("The result is " + obj.maxVowels("abciiidef",3));
    }
}
