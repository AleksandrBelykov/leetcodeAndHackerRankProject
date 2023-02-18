package staircase;

import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        staircase(5);
        System.out.println();
        staircase2(5);
    }

    public static void staircase(int n) {
        String shebang = "#";
        String space = "_";
        int shebangIndex = n-1;

        for( int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j < shebangIndex){
                    System.out.print(space);
                } else {
                    System.out.print(shebang);
                }
            }
            if(i < n-1){
                System.out.println();
            }
            shebangIndex--;
        }
    }

    public static void staircase2(int n) {
        int blankSpaceNum = 0;
        int hashNum = 0;

        for(int i=1; i<=n; i++){
            blankSpaceNum = n - i;
            hashNum = n - blankSpaceNum;
            String blanks = String.join("", Collections.nCopies(blankSpaceNum, " "));
            String hashes = String.join("", Collections.nCopies(hashNum, "#"));
            System.out.println(blanks.concat(hashes));
        }
    }
}
