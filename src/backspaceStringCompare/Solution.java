package backspaceStringCompare;

public class Solution {

    private static final int BACKSPACE = '#';

    public static void main(String[] args) {
        String s = "xyw##e";
        String t = "xyw#e#";

        System.out.println(backspaceCompareLong(s, t));

        System.out.println(backspaceCompareShort(s, t));
    }

    //-----------------------------------------------------

    public static boolean backspaceCompareLong(String s, String t) {
        char[] bufferS = deleteletters(s.toCharArray());
        char[] bufferT = deleteletters(t.toCharArray());

        String sString = getString(bufferS);
        String tString = getString(bufferT);

        return sString.equals(tString);
    }

    private static char[] deleteletters(char[] buffer){
        int backspaceNumb = 0;
        for (int i = buffer.length - 1; i >= 0; i--) {
            if (buffer[i] == BACKSPACE) {
                backspaceNumb++;
            }
            if (backspaceNumb > 0 && buffer[i] != BACKSPACE) {
                buffer[i] = BACKSPACE;
                backspaceNumb--;
            }
        }
        return buffer;
    }

    private static String getString(char[] buffer) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char b : buffer){
            if (b != BACKSPACE) {
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }

    //-----------------------------------------------------

    public static boolean backspaceCompareShort(String s, String t) {
        String sProcessed = getStringgggggggggg(s);
        String tProcessed = getStringgggggggggg(t);

        return sProcessed.equals(tProcessed);
    }

    private static String getStringgggggggggg(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = string.toCharArray();

        for (char b : buffer){
            if (b == BACKSPACE && stringBuilder.length() != 0){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            } else {
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }
}
