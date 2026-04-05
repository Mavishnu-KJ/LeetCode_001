package com.example;

import java.util.*;

public class LeetCodeSolution {

    /*
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    */
    public int[] twoSum(int[] nums, int target){

        //numberToIndexMap
        HashMap<Integer, Integer> numberToIndexMap = new HashMap<>();

        /*
        Rough
        3,2,4
        0,1,2

        i=0 =>
        compliment = 3, numberToIndexMap.containsKey(compliment) false,  numberToIndexMap {3, 0}
        i = 1 =>
        compliment = 4, numberToIndexMap.containsKey(compliment) false,  numberToIndexMap {3, 0}, {2 ,1}
        i = 2 =>
        compliment = 2, numberToIndexMap.containsKey(compliment), true, return new int[]{1, 2}
        */

        for(int i=0; i<nums.length; i++){

            int compliment = target - nums[i];

            if(numberToIndexMap.containsKey(compliment)){
                return new int[]{numberToIndexMap.get(compliment), i};
            }

            numberToIndexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }

    /*
    Example 1:
    Input: nums = [1,2,3,1]
    Output: true
    */
    public boolean containsDuplicate(int[] nums){

        //UniqueElements Collection
        HashSet<Integer> seenNumberSet = new HashSet<>();

        for(int num : nums){
            if(!seenNumberSet.add(num)){
                return true; //duplicate element found
            }
        }

        return false;
    }

    public boolean isValidAnagram(String s, String t){

        //Edge cases
        if(s.length() != t.length()){
            return false;
        }

        //charArray
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        //countArray
        int[] countArray = new int[26]; //As in the problem, they mentioned only lowercase english letters. Else we can prefer HashMap approach

        //Increase count by sCharArray
        for(char sChar : sCharArray){
            //calculate index by sChar - 'a'
            countArray[sChar - 'a'] = countArray[sChar - 'a'] + 1; //By default, in array, all values initialized to 0. ie, countArray[0] is 0 by default
        }

        //Decrease count by tCharArray
        for(char tChar : tCharArray){
            //Calculate index by tChar - 'a'
            countArray[tChar - 'a'] = countArray[tChar - 'a'] - 1;
        }

        //Check if any value of countArray is not 0, say this is not anagram
        for(int countValue : countArray){
            if(countValue != 0){
                return false; // Not anagram
            }
        }

        return true;

    }

    /*
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    */
    public List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> sortedStringToAnagramListMap = new HashMap<>();

        /*
        Rough
        str=eat =>
        sortedString = aet, map aet = {eat}
        str=tea =>
        sortedString = aet, map aet = {eat, tea}
        str=tan =>
        sortedString = ant, map ant = {tan}
        str=ate =>
        sortedString = aet, map aet = {eat, tea, ate}
        str=nat =>
        sortedString = ant, map ant = {tan, nat}
        str=bat =>
        sortedString = abt, map abt = {bat}

        map [aet = {eat, tea, ate}, ant = {tan, nat}, abt = {bat}]
        */

        for(String str : strs){
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            System.out.println("strCharArray is "+Arrays.toString(strCharArray));
            String sortedString = Arrays.toString(strCharArray); // It works, but, ugly, eg. it will give "[a,e,t]"
            System.out.println("sortedString is "+sortedString);
            String sortedKey = new String(strCharArray); // Better than Arrays.toString(), eg. it will give "aet"
            System.out.println("sortedKey is "+sortedKey);
            sortedStringToAnagramListMap.computeIfAbsent(sortedKey, k->new ArrayList<>()).add(str);
        }

        System.out.println("sortedStringToAnagramListMap is "+sortedStringToAnagramListMap);

        ArrayList<List<String>> resultStringList = new ArrayList<>();
        //ArrayList<List<String>> resultStringList = new ArrayList<>(sortedStringToAnagramListMap.values()); //We can use instead of following commented line approach
        //resultStringList.addAll(sortedStringToAnagramListMap.values()); //We can use instead of following iteration
        for(Map.Entry<String, List<String>> entry : sortedStringToAnagramListMap.entrySet()){
            resultStringList.add(entry.getValue());
        }

        return resultStringList;

    }

}
