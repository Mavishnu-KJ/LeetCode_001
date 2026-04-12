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
        List<List<String>> result4 = solution.groupAnagrams(strs);
        System.out.println("004. Group Anagrams result5 : "+result4);

        //005. Top K Frequent Elements 🔗 https://leetcode.com/problems/top-k-frequent-elements/
        int[] nums2 = {1,2,1,2,1,2,3,1,3,2};
        int target1 = 2;
        int[] result5 = solution.topKFrequent(nums2, target1);
        System.out.println("005. Top K Frequent Elements result5 : "+Arrays.toString(result5));

        //006. Product of Array Except Self 🔗 https://leetcode.com/problems/product-of-array-except-self/
        /*
        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        */

        int[] nums3 = {1,2,3,4};
        int[] result6 = solution.productExceptSelf(nums3);
        System.out.println("006. Product of Array Except Self result6 : "+Arrays.toString(result6));

        //007. Valid Sudoku 🔗 https://leetcode.com/problems/valid-sudoku/
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        boolean result7 = solution.isValidSudoku(board);
        System.out.println("007. Valid Sudoku result7 : "+result7);

        char[][] board1 = {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        boolean result8 = solution.isValidSudoku(board1);
        System.out.println("007. Valid Sudoku result8 : "+result8);

        //009. Longest Consecutive Sequence 🔗 https://leetcode.com/problems/longest-consecutive-sequence/
        /*
        Example 1:
        Input: nums = [100,4,200,1,3,2, 7, 8, 9, 55, 56, 57, 58, 59]
        Output: 5
        Explanation: The longest consecutive elements sequence is [55, 56, 57, 58, 59]. Therefore its length is 5.
        */
        int[] nums4 = {100,4,200,1,3,2, 7, 8, 9, 55, 56, 57, 58, 59};
        int result9 = solution.longestConsecutive(nums4);
        System.out.println("009. Longest Consecutive Sequence result9 : "+result9);

        //010. Valid Palindrome 🔗 https://leetcode.com/problems/valid-palindrome/
        /*
        Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
        */

        String s2 = "A man, a plan, a canal: Panama";
        boolean result10 = solution.isPalindrome(s2);
        System.out.println("010. Valid Palindrome result10 : "+result10);

        String s3 = "race a car";
        boolean result11 = solution.isPalindrome(s3);
        System.out.println("010. Valid Palindrome result11 : "+result11);

        String s4 = "    ";
        boolean result12 = solution.isPalindrome(s4);
        System.out.println("010. Valid Palindrome result12 : "+result12);

        //011. Longest Substring Without Repeating Characters 🔗 https://leetcode.com/problems/longest-substring-without-repeating-characters/
        /*
        Example
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
         */

        String s5 = "appa";
        int result13 = solution.lengthOfLongestSubstring(s5);
        System.out.println("011. Longest Substring Without Repeating Characters result13 : "+result13);



    }
}
