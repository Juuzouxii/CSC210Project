// Team members: Ashley Wu and Andrew Blair
// Course number: CSC 210
// Course section: 0900
// Description: This is the GroceryStore class with seven methods.
// Date: 05/15/2024
// Version: Last version

package org.example.chapter12;

public class GroceryStore {
    // Fields
    private static final double tax = 0.08;
    private static String[][] userPassword = {{"username", "password"}, {"Target", "255 Greenwich"}};
    private static String[] items = {"Tuna", "Milk", "Bread", "Juice"};
    private static double[] prices = {2.60, 10.00, 5.80, 3.40};

    // Method to return the username
    public static String getUsername()
    {
        return userPassword[1][0];
    }

    // Method to return the password
    public static String getPassword()
    {
        return userPassword[1][1];
    }

    // Method to return a price given an item name
    public static Double getPrice(String item) // Double to be able to use null
    {
        // for loop to return price given an item name
        for (int i=0; i < items.length; i++)
        {
            if (items[i]==item)
            {
                return prices[i];
            }
        }
        return null; // if the item was not found
    }

    // Method to return the names of the items
    public static String[] getItems()
    {
        return items;
    }


    // Method to calculate the cost
    public static double calCost(String item)
    {
        double Cost = getPrice(item); // assigning Cost to the item given
        return Cost;
    }

    // Method to calculate the taxes
    public static double calTaxes(String item)
    {
        return calCost(item) * tax; // method from before * tax(0.08)
    }

    // Method to calculate the total cost
    public static double calTotal(String item)
    {
        return calCost(item) + calTaxes(item);
    }

}