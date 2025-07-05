package com.StringCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;

        String delimiter = "[,\n]";

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiterSection = numbers.substring(2, delimiterEndIndex);
            if(delimiterSection.contains("[") && delimiterSection.contains("]")) {
                List<String> delimiters = new ArrayList<>();
                int i = 0;
                while (i < delimiterSection.length()) {
                    if (delimiterSection.charAt(i) == '[') {
                        int closeIndex = delimiterSection.indexOf(']', i);
                        String delim = delimiterSection.substring(i + 1, closeIndex);
                        delimiters.add(Pattern.quote(delim));
                        i = closeIndex + 1;
                    } else {
                        i++;
                    }
                }
                delimiter = String.join("|", delimiters);
            } else {
                delimiter = Pattern.quote(delimiterSection);
            }
            numbers = numbers.substring(delimiterEndIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (part.trim().isEmpty()) continue;
            int num = Integer.parseInt(part.trim());
            if (num < 0) {
                negatives.add(num);
            }
            if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives are Not allowed: " +
                    negatives.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }


        return sum;
    }
}
