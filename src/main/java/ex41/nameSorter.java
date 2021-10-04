/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex41;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
{
Sorting function:
    Has a function that reads data from object created by scanner.
    Adds data to an array list.
}
{
Printing function:
    Has a FileWriter for the output file.
}
*/

public class nameSorter
{
    public static void namesReader(Scanner input, ArrayList<String> names) {

        while (input.hasNextLine()) { //Loop to read data until file is over.
            names.add(input.nextLine()); //Adding names to list.
        }
    }

    public static void namesOutput(ArrayList<String> names) throws IOException {

        FileWriter output = new FileWriter("exercise41_output.txt");

        output.write("Total of " + names.size() + " names\n"); //Will print how many names were scanned.
        output.write("--------------------\n");

        for (String i : names) { //Loop to write names in the file after printing the header.
            output.write(i + "\n");
        }

        output.close();
    }
}
