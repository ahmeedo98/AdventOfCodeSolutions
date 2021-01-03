package com.sparta.ahmed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> treeGraphList = readFile();
        countNumberOfTrees(treeGraphList);
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
            x += 3;
            if (x >= numberOfColumns) {
                x = x - numberOfColumns;
            }
        }
        System.out.println(sumOfTree);
    }
}
