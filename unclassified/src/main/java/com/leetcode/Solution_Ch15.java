package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * 15. 3Sum
 *
 * Related topic: Array, Two pointers, Sorting
 *
 */

class Solution_Ch15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++){

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}