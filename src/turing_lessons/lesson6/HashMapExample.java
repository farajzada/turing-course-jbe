package turing_lessons.lesson6;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        // Access an item from the HashMap
        System.out.println(capitalCities.get("England"));

        // Remove an item from the HashMap
        capitalCities.remove("England");

        // Print the HashMap
        System.out.println(capitalCities);

        // Print the size of the HashMap
        System.out.println(capitalCities.size());

        // Loop through the HashMap
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }
    }
}
