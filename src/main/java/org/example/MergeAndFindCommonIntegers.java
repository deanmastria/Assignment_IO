package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;



public class MergeAndFindCommonIntegers {

    public static void main(String[] args) {

        //Task 1: Read integers from first input file
        List<Integer> list1 = readIntegersFromFile("src/main/resources/input/input1");
        //Task 1: Read integers from second input file
        List<Integer> list2 = readIntegersFromFile("src/main/resources/input/input2");

        //Task 2: Check if both lists were read successfully
        if(list1 != null && list2 != null) {

            //Task 2: Merge the contents of the two lists, maintaing the original order
            List<Integer> mergedList = new ArrayList<>(list1);
            mergedList.addAll(list2);

            //Task 2: Write the result into a new text file called merged.txt
            writeIntegersToFile(mergedList, "src/main/resources/output/merged.txt");

            //Task 3: Identify Integers present in both files
            Set<Integer> commonSet = new HashSet<>(list1);
            commonSet.retainAll(list2);

            //Convert te set of common integers into a list
            List<Integer> commonList = new ArrayList<>(commonSet);

            //Task 4: Write integers present in both files in new txt file named common.txt
            writeIntegersToFile(commonList, "src/main/resources/output/common.txt");
        }
    }

    //Task 1: Method to read integers from a specified file and return them as a list
    private static List<Integer> readIntegersFromFile(String filename) {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                try {
                    integers.add(Integer.parseInt(line.trim()));                               //Parse each line as an integer and add it to the list
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format in file: " + filename + ": " + line);    //Handle invalid number format and print error
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + filename + ": " + e);                       //Handle case where the file is not found, print error
        } catch (IOException e) {
            System.out.println("IOException: " + filename + ": " + e);                           //Handle general I/O exceptions, print error
        }
        return integers;                                                                        // Return list of integers
    }

        //Task 4/5: Method to write a list of integers to s specific file
        private static void writeIntegersToFile(List<Integer> integers, String filename) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                for (int number : integers) {
                bw.write(String.valueOf(number));                                               //Write each integer to the file
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("IOException while writing to file" + filename);
        }
    }
}