package com.leetcode;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindHighestAltitude {


    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length+1];
        altitudes[0] = 0;
        int maxAlt = 0;
        for(int i =0;i<gain.length;i++) {
            altitudes[i+1] = gain[i] + altitudes[i];
            maxAlt = Math.max(maxAlt, altitudes[i+1]);
        }
        return maxAlt;
    }

    public static void main(String[] args) {
        FindHighestAltitude obj = new FindHighestAltitude();
        System.out.println("The result is " + obj.largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }

}
