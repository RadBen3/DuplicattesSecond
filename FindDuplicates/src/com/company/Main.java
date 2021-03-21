package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease enter the data, separated by space and press Enter key at the end, the system accepts only the number as an integer:");
        String input = sc.nextLine();
        String regex = "-?\\d+";

        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        List<String> list = new ArrayList<>();
        //Matching the compiled pattern
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        System.out.println(" \nThe list of identified data: " + list);

        // Convert data to integer
        List<Integer> list2 = new ArrayList<>();
        for(String number : list) {
            try {
                list2.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                System.out.println("\nThe specified value is not an integer, probably is out of range (-2 147 483 648 to 2 147 483 647): "+number);
                System.out.println("\nAfter preparing the correct data, please use the application again.");
                return;
            }
        }

        // Convert ArrayList to Array to check for exceptions
        int[] array = list2.stream().mapToInt(i -> i).toArray();

        //Initialize collections
        System.out.println("\nDuplicate elements from array:");
        Set<Integer> store = new HashSet<>();

        //Print duplicates
        int sum = 0;
        for (int arr :array) {
            if (store.add(arr) == false) {
                System.out.println("Found a duplicate element: " + arr);
                sum = sum + arr;
            }
        }

        //Print SUM
        System.out.println("\nSum of duplicate numbers in the collection: " + sum);
    }
}