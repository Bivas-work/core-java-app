package com.leetcode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/1568058573/?envType=study-plan-v2&envId=leetcode-75
 */
public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        ListNode originalHead = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        if(size ==1)
            return  null;
        head = originalHead;
        int midNode  = size/2;
        int nav = 0;
        ListNode prev = null;
        while(nav< midNode) {
            prev = head;
            head = head.next;
            nav++;
        }
         prev.next = head.next;
        return originalHead;
    }

    public static void main(String[] args) {
        DeleteMiddleNode obj = new DeleteMiddleNode();
        ListNode node = new ListNode(1);
        node.next = null;
        System.out.println("The result : " +
                obj.deleteMiddle(node));
    }

    static class ListNode {
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
}
