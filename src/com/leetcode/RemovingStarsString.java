package com.leetcode;
/**
 * https://leetcode.com/problems/removing-stars-from-a-string/submissions/1546264335/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Stack;

public class RemovingStarsString {

    public String removeStars(String s) {
        StringBuilder result = new StringBuilder("");
        Stack<Character> sStack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != '*')
                sStack.push(c);
            else
                sStack.pop();
        }
        while(!sStack.isEmpty())
            result.append(sStack.pop());
        return  result.reverse().toString();
    }

    public static void main(String[] args) {
        RemovingStarsString obj = new RemovingStarsString();
        System.out.println("The result is " + obj.removeStars("leet**cod*e"));
    }
}
