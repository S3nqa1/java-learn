/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)

Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)

Note: The function accepts an integer and returns an integer.
 */

public class Main{
    public static int square(int n){
        String s = Integer.toString(n);
        int l = s.length();
        StringBuilder newString = new StringBuilder();
        for (int i =0; i < l; i++){
            int temp = Integer.parseInt(String.valueOf(s.charAt(i)));
            temp = temp * temp;
            newString.append(temp);
        }
        return Integer.parseInt(String.valueOf(newString));
    }

    public static void main(String[] args) {
        System.out.println(square(9119));
    }
}