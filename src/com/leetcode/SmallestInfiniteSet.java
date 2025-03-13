package com.leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75
 */
public class SmallestInfiniteSet {
    TreeSet<Integer> pq = new TreeSet<>();
    int i =1;
    public SmallestInfiniteSet() {
        while(pq.size() < 1000) {
            pq.add(i++);
        }

    }

    public int popSmallest() {
        return pq.pollFirst();
    }

    public void addBack(int num) {
        pq.add(num);
    }


    public static void main(String[] args) {
        Dota2Senate obj = new Dota2Senate();
        System.out.println("The result is " + obj.predictPartyVictory("RDD"));
    }
}
