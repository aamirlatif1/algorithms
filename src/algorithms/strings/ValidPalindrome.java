package algorithms.strings;

public class ValidPalindrome {

//    public static boolean validPalindrome(String s) {
//        if (s.isEmpty()) return false;
//        int start = 0, end = s.length() - 1;
//        for (; start < s.length() / 2; start++, end--) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return isValidPalindrome(s, start + 1, end) || isValidPalindrome(s, start, end - 1);
//            }
//        }
//        return true;
//    }
//
//    private static boolean isValidPalindrome(String s, int start, int end) {
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    public static boolean validPalindrome(String s) {
        if (s.isEmpty()) return false;

        int count = 0;
        int start = 0, end = s.length() - 1;
        for (; start < s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                count ++;
                if(count == 1) {
                    return isValidPalindrome(s.substring(start + 1, end)) || isValidPalindrome(s.substring(start, end - 1));
                }
            }
        }
        return true;
    }

    public static boolean isValidPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        for (; start < s.length() / 2; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }
}
