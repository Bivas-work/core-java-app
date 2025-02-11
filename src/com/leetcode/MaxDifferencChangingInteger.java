package com.leetcode;

public class MaxDifferencChangingInteger {

    public int maxDiff(int num) {
        String s = String.valueOf(num);
        if(s.length() ==1)
            return 8;
        String b = (s.charAt(0) != '1') ?  s.replace(s.charAt(0), '1'):
                "1"+s.substring(1).replace((char)s.substring(1).chars().filter(x ->
                        (char)x!= '1' && (char)x!= '0'
                ).findFirst().orElse(123), '0');
        String a = (s.charAt(0) != '9') ?   s.replace(s.charAt(0), '9'):
                s.replace((char)s.chars().filter(x ->
                        (char)x!= '9'
                ).findFirst().orElse(123), '9');
        int result = Integer.valueOf(a) -
                Integer.valueOf(b);
        return result;
    }

    public static void main (String[] args) {
        MaxDifferencChangingInteger obj = new MaxDifferencChangingInteger();
        int result = obj.maxDiff(90270580);
        System.out.println(result);
    }
}
