package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> result = new Stack<>();
        Arrays.stream(asteroids).forEach(x-> {
            boolean destroyedCurrentAst = false;
            while(!result.isEmpty() &&  !destroyedCurrentAst && AsteroidCollision.willCollide(result.peek(), x)) {
                if(Math.abs(result.peek()) < Math.abs(x)) {
                    result.pop();
                } else if( Math.abs(result.peek()) == Math.abs(x)) {
                    result.pop();
                    destroyedCurrentAst = true;
                } else
                    destroyedCurrentAst = true;

            }
            if(!destroyedCurrentAst) result.add(x);
        });
        return result.stream().mapToInt(i -> i).toArray();

    }
    static boolean willCollide(int x, int y) {
        if(x >0 && y< 0) {
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();
        System.out.println("The result : " +
                Arrays.toString(obj.asteroidCollision(new int[]{8, -8})));
    }
}
