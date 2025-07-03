package com.StringCalculator;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers){
        if(numbers == null || numbers.isEmpty()) return 0;

       String delimiter = "[,\n]"; // this is default delimiter
        if(numbers.startsWith("//")){
            int delimiterEndIndex = numbers.indexOf("\n");
            String customdelimiter = numbers.substring(2,delimiterEndIndex);
            delimiter = Pattern.quote(customdelimiter);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

       return sum;
    }
}
