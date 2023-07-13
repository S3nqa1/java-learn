package com.oleh.Matrix;

import java.util.*;

public class Matrix {
    private ArrayList<Integer> startData = new ArrayList<>();
    private ArrayList<Integer> processedData = new ArrayList<>();
    private int len = 0;
    private ArrayList<ArrayList<Integer>> matrix;
    public Matrix(ArrayList<Integer> startData){
        this.startData = startData;
        this.processedData = processingOfData(startData);
        this.matrix = makeMatrix(processedData);
    }
    
    public void print(){
        System.out.println("data what we get: " + this.startData);
        System.out.println("data what we processed: " + this.processedData);
        System.out.println("len of matrix what we calculate: " + this.len + "X" + this.len);
        System.out.println("exualy the Matrix:");

        for (ArrayList<Integer> i: this.matrix) {
            for (int j: i) {
                System.out.print(j + " | ");
            }
            System.out.println(" ");
        }
    }

    private ArrayList<Integer> processingOfData(ArrayList<Integer> startData){
        Set<Integer> newSet = new HashSet<>(startData);
        ArrayList<Integer> res = new ArrayList<>(newSet);
        this.len = res.size() * 2;
        return res;
    }
    private ArrayList<ArrayList<Integer>> sequenseOfFill(ArrayList<Integer> processedData, boolean pare){
        ArrayList<Integer> start = new ArrayList<>();
        if(pare) {
            for (int i = processedData.size() - 1; i >= 0; i--) {
                start.add(processedData.get(i));
            }
            start.addAll(processedData);
            ArrayList<ArrayList<Integer>> sequence = new ArrayList<ArrayList<Integer>>();
            sequence.add(start);

            for (int i = 1; i < start.size()/2; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(sequence.get(sequence.size()-1));
                if (!Objects.equals(Collections.max(temp), Collections.min(temp))) {
                    int toReplace = temp.get(temp.indexOf(Collections.min(temp)) - 1);
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j) == Collections.min(temp)){
                            temp.set(j, toReplace);
                        }
                    }
                }
                sequence.add(temp);
            }
            return sequence;
        }
        else {
            for (int i = processedData.size() - 1; i > 0; i--) {
                start.add(processedData.get(i));
            }
            start.addAll(processedData);
            ArrayList<ArrayList<Integer>> sequence = new ArrayList<ArrayList<Integer>>();
            sequence.add(start);

            for (int i = 0; i < start.size()/2; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(sequence.get(sequence.size()-1));
                if (!Objects.equals(Collections.max(temp), Collections.min(temp))) {
                    int toReplace = temp.get(temp.indexOf(Collections.min(temp)) - 1);
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j) == Collections.min(temp)){
                            temp.set(j, toReplace);
                        }

                    }
                }
                sequence.add(temp);
            }
            return sequence;
        }
    }

    private ArrayList<ArrayList<Integer>> makeMatrix(ArrayList<Integer> processedData){
        boolean pare = this.len % 2 == 0;
        Collections.sort(processedData);
        if (pare){
            ArrayList<ArrayList<Integer>> temp = sequenseOfFill(processedData, true);
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int i = temp.size() - 1; i >= 0; i--) {
                matrix.add(temp.get(i));
            }
            matrix.addAll(temp);
            return matrix;
        }
        else {
            ArrayList<ArrayList<Integer>> temp = sequenseOfFill(processedData, false);
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int i = temp.size() - 1; i > 0; i--) {
                matrix.add(temp.get(i));
            }
            matrix.addAll(temp);
            return matrix;
        }
    }


}
