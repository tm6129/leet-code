package com.leetcode.ch03;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 3. Longest Substring Without Repeating Characters
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;

        int left = 0;
        int right = 0;

        int size = 0;



        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新


            map.put(c, map.getOrDefault(c, 0) + 1);


            // 判断左侧窗口是否要收缩
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                map.put(d, map.getOrDefault(d, 0) - 1);
            }
            // 在这里更新答案
            result = Math.max(result, right - left);
        }


        /*
        while(right < s.length()){

            char c = s.charAt(right);

            if(map.containsKey(c)){

                result = Math.max(result, Math.max(size, right - left));

                if(left < map.get(c) + 1){
                    left = map.get(c) + 1;
                }
                map.put(c, right);

                size = right - left + 1;

                //System.out.println(map + ", result:" + result + ", right:" + right + ",left:" + left);

            }else{

                map.put(c, right);

                size++;

                result = Math.max(size, result);

                 //System.out.println(map + ", result:" + result + ", right:" + right + ",left:" + left);
            }

            right++;
        }

        result = Math.max(size, result);
       // System.out.println(map + ", result:" + result + ", right:" + right + ",left:" + left);

        */



        return result;

    }
}