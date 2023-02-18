package isomorphicStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        if (s.length() <= 1) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));

                System.out.println(map.keySet().stream()
                        .map(key -> key + "=" + map.get(key))
                        .collect(Collectors.joining(", ", "{", "}")));

            } else {
                if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))){
                    return false;
                }
                if (map.get(s.charAt(i)) != t.charAt(i) ){
                    return false;
                }
            }
        }

        return true;
    }
}
