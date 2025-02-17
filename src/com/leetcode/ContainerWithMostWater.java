package com.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int waterArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right -left);
            if (temp > waterArea)
                waterArea = temp;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return waterArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println("The result is " + obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
