package algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] arg) {
//        System.out.println(findAnagrams("cbaebabacdabc", "abc"));
        System.out.println(findAnagrams("af", "be"));
    }

    // Sliding window - best way
    public static List<Integer> findAnagrams(String s, String p) {
        int lengthS = s.toCharArray().length;
        int lengthP = p.toCharArray().length;
        if (lengthS < lengthP) {
            return new ArrayList();
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int targetSum = 0;
        for (int index = 0; index < p.length(); index++) { // Complexity = m, suppose m is length f p
            hm.put(p.charAt(index), (int)p.charAt(index));
            targetSum +=  p.charAt(index);
        }
        int sum = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < lengthS; i++) { // Complexity = n, , suppose n is length f s => [total Complexity = n + m]
            if(hm.containsKey(s.charAt(i))) { // Complexity = 1, [total Complexity = n + m + 1]
                sum += (int) s.charAt(i);
            }
            if (i >= lengthP-1) {
                if (targetSum == sum) {
                    list.add(i+1-lengthP);
                }
                if(hm.containsKey(s.charAt(i+1-lengthP))) { // Complexity = 1, [total Complexity = n + m + 1 + 1]
                    sum -= (int) s.charAt(i+1-lengthP);
                }
            }
        }
        return list; // total Complexity = n, because n > m
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