package com.leetcode;

import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int maxResult = 0;
        PriorityQueue<Integer> nums1Pq = new PriorityQueue<>();
        PriorityQueue<Integer> nums2Pq = new PriorityQueue<>();
        for(int j = 0; j< nums1.length; j++) {
            
        }
        while (i < nums1.length) {
            nums1Pq.add(nums1[i]);
            nums2Pq.add(nums2[i]);
            i++;
        }
        return  maxResult;
    }

    public static void main(String[] args) {
        MaximumSubsequenceScore obj = new MaximumSubsequenceScore();
        System.out.println("The result is " + obj.maxScore(new int[]{1,2},
                new int[]{1,2}, 2));
    }
}
