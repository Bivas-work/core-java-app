package leetcode;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int targetArray[]=new int[nums.length];
        int targetArrayIndex= 0;
        //{2,7,11,15}
       for(int i=0;i<nums.length;i++) {
           for (int j=i+1;j<nums.length;j++) {
               if(nums[i]+nums[j] == target) {
                targetArray[targetArrayIndex++]=i;
                targetArray[targetArrayIndex++]=j;
               }
           }
       } 
       System.out.println(Arrays.toString(targetArray));
       return targetArray;
    }
}