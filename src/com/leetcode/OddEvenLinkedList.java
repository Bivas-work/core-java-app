package com.leetcode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even!=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();
        OddEvenLinkedList.ListNode node = new OddEvenLinkedList.ListNode(1);
        node.next = null;
        System.out.println("The result : " +
                obj.oddEvenList(node));
    }

    static class ListNode {
        int val;
        OddEvenLinkedList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, OddEvenLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
