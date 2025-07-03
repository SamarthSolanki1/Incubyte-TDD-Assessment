package com.StringCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());
            if(num < 0){
                negatives.add(num);
            }
            sum += num;
        }
        if(!negatives.isEmpty()){
            throw new IllegalArgumentException("Negatives are Not allowed" +
                    negatives.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }


       return sum;
    }
}
