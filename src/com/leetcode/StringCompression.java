package com.leetcode;

/**
 * https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class StringCompression {

    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        System.out.println("The result : " + obj.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
