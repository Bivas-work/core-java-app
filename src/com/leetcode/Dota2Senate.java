package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 */
public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        int n = senate.length();
        for(int i = 0;i < n;i++){
            if(senate.charAt(i) == 'R') qr.add(i);
            else qd.add(i);
        }
        for(;!qr.isEmpty() && !qd.isEmpty();){
            int r_i = qr.poll();
            int d_i = qd.poll();
            if(r_i < d_i) qr.add(r_i + n);
            else qd.add(d_i + n);
        }
        return qr.size() > qd.size() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate obj = new Dota2Senate();
        System.out.println("The result is " + obj.predictPartyVictory("RDD"));
    }
}
