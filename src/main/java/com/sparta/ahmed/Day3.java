package com.sparta.ahmed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> treeGraphList = readFile();
        long rightOneDownOne = countNumberOfTrees(treeGraphList, 1, 0);
        long rightThreeDownOne = countNumberOfTrees(treeGraphList, 3, 0);
        long rightFiveDownOne = countNumberOfTrees(treeGraphList, 5, 0);
        long rightSevenDownOne = countNumberOfTrees(treeGraphList, 7, 0);
        long rightOneDownTwo = countNumberOfTrees(treeGraphList, 1, 1);
        System.out.println(rightOneDownOne);
        System.out.println(rightThreeDownOne);
        System.out.println(rightFiveDownOne);
        System.out.println(rightSevenDownOne);
        System.out.println(rightOneDownTwo);
        long sum = rightOneDownOne * rightFiveDownOne * rightOneDownTwo * rightSevenDownOne * rightThreeDownOne;
        System.out.println(sum);
    }


    private static ArrayList<String> readFile() {
        File treeGraph = new File("src/main/resources/treegraph.txt");
        ArrayList<String> treeGraphList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(treeGraph);
            while (scanner.hasNextLine()) {
                treeGraphList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return treeGraphList;
    }

    private static int countNumberOfTrees(ArrayList<String> treeGraphList, int rightValue, int downValue) {
        int numberOfColumns = treeGraphList.get(0).length();
        int numberOfRows = treeGraphList.size();
        int sumOfTree = 0;
        int x = 0;
        System.out.println(numberOfColumns);
        System.out.println(numberOfRows);

        for (int i = 0; i < numberOfRows; i++) {
            System.out.println(treeGraphList.get(i));
            if (treeGraphList.get(i).charAt(x) == '#') {
                sumOfTree++;
            }
            x += rightValue;
            i = i + downValue;
            if (x >= numberOfColumns) {
                x = x - numberOfColumns;
            }
        }
        return sumOfTree;
    }
}
