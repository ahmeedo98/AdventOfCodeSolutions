package com.sparta.ahmed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        ArrayList<String> passwordList = readPasswords();
        System.out.println(passwordList.toString());
        int numOfValidPasswords = checkValidPasswords(passwordList);
        System.out.println(numOfValidPasswords);
    }


    private static ArrayList<String> readPasswords() {
        File passwords = new File("src/main/resources/passwords.txt");
        ArrayList<String> passwordsList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(passwords);
            while (scanner.hasNextLine()) {
                passwordsList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passwordsList;
    }

    private static int checkValidPasswords(ArrayList<String> passwordList) {
        int validPasswordCount = 0;
        for (String password : passwordList) {
            password = password.replace("-", " ");
            password = password.replace(":", "");
            String[] splitPassword = password.split(" ");
            System.out.println(Arrays.toString(splitPassword));
            int lowerLimit = Integer.parseInt(splitPassword[0]);
            int upperLimit = Integer.parseInt(splitPassword[1]);
            char letter = splitPassword[2].charAt(0);
            String stringPassword = splitPassword[3];
            int count = 0;
            for (int j = 0; j < stringPassword.length(); j++) {
                if (stringPassword.charAt(j) == letter) {
                    count++;
                }
            }
            if (count <= upperLimit && count >= lowerLimit) {
                validPasswordCount++;
            }
        }
        return validPasswordCount;
    }
}
