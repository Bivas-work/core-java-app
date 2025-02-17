package com.leetcode;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; // Add new element, remove old element
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum * 1.0 / k; // Convert to double
    }

    public static void main(String[] args) {
        MaximumAverageSubarray obj = new MaximumAverageSubarray();
        System.out.println("The result is " + String.format("%.5f", obj.findMaxAverage(new int[]{1,12,-5,-6,50,3},4)));
    }
}
