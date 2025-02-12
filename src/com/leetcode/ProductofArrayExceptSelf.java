package com.leetcode;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1;
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }

    public static void main (String[] args) {
        ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
        System.out.println("The result : "+ obj.productExceptSelf(new int[]{1,2,3,4}));
    }
}
