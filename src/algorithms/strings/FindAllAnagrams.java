package algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] arg) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("af", "be"));
    }

    // Sliding window - best way
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        int lengthS = s.length();
        int lengthP = p.length();
        if (lengthS < lengthP) {
            return list;
        }

        HashMap<Character, Integer> hashmap = new HashMap<>();
        int targetSum = 0;
        for(int index = 0; index < lengthP; index++) {
            if(! hashmap.containsKey(p.charAt(index))) {
                hashmap.put(p.charAt(index), (int)p.charAt(index));
            }
            targetSum += (int)p.charAt(index);
        }

        int runningSum = 0;
        for(int index = 0; index < lengthS; index++) {
            if(hashmap.containsKey(s.charAt(index))) {
                runningSum += (int)s.charAt(index);
            }
            if(index >= lengthP-1) {
                if(targetSum == runningSum) {
                    list.add(index+1-lengthP);
                }
                runningSum -= hashmap.getOrDefault(s.charAt(index+1-lengthP), 0); // remove if check
            }
        }
        return list;
    }

    // Sliding window - best way
    public static List<Integer> findAnagrams_v2(String s, String p) {
        int lengthS = s.toCharArray().length;
        int lengthP = p.toCharArray().length;
        List<Integer> list = new ArrayList<Integer>();
        if (lengthS < lengthP) {
            return list;
        }
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int targetSum = 0;
        for (int index = 0; index < p.length(); index++) { // Complexity = m, suppose m is length of p
            hashMap.put(p.charAt(index), (int)p.charAt(index));
            targetSum +=  p.charAt(index);
        }
        int sum = 0;
        for (int i = 0; i < lengthS; i++) { // Complexity = n, suppose n is length of s => [total complexity = n + m]
            if(hashMap.containsKey(s.charAt(i))) { // Complexity = 1, [total complexity = n + m + 1]
                sum += (int) s.charAt(i);
            }
            if (i >= lengthP-1) {
                if (targetSum == sum) {
                    list.add(i+1-lengthP);
                }
                if(hashMap.containsKey(s.charAt(i+1-lengthP))) { // Complexity = 1, [total complexity = n + m + 1 + 1]
                    sum -= (int) s.charAt(i+1-lengthP);
                }
            }
        }
        return list; // total complexity = n, because n > m
    }

    // brute force - simple way
    public static List<Integer> findAnagrams_v1(String s, String p) {
        int lengthS = s.toCharArray().length;
        int lengthP = p.toCharArray().length;
        if (lengthS < lengthP) {
            return new ArrayList();
        }

        int targetSum = 0;
        for (int index = 0; index < p.length(); index++) {
            targetSum += (int) p.charAt(index);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < lengthS - lengthP; i++) { // n * m
            int sum = 0;
            for (int j = i; j < i + lengthP; j++) {
                sum += (int) s.charAt(j);
            }
            if (targetSum == sum) {
                list.add(i);
            }
        }
        return list;
    }
}