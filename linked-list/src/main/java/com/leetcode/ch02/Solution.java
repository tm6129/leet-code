package com.leetcode.ch02;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * 2. Add Two Numbers
 */

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * My method
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoNumbers(l1, l2, 0);
    }

    /**
     *  My method
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry){

        ListNode result = null;

        if(l1 == null && l2 == null){
            return result;
        }else{

            result = new ListNode(0);

            int newVal = 0;

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;

            if(sum >= 10){
                carry = 1;
                newVal = sum - 10;
            }else{
                carry = 0;
                newVal = sum;
            }

            result.val = newVal;

            if(l1.next != null || l2.next != null || carry > 0){

                if(l1.next == null){
                    l1.next = new ListNode(0);
                }

                if(l2.next == null){
                    l2.next = new ListNode(0);
                }

                result.next = addTwoNumbers(l1.next, l2.next, carry);
            }

        }
        return result;
    }


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_Sample(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}