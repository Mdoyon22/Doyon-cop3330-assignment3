/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex46;
import java.io.File;
import java.io.IOException;
import java.util.*;
import static java.util.stream.Collectors.toMap;

/*
    App Function:
    1: Initialize main
    2: Read input file
    3: Create map to count appearance of each word
    4: Count words
    5: Display counts
 */



public class App
{
    public static void main(String[] args)
    {
        String path = "./src/main/java/ex46/exercise46_input.txt";

        ArrayList<String> words = readFile(path);

        Map<String, Integer> counts = new HashMap<>();

        populateCounts(counts, words);

        String output = displayCounts(counts);
        System.out.println(output);
    }

    public static ArrayList<String> readFile(String path)
    {
        ArrayList<String> words = new ArrayList<>();

        try (Scanner file = new Scanner(new File(path)))
        {
            while (file.hasNext())
                words.add(file.next());
        }

        catch (IOException e)
        {

        }

        return words;
    }

    public static void populateCounts(Map<String, Integer> counts, ArrayList<String> words)
    {
        for (String word : words)
        {
            word = word.toLowerCase();

            if (counts.containsKey(word))
            {
                int count = counts.get(word);
                counts.put(word, count+1);
            }

            else
            {
                counts.put(word, 1);
            }
        }
    }

    public static String displayCounts(Map<String, Integer> counts)
    {
        Map<String, Integer> sorted = counts.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        StringBuilder output = new StringBuilder();

        for (String key : sorted.keySet())
        {
            String temp = String.format("%-10s%s", key + ":", " " + "*".repeat(Math.max(0, counts.get(key))));
            output.append(temp).append("\n");
        }

        return output.toString();
    }
}
