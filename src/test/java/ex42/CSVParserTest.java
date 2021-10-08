/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex42;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CSVParserTest
{
    @Test
    void Parsed_Test()
    {
        String path = "src/test/java/ex42/test.csv";
        File cFile = new File(path);

        String last = "a";
        String first = "b";
        String salary = "c";

        try (FileWriter w = new FileWriter(cFile))
        {
            w.write(last + "," + first + "," + salary);
        }

        catch (IOException e)
        {

        }

        CSVParser test = new CSVParser(path);

        List<Map<String, String>> actual = test.parsed();
        List<Map<String, String>> expected = new ArrayList<>();
        Map<String, String> record = new HashMap<>();

        record.put("Last", last);
        record.put("First", first);
        record.put("Salary", salary);

        expected.add(record);
        assertEquals(expected, actual);
        cFile.deleteOnExit();
    }
}