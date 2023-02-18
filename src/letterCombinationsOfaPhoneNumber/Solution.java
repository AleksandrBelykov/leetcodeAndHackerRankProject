package letterCombinationsOfaPhoneNumber;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String digits = "23";

        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;

        Map<String, String> data = new HashMap<>();
        data.put("2", "abc");
        data.put("3", "def");
        data.put("4", "ghi");
        data.put("5","jkl");
        data.put("6", "mno");
        data.put("7", "pqrs");
        data.put("8", "tuv");
        data.put("9", "wxyz");

        Deque<String> deque = new ArrayDeque();
        deque.add("");

        for(int i=0; i<digits.length(); i++){
            String d = digits.substring(i,i+1);
            String fromMap = data.get(d);
            int dequeSize = deque.size();
            for(int j =0; j<dequeSize ; j++){
                String pull = deque.pollFirst();
                for(int k =0 ; k<fromMap.length();k++){
                    String temp = pull.concat(fromMap.charAt(k)+""); // "" a b c
                    deque.add(temp);
                }
            }
        }
        while(!deque.isEmpty()){
            result.add(deque.poll());
        }
        return result;
    }


}
