/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex45;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TextFileInputTest
{
    @Test
    void readFileInput_test()
    {
        TextFileInput test = new TextFileInput("src/main/java/ex45/exercise45_input.txt");
        test.readFileInput();
        assertTrue(test.getContents().get(0).contains("One"));
    }

    @Test
    void replaceWord_test()
    {
        TextFileInput test = new TextFileInput("src/main/java/ex45/exercise45_input.txt");
        test.readFileInput();
        test.replaceWord("One", "");
        assertFalse(test.getContents().get(0).contains("One"));
    }

    @Test
    void buildOutput_test()
    {
        TextFileInput test = new TextFileInput("src/main/java/ex45/exercise45_input.txt");
        test.readFileInput();
        test.buildOutput();
        assertTrue(test.getOutput().length() > 0);
    }
}