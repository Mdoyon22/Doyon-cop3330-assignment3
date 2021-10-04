/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex41;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AppTest
{
    @Test
    void namesReader() throws FileNotFoundException
    {
        Scanner inpFile = new Scanner(new File("C:\\Users\\Michael\\Documents\\OOP Projects\\Doyon-cop3330-assignment3\\src\\main\\java\\ex41\\exercise41_input.txt"));
        ArrayList<String> names = new ArrayList<>();
        nameSorter.namesReader(inpFile, names);
        int size = names.toArray().length;
        assertEquals(7, size);
    }
}