//Sum of Intervals

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<List<Integer>> convertToList(int[][] arr){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                temp.add(arr[i][j]);
            }
            res.add(temp);
        }
        return res;
    }

    private static List<List<Integer>> checkForOverlap(List<List<Integer>> intetvals){
        int count = 0;
        boolean check = false;
        while (count != intetvals.size()){
            check = true;
            if (intetvals.size() > 1) {

                for (int i = 0; i < intetvals.size(); i++) {
                    if (check == true) {
                        for (int j = 0; j < intetvals.size(); j++) {
                            if (intetvals.get(i).equals(intetvals.get(j))) {
                                continue;
                            }
                            if ((Collections.min(intetvals.get(j)) < Collections.max(intetvals.get(i)) && Collections.max(intetvals.get(i)) < Collections.max(intetvals.get(j))) && (Collections.min(intetvals.get(j)) < Collections.min(intetvals.get(i)) && Collections.min(intetvals.get(i)) < Collections.max(intetvals.get(j)))) {
                                check = false;
                                intetvals.set(i, List.of(new Integer[]{Collections.min(intetvals.get(j)), Collections.max(intetvals.get(j))}));
                                intetvals.remove(j);
                                break;
                            }
                            if (Collections.min(intetvals.get(j)) < Collections.max(intetvals.get(i)) && Collections.max(intetvals.get(i)) < Collections.max(intetvals.get(j))) {
                                check = false;
                                intetvals.set(i, List.of(new Integer[]{Collections.min(intetvals.get(i)), Collections.max(intetvals.get(j))}));
                                intetvals.remove(j);
                                break;

                            }
                            if (Collections.min(intetvals.get(j)) < Collections.min(intetvals.get(i)) && Collections.min(intetvals.get(i)) < Collections.max(intetvals.get(j))) {
                                check = false;
                                intetvals.set(i, List.of(new Integer[]{Collections.min(intetvals.get(j)), Collections.max(intetvals.get(i))}));
                                intetvals.remove(j);
                                break;
                            }
                            if (j == intetvals.size()-1) {
                                count += 1;
                            }
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        return intetvals;
    }
    public static int sumIntervals(int[][] intervals) {
        List<List<Integer>> res = convertToList(intervals);
        checkForOverlap(res);

        int sum = 0;

        for (int i = 0; i < res.size(); i++) {
            sum = sum + (Collections.max(res.get(i)) - Collections.min(res.get(i)) );
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
        System.out.println(sumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
        System.out.println(sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
        System.out.println(sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
        System.out.println(sumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));

        }
    }


