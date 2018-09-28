package com.seb;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static DecimalFormat df = new DecimalFormat(".##");
    static Scanner input = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {

//Create a  new array list of GroceryItems
        ArrayList<GroceryItem> itemsList = new ArrayList<GroceryItem>();

//Declare a String variable otherItem to ask the user if they have other items and
// to use it as a condition for the do loop

        String otherItem = "";

//  Declare variables totalAmount (to use it in calculation of total amount of purchase)
// and count (to use it in total number of items purchased

        double totalAmount = 0;
        int count = 0;
        do {
//Create an instance of GroceryItems called item
            GroceryItem item = new GroceryItem();
//Ask the user the item name and use ito set itemName
            System.out.println("Insert Item : ");
            String itemName = input.nextLine();
            item.setItemName(itemName);
            //Call the randomGenerator method for the quantity
            int quantity = randomGenerator();
            item.setQuantity(quantity);
            //Ask the user the item price and use ito set itemPrice
            System.out.println("Please insert the price : ");
            double price = input.nextDouble();
            item.setPrice(price);
            input.nextLine();
//Call the costCalculation method for the cost and use the cost calculated to set cost
            double cost = costCalculation(quantity, price);
            item.setCost(cost);
            totalAmount += cost;
//Ask the user if they have other items if yes the loop continues if no the loop ends
            System.out.println("Have any Items to insert?");
            otherItem = input.nextLine();
//Add the new object item to the itemList
            itemsList.add(item);
//Add the  count by one everytime the loop runs
            count++;

        } while (otherItem.equalsIgnoreCase("yes"));

//Declare variables dollars and cents to use the numberic value to words method
        int dollars = (int) (totalAmount);
        int cents = (int) Math.round((totalAmount - dollars) * 100);

        System.out.println("\n\nItem Name\t\t\t    Price   \t\t\t   Quantity   \t\t\t   Cost   \n");
//Print the name, price, quantity and cost of each item
        for (GroceryItem eachItem : itemsList) {
            System.out.println(eachItem.getItemName() + "\t\t\t\t\t" + "$" + df.format(eachItem.getPrice()) + "\t\t\t\t\t" + eachItem.getQuantity() + "\t\t\t\t\t"+ "$" + df.format(eachItem.getCost()));
        }

//Print the ttotal purcahse amonut, the changed to numbers amount and the total number of items purchased
        System.out.println("\n\n\n\t\tTotal purchase amount is  = $" + df.format(totalAmount) + "( " + numericToWord(dollars) + " dollars and " + numericToWord(cents) + " cents )");
        System.out.printf("\t    Total Items Purchased : %d", count);

//Check if the total amount spent is greater than 20$
        if (totalAmount >= 20) {
            System.out.println("\n\t    You spent too much today....");
        } else
            System.out.println("\n\t    Thank you for shopping at my market");


    }

    // Create a method  that calculates cost
    public static double costCalculation(int quantity, double price) {
        Double cost = quantity * price;
        return cost;

    }

    // Create a method that generates a random number to use it as a quantity
    public static int randomGenerator() {
        int randomNumber = rd.nextInt(10) + 1;
        return randomNumber;
    }

    //Create a mothod that changes the numeric values to words
    public static String numericToWord(int number) {

// Create an Array of Strings called unit to hold the word for the numbers form 1 to 20
        String[] units = new String[]{
                "", "one", "two", "three", "four",
                "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen",
                "nineteen"
        };

// Create an Array of Strings called tens to hold the word for the numbers form 20 to 100
        String[] tens = new String[]{
                ",", ",", "twenty", "thirty",
                "fourty", "fifty", "sixty", "seventy",
                "eighty", "ninety",
        };


        String words = "";
        if (number < 20) {
            words = units[number];
        }
        if (number > 20 && number < 100) {
            words = tens[number / 10] + " " + units[number % 10];
        }
        if (number > 100 && number < 1000) {
            words = units[(int) (number / 100)] + " hundred " + tens[(int) ((number % 100) / 10)] + " " + units[number % 10];
        }
        if (number>1000){
            words = " ";
        }
        return words;
    }


}


