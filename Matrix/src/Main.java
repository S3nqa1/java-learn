import java.util.ArrayList;
import java.util.Scanner;
import com.oleh.Matrix.Matrix;

public class Main {
    public static void main(String[] args) {

        while(true) {
            System.out.println("enter a number bigger than 100: ");
            Scanner in = new Scanner(System.in);

            String s = in.nextLine();

            int newInt = Integer.parseInt(s);
            if (newInt < 101) {
                break;
            }

            ArrayList<Integer> numArr = SomeCalculations(newInt);
            Matrix newM = new Matrix(numArr);
            newM.print();
        }

    }

    private static ArrayList<Integer> SomeCalculations(int b){
        int n = b * b;
        ArrayList<Integer> res = new ArrayList<>();
        char[] temp = (Integer.toString(n).toCharArray());
        for (char c: temp) {
            res.add(Integer.parseInt(String.valueOf(c)));
        }
        return res;
    }
}