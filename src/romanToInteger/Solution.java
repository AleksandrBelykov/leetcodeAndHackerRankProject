package romanToInteger;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String s = "MXXIV";

        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        ArrayList<Integer> numbers = convertRomanDigitsToNumeralDigits(s);
        System.out.println(numbers);

        return countTheNumber(numbers);
    }

    private static ArrayList<Integer> convertRomanDigitsToNumeralDigits(String s){
        char[] characters = s.toCharArray();
        ArrayList<Integer> numbers = new ArrayList<>(s.length()-1);
        for (char c : characters){
            switch (c){
                case 'I':
                    numbers.add(Constants.I);
                    break;
                case 'V':
                    numbers.add(Constants.V);
                    break;
                case 'X':
                    numbers.add(Constants.X);
                    break;
                case 'L':
                    numbers.add(Constants.L);
                    break;
                case 'C':
                    numbers.add(Constants.C);
                    break;
                case 'D':
                    numbers.add(Constants.D);
                    break;
                case 'M':
                    numbers.add(Constants.M);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
        return numbers;
    }

    private static int countTheNumber(ArrayList<Integer> numbers){
        if (numbers.size() == 1){
            return numbers.get(0);
        }

        int result = numbers.get(0);
        int current;
        int previous;
        for(current=1, previous=0; current < numbers.size(); current++, previous++){
            int number = numbers.get(current);
            switch (number){
                case 5:
                    if(numbers.get(previous) == 1){
                        result += 3;
                    } else {
                        result += number;
                    }
                    break;
                case 10:
                    if(numbers.get(previous) == 1){
                        result += 8;
                    } else {
                        result += number;
                    }
                    break;
                case 50:
                    if(numbers.get(previous) == 10){
                        result += 30;
                    } else {
                        result += number;
                    }
                    break;
                case 100:
                    if(numbers.get(previous) == 10){
                        result += 80;
                    } else {
                        result += number;
                    }
                    break;
                case 500:
                    if(numbers.get(previous) == 100){
                        result += 300;
                    } else {
                        result += number;
                    }
                    break;
                case 1000:
                    if(numbers.get(previous) == 100){
                        result += 800;
                    } else {
                        result += number;
                    }
                    break;
                default:
                    result += number;
                    break;
            }
        }

        return result;
    }
}
