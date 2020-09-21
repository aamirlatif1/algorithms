package algorithms.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSortString {

    static HashMap<Character, Integer> hm = new HashMap<>();

    public static String customSort(String S, String T) {
        for (int i = 0; i < S.length(); i++) {
            hm.put(S.charAt(i), i + 1);
        }
        Character[] arr = T.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(arr, Comparator.comparingInt(a -> hm.getOrDefault(a, 0)));

        Stream<Character> charStream = Arrays.stream(arr);
        return charStream.map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(customSort("cba", "abcd"));
    }
}
