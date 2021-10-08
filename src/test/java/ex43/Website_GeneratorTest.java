/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex43;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


class Website_GeneratorTest
{
    public static String sourceDirinTestFolder = "src/test/java/ex43";
    public static final String ParentFolderName = "TestFolder_Website";
    public static final String subFolderName = "SubFolder1";
    public static FileWriter htmlFile = null;


    @Test
    void folderCreator()
    {
        File folder = Website_Generator.folderCreator(sourceDirinTestFolder, ParentFolderName);
        boolean result = folder.mkdirs();
        assertTrue(result);
        sourceDirinTestFolder += "//" + ParentFolderName;
    }

    @Test
    void testFolderCreator_FuncOverload()
    {
        File folder = Website_Generator.folderCreator(sourceDirinTestFolder, ParentFolderName, subFolderName);
        boolean result = folder.mkdirs();
        assertTrue(result);
    }

    @Test
    void testFolderCreator_FuncOverload2()
    {
        String subFolderName2 = "TestSubFolder2";
        File folder = Website_Generator.folderCreator(sourceDirinTestFolder, subFolderName, subFolderName2);
        boolean result = folder.mkdirs();
        assertTrue(result);
    }

    @Test
    void htmlMaker()
    {
        ArrayList<String> websiteData = new ArrayList<>();
        websiteData.add("Name:TestHTML");
        websiteData.add("AuthorName: Michael");

        htmlFile = Website_Generator.htmlMaker(htmlFile, websiteData, "src/test/java/ex43" + "//index.html");
        boolean result = (htmlFile != null);
        assertTrue(result);
    }
}