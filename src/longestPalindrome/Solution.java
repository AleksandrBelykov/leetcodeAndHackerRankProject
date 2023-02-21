package longestPalindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String s = "bananasssss";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int sum;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (map.containsKey(letter)){
                map.put(letter, map.get(letter)+1);
            } else {
                map.put(letter, 1);
            }
        }

        if (map.size() == 1){
            List<Integer> result = new ArrayList<>(map.values());
            return result.get(0);
        }

        sum = map.values().stream().filter(e -> e%2 == 0).reduce(0, Integer::sum);
        List<Integer> list = map.values().stream().filter(e -> e%2 != 0).collect(Collectors.toList());
        if (list.isEmpty()){
            return sum;
        }

        Integer max = list.stream().mapToInt(v -> v).max().getAsInt();
        sum += max;
        list.remove(max);
        int remainder = list.stream().mapToInt(v -> v-1).sum();

        return sum + remainder;
    }
}
