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



    /*
    Input: nums = [1,2,2,2,2,3,3,4,4,4,4,4,4], k = 2
    Output: [4,2] or [2,4]
    */
    public int[] topKFrequent(int[] nums, int k){

        //HashMap number -> frequency
        HashMap<Integer, Integer> numberToFrequencyMap = new HashMap<>();

        for (int num : nums) {

            numberToFrequencyMap.put(num,
                    numberToFrequencyMap.getOrDefault(num, 0) + 1);

        }

        /*
        Rough
        numberToFrequencyMap [{1, 1}, {2, 4}, {3, 2}, {4, 6}]
        worst case nums{1,2,3,4} - So, bucket length can nums.length
        bucketArray[1] = 1
        bucketArray[4] = 2
        bucketArray[2] = 3
        bucketArray[6] = 4

        bucketArray[1] = 1
        bucketArray[2] = 3
        bucketArray[4] = 2
        bucketArray[6] = 4

        resultArray[0] = 4
        resultArray[1] = 2

        */

        //Bucket array of List storage (use frequency as bucket index)
        List<Integer>[] bucketArrayOfList = new List[nums.length + 1];

        //Initialize bucketArrayOfList with empty list must - to avoid nullpointer exception in further steps
        for(int i=0; i<bucketArrayOfList.length; i++){
            bucketArrayOfList[i] = new ArrayList<>(); //Creating empty ArrayList
        }

        //Use frequency as bucketArrayOfList index and add frequency in the list
        for(int number : numberToFrequencyMap.keySet()){

            int frequency = numberToFrequencyMap.get(number);
            bucketArrayOfList[frequency].add(number);

        }

        //result array, traverse the bucketArrayOfList and populate resultArray
        int[] resultArray = new int[k];

        //Frequency 0 is meaningless here (no number can have frequency 0). It should be frequency >= 1
        for(int frequency=bucketArrayOfList.length-1, target=0; frequency>=1 && target<k; frequency--){

            List<Integer> list = bucketArrayOfList[frequency];
            for(int i=0; i<list.size() && target<k; i++){
                int value = list.get(i); //What if the list is empty here ? I will get value
                System.out.println("value is "+value);
                resultArray[target] = value;
                target++;
            }
        }

        return resultArray;

    }

    /*
    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
    */
    public int[] productExceptSelf(int[] nums){

        int n = nums.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        int[] productArray = new int[n];

        //prefixArray
        prefixArray[0] = 1;
        for(int i=1; i<n; i++){
            prefixArray[i] = prefixArray[i-1] * nums[i-1];
        }

        //suffixArray
        suffixArray[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffixArray[i] = suffixArray[i+1] * nums[i+1];
        }

        //productArray
        for(int i=0; i<n; i++){
            productArray[i] = prefixArray[i] * suffixArray[i];
        }

        return productArray;

    }


    public boolean isValidSudoku(char[][] board){

        HashSet<Character>[] rowArrayOfSet = new HashSet[9];
        HashSet<Character>[] colArrayOfSet = new HashSet[9];
        HashSet<Character>[] boxArrayOfSet = new HashSet[9];

        // Initialize all sets first
        for (int i = 0; i < 9; i++) {
            rowArrayOfSet[i] = new HashSet<>();
            colArrayOfSet[i] = new HashSet<>();
            boxArrayOfSet[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                //Skip dot cells
                if(board[i][j] == '.'){
                    continue;
                }

                //calculate box index
                int boxIndex = (i/3)*3 + (j/3);

                //Check row value is not duplicate
                if(rowArrayOfSet[i].contains(board[i][j])){
                    return false; //duplicate found
                }

                //Check col value is not duplicate
                if(colArrayOfSet[j].contains(board[i][j])){
                    return false; //duplicate found
                }

                //Check box has no duplicates
                if(boxArrayOfSet[boxIndex].contains(board[i][j])){
                    return false; //duplicate found
                }

                //Add values to the hashSet
                rowArrayOfSet[i].add(board[i][j]);
                colArrayOfSet[j].add(board[i][j]);
                boxArrayOfSet[boxIndex].add(board[i][j]);
            }
        }

        return true; //Valid sudoku

    }

    /*
    Example 1:
    Input: nums = [100,4,200,1,3,2, 7, 8, 9, 55, 56, 57, 58, 59]
    Output: 5
    Explanation: The longest consecutive elements sequence is [55, 56, 57, 58, 59]. Therefore its length is 5.
    Algorithm must be O(n)
    */
    public int longestConsecutive(int[] nums){

        //Edge cases
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> numberSet = new HashSet<>();

        //Populate the numberSet
        for(int n : nums){
            numberSet.add(n);
        }

        /*
        Rough
        nums = [100,4,200,1,3,2, 7, 8, 9, 55, 56, 57, 58, 59]
        num=100 =>
        currentNum = 100, currentStreak = 1, while failed
        num=4 => if failed
        num=200 =>
        currentNum = 200, currentStreak = 1, while failed
        num=1 =>
        currentNum = 1, currentStreak =1,
        while currentStreak = 4
        longestStreak = 4
        num=7 =>
        currentNum = 7, currentStreak =1,
        while currentStreak = 3
        longestStreak = 4
        num=55 =>
        currentNum = 55, currentStreak =1,
        while currentStreak = 5
        longestStreak = 5

        return 5;
        */

        int longestStreak = 0;
        for(int num : nums){

            //Start the streak only if the previous number is not present
            if(!numberSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(numberSet.contains(currentNum+1)){
                    currentStreak++;
                    currentNum++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);

            }

        }

        return longestStreak;

    }

    /*
    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    */
    public boolean isPalindrome(String s){

        //Edge cases
        if(s.isBlank()){
            return true; //Palindrome
        }

        int left = 0;
        int right = s.length()-1;

        while(left < right){

            //Logic for skipping the punctuations in left
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            //Logic for skipping the punctuations in right
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            //Logic for palindrome check
            if(left<right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false; //Not palindrome
            }

            left++;
            right--;

        }

        return true; //Palindrome

    }

    /*
    Example
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String s){

        //Edge cases
        if(s.isEmpty()){
            return 0;
        }

        //Character to its recent index Map
        Map<Character, Integer> characterToRecentIndexMap = new HashMap<>();

        /*
        Rough
        Consider the input "dvdf"
        dvdf
        0123

        startIndex=0; longestStreak=0; valid window [startIndex, currentIndex]
        for loop
        currentIndex=0 => startIndex=0, d
        startIndex=0; {d, 0}, currentStreak = 1, longestStreak = 1, d
        currentIndex=1 => startIndex=0, v
        startIndex=0; {d,0}, {v,1}, currentStreak = 2, longestStreak =2 , dv
        currentIndex=2 => startIndex=0, d
        startIndex=1; {d, 2}, {v, 1}, currentStreak = 2, longestStreak = 2, vd
        currentIndex=3 => startIndex=1, f
        startIndex=1, {d, 2}, {v, 1}, {f, 3}, currentStreak = 3, longestStreak = 3, vdf

        return 3
        */

        //Traverse the String
        int startIndex = 0;
        int longestStreak = 0;
        for(int currentIndex=0; currentIndex<s.length(); currentIndex++){

            if(startIndex < currentIndex
                && characterToRecentIndexMap.containsKey(s.charAt(currentIndex))){

                startIndex = characterToRecentIndexMap.get(s.charAt(currentIndex)) + 1;
            }

            //Update the map
            characterToRecentIndexMap.put(s.charAt(currentIndex), currentIndex);

            int currentStreak = currentIndex - startIndex +1;
            longestStreak = Math.max(longestStreak, currentStreak);

        }

        return longestStreak;




    }







}
