package com.sparta.ahmed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> passports = readPassports();
        int numberOfValidPassports = checkValidity(passports);
        System.out.println(numberOfValidPassports);
    }


    private static ArrayList<String> readPassports() {
        ArrayList<String> passports = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/passports.txt"));
            String line;
            StringBuilder wholeLine = new StringBuilder();
            //reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    wholeLine.append(line).append(" ");
                }
                if (line.isEmpty()) {
                    passports.add(wholeLine.toString());
                    wholeLine = new StringBuilder();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passports;
    }

    private static int checkValidity(ArrayList<String> passports) {
    int validPass = 0;
        for (String info : passports) {
            int valid = 0;
            String[] infoArray = info.split(" ");
            System.out.println(Arrays.toString(infoArray));
            for (String value : infoArray) {
                if (            value.startsWith("byr") || value.startsWith("iyr")
                        || value.startsWith("eyr") || value.startsWith("hgt")
                        || value.startsWith("hcl") || value.startsWith("ecl")
                        || value.startsWith("pid")) {
                    valid++;
                }
            }
            if (valid >= 7) {
                validPass++;
            } else if (infoArray.length == 8) {
                validPass++;
            }
        }
        return validPass;
    }


}
