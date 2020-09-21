package algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class FindCaseInSensitiveAllStringsMatching {

    public static void main(String[] arg) {
        System.out.println(findAllStrings("caBCcbAbc".toLowerCase(), "abc".toLowerCase())); // answer is [1, 6]
    }

    // Sliding window - best way
    public static List<Integer> findAllStrings(String s, String p) {
        List<Integer> list = new ArrayList();
        int lengthS = s.length();
        int lengthP = p.length();
        if (lengthS < lengthP) {
            return list;
        }
        for(int index = 0, j = 0; index < lengthS; index++) {
            if(s.charAt(index) == p.charAt(j)) {
                j++;
                if(j >= lengthP) {
                    list.add(index+1-j);
                    j = 0;
                }
            }
            else {
                j = 0;
            }
        }
        return list;
    }
}