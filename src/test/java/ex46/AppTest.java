/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex46;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static ex46.App.*;


class AppTest
{
    @Test
    void readFile_test()
    {
        ArrayList<String> actual = readFile("./src/main/java/ex46/exercise46_input.txt");
        assertEquals("badger", actual.get(0));
    }

    @Test
    void populateCounts_test()
    {
        String path = "./src/main/java/ex46/exercise46_input.txt";
        ArrayList<String> words = readFile(path);
        Map<String, Integer> counts = new HashMap<>();

        populateCounts(counts, words);
        assertTrue(!counts.isEmpty());
    }

    @Test
    void displayCounts_test()
    {
        String path = "./src/main/java/ex46/exercise46_input.txt";
        ArrayList<String> words = readFile(path);
        Map<String, Integer> counts = new HashMap<>();
        populateCounts(counts, words);

        String actual = displayCounts(counts);
        assertEquals("badger:    *******\n" +
        "mushroom:  **\n" +
                "snake:     *\n", actual);
    }
}