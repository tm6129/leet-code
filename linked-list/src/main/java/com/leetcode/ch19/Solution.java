package com.leetcode.ch19;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 19. Remove Nth Node From End of List
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
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //ListNode result = head;

        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current);
            current = current.next;
        }

        // for(int i = 0; i < list.size(); i++){
        //     System.out.println(list.get(i).val);
        // }


        int toBeRemovedIndex = list.size() - n;
        int prevIndex = toBeRemovedIndex - 1;

        if(list.size() == n){//remove head
            ListNode headNext = head.next;
            head.next = null;
            head = headNext;

        }else if(n == 1){

            ListNode prevNode = list.get(prevIndex);
            prevNode.next = null;

        }else{

            ListNode toBeRemovedNode = list.get(toBeRemovedIndex);
            ListNode prevNode = list.get(prevIndex);
            prevNode.next = toBeRemovedNode.next;


        }

        return head;



    }


    /**
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_Sample(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}