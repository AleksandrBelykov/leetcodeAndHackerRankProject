package reverseInteger;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int x = -10200;

        System.out.println(reverse(x));
        System.out.println(reverseNoUseOfLong(x));
    }

    public static int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        List<Integer> listOfDigits = new LinkedList<>();
        Long longResult;

        if(x < 0){
            builder.append('-');
        }
        x = Math.abs(x);

        while(x > 0) {
            int temp = x % 10;
            if(temp != 0 || (temp == 0 && !listOfDigits.isEmpty())) {
                listOfDigits.add(temp);
            }
            x /= 10;
        }

        for(int digit : listOfDigits){
            builder.append(digit);
        }

        longResult = Long.parseLong(builder.toString());
        if(longResult < Integer.MIN_VALUE || longResult > Integer.MAX_VALUE){
            return 0;
        } else{
            return longResult.intValue();
        }
    }

    public static int reverseNoUseOfLong(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }
}
