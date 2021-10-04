/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex41;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class App
{
    public static void main(String[] args) throws FileNotFoundException
    {

        Scanner inputFile = new Scanner(new File("C:\\Users\\Michael\\Documents\\OOP Projects\\Doyon-cop3330-assignment3\\src\\main\\java\\ex41\\exercise41_input.txt"));

        ArrayList<String> names = new ArrayList<>(); //Array list declaration.

        nameSorter.namesReader(inputFile, names);

        names.sort(String.CASE_INSENSITIVE_ORDER);

        inputFile.close();

        try
        {
            nameSorter.namesOutput(names);
        }
        catch (Exception e)
        {
            //Exception case.
            System.out.println(e);
        }
    }
}