package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int inx = 0;
        for(int i=0; i< s.length(); i++) {
            inx = t.indexOf(s.charAt(i));
            if(inx <0)
                return false;
             t = (inx+1 >= t.length())? "": t.substring(inx+1);
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        System.out.println("The result is " + obj.isSubsequence("aaaaaa", "bbaaaa"));
    }
}
