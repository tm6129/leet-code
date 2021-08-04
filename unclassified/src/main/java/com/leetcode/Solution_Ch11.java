package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * 11. Container With Most Water
 *
 * Related topic: Array, Two pointers, Greedy
 *
 */

class Solution_Ch11 {
    public int maxArea(int[] height) {
        int result = 0;
        // int length = height.length;
        // for(int i = 0; i < length; i++){
        //     for(int j = i + 1; j < length; j++){
        //         int area = (j - i) * Math.min(height[i], height[j]);
        //         result = Math.max(result, area);
        //     }
        // }



        int headInedex = 0;
        int tailIndex = height.length - 1;
        while(headInedex != tailIndex){

            int currentArea = (tailIndex - headInedex) * Math.min(height[headInedex], height[tailIndex]);
            result = Math.max(result, currentArea);

            if(height[headInedex] <= height[tailIndex]){
                headInedex++;
            }else{
                tailIndex--;
            }
        }

        return result;
    }
}