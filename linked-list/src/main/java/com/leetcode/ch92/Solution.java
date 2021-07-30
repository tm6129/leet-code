package com.leetcode.ch92;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * 92. Reverse Linked List II
 */

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
    public ListNode reverseBetween(ListNode head, int left, int right) {


        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        int position = 1;

        //[1,2,3,4,5]
        //2
        //4
        //leftNodes used to keep 1
        ListNode leftNodes = null;//for non-reserve nodes starting from head
        ListNode rightNode = null;//for non-reserve nodes starting from right

        while(current != null){

            if(position < left){
                leftNodes = current;
            }
            else if(position >= left && position < right){
                stack.push(current);
            }
            else if(position == right){
                if(left > 1){
                    //[1,2,3,4,5]
                    //2
                    //4
                    //leftNodes.next = current is same as head.next = current, so that 1 can be linked to 4
                    leftNodes.next = current;
                }
                rightNode = current.next;
                current.next = null;
                break;//stop at the right
            }

            current = current.next;
            position++;
        }

        if(left == 1){//The original head must be moved
            head = current;
        }

        while(!stack.empty()){

            ListNode node = stack.pop();
            current.next = node;
            current = node;
        }

        if(rightNode != null){
            current.next = rightNode;//attach the non-reserve right nodes.
        }else{
            current.next = null;//it means we dont have anythings at right, then we cut off.
        }

        return head;
    }
}