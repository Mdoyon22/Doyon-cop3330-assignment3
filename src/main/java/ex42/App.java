/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex42;


/*  Main function:
    1: Create file path
    2: Create CSVParser func
    3: Create TableBuild func
    4: Get output of build
 */


public class App
{
    static String path = "./src/main/java/ex42/exercise42_input.txt";

    public static void main(String[] args)
    {
        CSVParser input = new CSVParser(path);

        TableBuild output = new TableBuild(input.parsed());

        output.build();

        System.out.println(output.getOutput());
    }
}
