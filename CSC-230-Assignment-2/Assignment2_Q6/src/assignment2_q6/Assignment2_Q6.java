package assignment2_q6;

import java.util.Scanner;

/**
 * This class/question continuously asks the user for Strings until they enter
 * an empty String. These strings are placed into an array, which, using 
 * the technique the ArrayList data structure uses, can be "resized" to accomodate
 * more strings.
 *
 * @author Joshua Crotts
 */
public class Assignment2_Q6 {

    public static void main(String[] args) {
        String[] words = getStrings();

        for (int i = 0; i < words.length; i++) {
            //No need to print out words that are null
            if (words[i] == null) {
                break;
            }
            System.out.println(words[i]);
        }
    }

    /**
     * Retrieves Strings from user input via std. input.
     * 
     * @return array of Strings from user.
     */
    private static String[] getStrings() {
        Scanner keyboard = new Scanner(System.in);

        String[] strings = new String[5];
        int amtStrings = 0;

        while (true) {
            String s = keyboard.nextLine();
            if (s.equals("")) {
                break;
            }
            amtStrings++;
            //If the amount of strings goes above the size of the array,
            //we double the size of it. Precisely what the ArrayList structure does under the hood.
            strings = (amtStrings > strings.length) ? resize(strings, strings.length * 2) : strings;
            strings[amtStrings - 1] = s;
        }

        return strings;
    }

    /**
     * Dynamically resizes an array of Strings to a new size.
     * @param array old string array
     * @param newSize new size for the array parameter.
     * @return a newly instantiated array with values from array copied over.
     */
    private static String[] resize(String[] array, int newSize) {
        String[] newArray = new String[newSize];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }
}
