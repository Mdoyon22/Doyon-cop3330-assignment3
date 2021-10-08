/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Doyon
 */


package ex44;
import com.google.gson.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    App function:
    1: Initialize main
    2: Parse JSON file
    3: Search for input (loop if none)
    4: Print search result
 */


public class App
{
    public static Scanner inp = new Scanner(System.in);

    public static void main(String[] args)
    {
        String inputPath = "src/main/java/ex44/exercise44_input.json";
        String output = null;

        List<Products> products = getProducts(inputPath);
        output = searchForProduct(products);
        System.out.println(output);
    }

    public static List<Products> getProducts(String inputPath)
    {
        File input = new File(inputPath);
        List<Products> products = null;

        try
        {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayProducts = fileObject.get("products").getAsJsonArray();
            products = new ArrayList<>();

            for (JsonElement productJson : jsonArrayProducts)
            {
                JsonObject productJsonObject = productJson.getAsJsonObject();

                String name = productJsonObject.get("name").getAsString();
                int price = productJsonObject.get("price").getAsInt();
                int quantity = productJsonObject.get("quantity").getAsInt();

                Products product = new Products(name, price, quantity);
                products.add(product);
            }
        }

        catch (FileNotFoundException e)
        {

        }

        return products;
    }

    private static String searchForProduct(List<Products> products)
    {
        String search;
        String foundName;
        double foundPrice;
        int foundQuantity;
        String output = null;

        do
        {
            System.out.print("What is the product name? ");
            search = inp.nextLine().toLowerCase();
            Products foundProduct = search(products, search);
            foundName = foundProduct.getName();
            foundPrice = foundProduct.getPrice();
            foundQuantity = foundProduct.getQuantity();

            if (foundName == null)
            {
                System.out.println("Sorry, that product was not found in our inventory.");
            }

            else
            {
                DecimalFormat df = new DecimalFormat("0.00");
                output = String.format("Name: %s\nPrice: %s\nQuantity: %d", foundName, df.format(foundPrice), foundQuantity);
            }
        }

        while (foundName == null);
        return output;
    }

    public static Products search(List<Products> products, String search)
    {
        if (products != null)
        {
            for (Products p : products)
            {
                if (p.getName() != null && p.getName().toLowerCase().contains(search))
                {
                    return p;
                }
            }
        }

        Products none = new Products(null, 0, 0);
        return none;
    }
}
