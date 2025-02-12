package com.leetcode;


/**
 * https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerbedSize = flowerbed.length;
        for (int i = 0; i < flowerbedSize && n > 0; i++) {
            boolean prev = i == 0 || flowerbed[i - 1] == 0;
            boolean fut = i == flowerbedSize - 1 || flowerbed[i + 1] == 0;
            if (prev && fut && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public static void main (String[] args) {
        CanPlaceFlowers obj = new CanPlaceFlowers();
        int[] inputArr = {0,0,1,0,0};
        System.out.println("The result : "+ obj.canPlaceFlowers(inputArr, 1));

    }
}
