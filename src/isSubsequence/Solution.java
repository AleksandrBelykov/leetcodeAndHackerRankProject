package isSubsequence;

public class Solution {
    public static void main(String[] args) {
        String s = "b", t = "abc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()){
            return true;
        }
        if (t.isEmpty()){
            return false;
        }

        int index = 0;
        char characterToFind = s.charAt(index);

        for (int i = 0; i < t.length(); i++){
            if (s.length() == 1 && t.charAt(i) != characterToFind){
                continue;
            }

            if (t.charAt(i) == characterToFind){
                index = index+1;
                if (index == s.length()) {
                    return true;
                }
                characterToFind = s.charAt(index);
            }
        }

        return false;
    }
}
