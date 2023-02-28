package leetcode;
/*
 * Problem statement below
 * https://leetcode.com/problems/add-two-numbers/description/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 */

import java.util.LinkedList;
import java.util.stream.Collectors;

public class AddTwoNumber {

    LinkedList<Long> l1 = new LinkedList<>();
    LinkedList<Long> l2 = new LinkedList<>();
    
    public void prepareTwoNumbers() {
        l1.addFirst(5L);
        l1.add(6L);
        l1.addLast(7L);

        l2.addFirst(1L);
        l2.add(2L);
        l2.addLast(3L);
        this.printNumbers();
        this.addTwoNumbers();

    }

    public void printNumbers() {
        this.l1.stream().forEach(System.out::print);
        System.out.println();
        this.l2.stream().forEach(System.out::print);
    }

    public void addTwoNumbers() throws NumberFormatException {
        Long num1 = Long.parseUnsignedLong(
                new StringBuilder(this.l1.stream().map(String::valueOf).collect(Collectors.joining())).reverse()
                        .toString());
        System.out.println("The first number is : " + num1);
    }

    

    
}
