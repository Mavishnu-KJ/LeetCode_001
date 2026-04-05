package com.example;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main_Class_Java_Leet_Code_Exercises {
    public static void main() {

        LeetCodeSolution solution = new LeetCodeSolution();

        //001. Two Sum 🔗 https://leetcode.com/problems/two-sum/
        /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

         */

        int[] nums = {3,2,4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        System.out.println("001. twoSum result : "+Arrays.toString(result));

        //002. Contains Duplicate 🔗 https://leetcode.com/problems/contains-duplicate/
        /*
        Example 1:
        Input: nums = [1,2,3,1]
        Output: true
        Explanation:
        The element 1 occurs at the indices 0 and 3.
        */
        int[] nums1 = {1,2,3,1};
        boolean result1 = solution.containsDuplicate(nums1);
        System.out.println("002. Contains Duplicate result1 : "+result1);

        //003. Valid Anagram 🔗 https://leetcode.com/problems/valid-anagram/
        /*
        Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true
        */
        String s = "anagram";
        String t = "nagaram";
        boolean result2 = solution.isValidAnagram(s,t);
        System.out.println("003. Valid Anagram result2 : "+result2);

        String s1 = "rat";
        String t1 = "car";
        boolean result3 = solution.isValidAnagram(s1,t1);
        System.out.println("003. Valid Anagram result3 : "+result3);

        //004. Group Anagrams 🔗 https://leetcode.com/problems/group-anagrams/
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result5 = solution.groupAnagrams(strs);
        System.out.println("004. Group Anagrams result5 : "+result5);

    }
}
