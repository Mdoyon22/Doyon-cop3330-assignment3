/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex42;
import java.util.List;
import java.util.Map;

/*
    TableBuild Function:
    1: Takes in data from CSVParser func
    2: Builds a table for "Last", "First" and "Salary"
    3: Loop to determine size of table for each string
    4: Returns final string to Main
 */



public class TableBuild
{
    private List<Map<String, String>> in;
    private String output;

    public TableBuild(List<Map<String, String>> in)
    {
        this.in = in;
    }

    public String getOutput()
    {
        return output;
    }

    public void setOutput(String output)
    {
        this.output = output;
    }

    public void build()
    {
        StringBuilder outString = new StringBuilder();

        outString.append("""
                Last      First     Salary
                --------------------------
                """);

        for (int i = 0; i < in.size(); i++)
        {
            outString.append(getRow(in, i));
        }

        setOutput(outString.toString());
    }

    public static String getRow(List<Map<String, String>> in, int i)
    {
        Map<String, String> feed = in.get(i);
        return String.format("%-10s%-10s%-5s\n",feed.get("Last"), feed.get("First"), feed.get("Salary"));
    }
}
