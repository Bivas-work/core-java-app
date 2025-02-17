package com.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int countZeros = 0;
        int movingInx = 0;
        for(int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[movingInx++] = nums[i];
            }
            else
                countZeros++;
        }
        while(countZeros > 0) {
            nums[movingInx++] = 0;
            countZeros--;
        }
    }


    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
         obj.moveZeroes(new int[]{0,1,0,3,12});
    }
}
