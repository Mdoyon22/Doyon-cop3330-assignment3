/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex45;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    App function:
    1: Initialize main
    2: Prompt user for file name
    3: Add .txt to file name if not provided
    4: Read input file
    5: Modify input
    6: Write to new file
 */



public class App
{
    public static void main(String[] args)
    {
        String inputFile = "src/main/java/ex45/exercise45_input.txt";

        Scanner inp = new Scanner(System.in);
        System.out.print("What would you like the new file to be named? ");
        String fileName = inp.nextLine();

        fileName = fixFileName(fileName);

        TextFileInput input = new TextFileInput(inputFile);
        input.readFileInput();

        input.buildOutput();
        writeFile(fileName, input);
        System.out.println(input.getOutput());
    }

    public static String fixFileName(String fileName)
    {
        if (!fileName.substring(fileName.length() - 4).equals(".txt"))
        {
            fileName = fileName + ".txt";
        }

        return fileName;
    }

    public static void writeFile(String fileName, TextFileInput text)
    {
        try (FileWriter w = new FileWriter("./src/main/java/ex45/" + fileName))
        {
            w.write(text.getOutput());
        }

        catch (IOException e)
        {

        }
    }
}
