/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex42;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TableBuildTest
{
    @Test
    void Build_Test()
    {
        String last = "a";
        String first = "b";
        String salary = "c";

        List<Map<String, String>> l = new ArrayList<>();
        Map<String, String> record = new HashMap<>();

        record.put("Last", last);
        record.put("First", first);
        record.put("Salary", salary);

        l.add(record);

        TableBuild test = new TableBuild(l);
        test.build();
        var actual = test.getOutput();
        String expected = "Last      First     Salary\n" +
                "--------------------------\n" +
                "a         b         c    \n";

        assertEquals(expected, actual);
    }

}