package com.sparta.ahmed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
	    ArrayList<Integer> expenseArray = getArray();
        int answer = findSumOfTwo(expenseArray);
        int answer2 = findSumOfThree(expenseArray);
        System.out.println(answer);
        System.out.println(answer2);
    }

    private static ArrayList<Integer> getArray() {
        File expenses = new File("src/main/resources/expenses.txt");
        ArrayList<Integer> expenseArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(expenses);
            while(scanner.hasNextInt()){
                expenseArrayList.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return expenseArrayList;
    }

    private static int findSumOfTwo(ArrayList<Integer> expenseArray) {
        for (int i = 0; i < expenseArray.size()-1; i++) {
            int num1 = expenseArray.get(i);
            for (int j = 1; j < expenseArray.size(); j++) {
                int num2 = expenseArray.get(j);
                if (num1 + num2 == 2020){
                    System.out.println(num1 + num2);
                    return num1 * num2;
                }
            }
        }
        return 0;
    }

    private static int findSumOfThree(ArrayList<Integer> expenseArray) {
        for (int i = 0; i < expenseArray.size()-2; i++) {
            int num1 = expenseArray.get(i);
            for (int j = 1; j < expenseArray.size()-1; j++) {
                int num2 = expenseArray.get(j);
                for (int k = 2; k < expenseArray.size(); k++) {
                    int num3 = expenseArray.get(k);
                    if (num1 + num2 + num3 == 2020){
                        System.out.println(num1 + num2 + num3);
                        return num1 * num2 * num3;
                    }
                }
            }
        }
        return 0;
    }
    private static void countNumberOfTrees(ArrayList<String> treeGraphList) {
        int numberOfColumns = treeGraphList.get(0).length();
        int numberOfRows = treeGraphList.size();
        int sumOfTree = 0;
        int y = 0;
        int x = 0;
        System.out.println(numberOfColumns);
        System.out.println(numberOfRows);

        for (int i = 0; i < numberOfRows; i++) {
            System.out.println(treeGraphList.get(i));
            if (treeGraphList.get(i).charAt(x) == '#') {
                sumOfTree++;
            }
            for (int j = 0; j < 2; j++) {
                if(x+1==numberOfColumns){
                    x=0;
                }
                else{
                    x+=1;
                }
            }
        }
        System.out.println(sumOfTree);
    }
}
