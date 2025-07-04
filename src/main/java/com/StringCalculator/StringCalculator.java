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
            String customDelimiterSection = numbers.substring(2, delimiterEndIndex);
            if (customDelimiterSection.startsWith("[") && customDelimiterSection.endsWith("]")) {
                String customDelimiter = customDelimiterSection.substring(1, customDelimiterSection.length() - 1);
                delimiter = Pattern.quote(customDelimiter);
            } else {
                delimiter = Pattern.quote(customDelimiterSection);
            }
            numbers = numbers.substring(delimiterEndIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());
            if (num < 0) {
                negatives.add(num);
            }
            if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives are Not allowed" +
                    negatives.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        return sum;
    }
}
