/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex45;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileInput
{
    private String filePath;
    private ArrayList<String> contents;
    private String output;


    public TextFileInput(String filePath)
    {
        this.filePath= filePath;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public ArrayList<String> getContents()
    {
        return contents;
    }

    public void setContents(ArrayList<String> contents)
    {
        this.contents = contents;
    }

    public String getOutput()
    {
        return output;
    }

    public void setOutput(String output)
    {
        this.output = output;
    }

    public void readFileInput()
    {
        String path = getFilePath();
        ArrayList<String> a = new ArrayList<>();

        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator()))
        {
            while (file.hasNext())
                a.add(file.next());
        }

        catch (IOException e)
        {

        }

        setContents(a);
    }

    public void replaceWord(String a, String b)
    {
        ArrayList<String> l = getContents();

        for (int i = 0; i < l.size(); i++)
        {
            String s = l.get(i).replaceAll(a, b);
            l.set(i, s);
        }

        setContents(l);
    }

    public void buildOutput()
    {
        ArrayList<String> l = getContents();
        StringBuilder out = new StringBuilder();

        for (String line : l)
        {
            out.append(line).append("\n");
        }

        setOutput(out.toString());
    }
}
