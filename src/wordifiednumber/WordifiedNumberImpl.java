/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordifiednumber;

/**
 *
 * @author sergio.duarte
 */
public class WordifiedNumberImpl implements WordifiedNumber {

    /**
     * Array used for converting "tens words" into equivalent words.
     */
    final private static String[] tensWords = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    /**
     * Array used for converting units into equivalent words.
     */
    final private static String[] unitsWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    /**
     * Method to convert the Number into words
     * @param i, The number to convert
     * @return The same number in words
     */
    private String convert(int i) {
        if (i < 20) {
            return unitsWords[i];
        }
        if (i < 100) {
            return tensWords[i / 10] + ((i % 10 > 0) ? " " + convert(i % 10) : "");
        }
        if (i < 1000) {
            return unitsWords[i / 100] + " hundred" + ((i % 100 > 0) ? " and " + convert(i % 100) : "");
        }
        if (i < 1000000) {
            return convert(i / 1000) + " thousand" + ((i % 1000 > 0) ? ((i % 1000 < 10) ? " and " : " ") + convert(i % 1000) : "");
        }
        return convert(i / 1000000) + " million" + ((i % 1000000 > 0) ? ((i % 1000000 < 100) ? " and " : " ") + convert(i % 1000000) : "");
    }
    
    /**
     * Public Method to convert the Number into words
     * @param number, The number to convert
     * @return The same number in words
     */
    @Override
    public String toWords(int number) {
        return convert(number);
    }
}
