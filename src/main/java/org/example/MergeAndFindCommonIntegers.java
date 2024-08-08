package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;



public class MergeAndFindCommonIntegers {

    public static void main(String[] args) {

        //Task 1: Read integers from first input file
        List<Integer> list1 = readIntegersFromFile("input1.txt");
        //Task 1: Read integers from second input file
        List<Integer> list2 = readIntegersFromFile("input2.txt");

        //Task 2: Check if both lists were read successfully
        if(list1 != null && list2 != null) {

            //Task 2: Merge the contents of the two lists, maintaing the original order
            List<Integer> mergedList = new ArrayList<>(list1);
            mergedList.addAll(list2);

            //Task 2: Write the result into a new text file called merged.txt
            writeIntegersToFile(mergedList, "src/main/resources/output/merged.txt");
        }
    }

    //Task 1: Method to read integers from a specified file and return them as a list
    private static List<Integer> readIntegersFromFile(String filename) {
        List<Integer> integer = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                try {
                    //Parse each line as an integer and add it to the list
                    integers.add(Integers.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    //Handle invalid number format and print error
                    System.out.println("Invalid format in file: " + filename + ": " + line);
                }
            }

        } catch (FileNotFoundException e) {
            //Handle case where the file is not found, print error
            System.out.println("File Not Found: " + filename + ": " + e);
        } catch (IOException e) {
            //Handle general I/O exceptions, print error
            System.out.println("IOException: " + filename + ": " + e);
        }
        return integers;
    }
}