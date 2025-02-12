package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
        System.out.println("The result : "+ obj.increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
