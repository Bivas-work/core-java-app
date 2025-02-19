package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MaximumTwinSumLinkedList {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        Stack<Integer> revList = new Stack<>();
        ListNode originalHead = head;
        while(head != null) {
            revList.add(head.val);
            head = head.next;
        }
        head = originalHead;
        int maxTwinSum  = 0;
        for(int i =revList.size()-1; i>=(revList.size()/2) -1; i--) {
            maxTwinSum = Math.max(maxTwinSum,head.val+ revList.get(i));
            head = head.next;
        }
        return maxTwinSum;
    }

    public static void main(String[] args) {
        MaximumTwinSumLinkedList obj = new MaximumTwinSumLinkedList();
        List<Integer> data = Arrays.stream(new int[] {4,2,2,3}).boxed().collect(Collectors.toList());
        ListNode head = obj.populateData(data);
        int results = obj.pairSum(head);
        System.out.println("The result is " + results);
    }

    public ListNode populateData(List<Integer> data) {
        ListNode head = new ListNode();
        ListNode originalHead = head;
        for(int v: data) {
            head.next = new ListNode();
            head = head.next;
            head.val = v;

        }
        originalHead = originalHead.next;
        return originalHead;
    }
}
