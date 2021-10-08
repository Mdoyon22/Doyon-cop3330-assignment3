/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex45;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import static ex45.App.fixFileName;
import static ex45.App.writeFile;

class AppTest
{
    @Test
    void fixFileName_test_with_txt()
    {
        String fileName = "test.txt";
        fileName = fixFileName(fileName);
        assertEquals("test.txt", fileName);
    }

    @Test
    void fixFileName_test_without_txt()
    {
        String fileName = "test";
        fileName = fixFileName(fileName);
        assertEquals("test.txt", fileName);
    }

    @Test
    void writeFile_test()
    {
        String fileName = "JUnit/test.txt";
        TextFileInput input = new TextFileInput("src/main/java/ex45/exercise45_input.txt");
        input.readFileInput();
        input.buildOutput();
        writeFile(fileName, input);
        File test = new File("./src/test/java/ex45/Junit/test.txt");
        assertFalse(test.exists());
        test.deleteOnExit();
    }
}