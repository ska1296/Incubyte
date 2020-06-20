package com.assessment;

import java.util.StringTokenizer;

public class StringCalculator {
    
    private int called = 0;
    
    public int add(String numbers) {
        called++;
        if (numbers.isEmpty())
            return 0;
        int sum = 0;
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            delimiter = getDelimiter(numbers);
            numbers = getNumbers(numbers);
        } else
            numbers = numbers.replace("\n", ",");
        if (numbers.contains(delimiter)) {
            sum = calculateSum(numbers, delimiter);
        } else {
            int result = Integer.parseInt(numbers);
            if (result > 1000)
                result = 0;
            return result;
        }
        return sum;
    }

    private String getNumbers(String numbers) {
        if (numbers.startsWith("//[") && numbers.contains("]\n"))
            numbers = numbers.substring(numbers.indexOf("]\n")+1, numbers.length());
        else
            numbers = numbers.substring(numbers.indexOf('\n')+1, numbers.length());
        return numbers;
    }

    private String getDelimiter(String numbers) {
        String delimter;
        if (numbers.startsWith("//[")) {
            delimter = numbers.substring(numbers.indexOf('[')+1, numbers.indexOf(']'));
        }
        else
            delimter = numbers.substring(0, numbers.indexOf('\n')).replace("//", "");
        if (delimter.isEmpty())
            delimter = "\n";
        return delimter;
    }

    private int calculateSum(String numbers, String delimiter) {
        int sum = 0;
        StringTokenizer strToken = new StringTokenizer(numbers, delimiter);
        boolean negativePresent = false;
        StringBuilder negatives = new StringBuilder();
        while (strToken.hasMoreElements()) {
            String eachNum = strToken.nextToken();
            if (!eachNum.isEmpty()) {
                if (Integer.parseInt(eachNum.trim()) < 0) {
                    negativePresent = true;
                    negatives.append(eachNum+", ");
                }
                if (Integer.parseInt(eachNum.trim()) > 1000)
                    eachNum = "0";
                sum+=Integer.parseInt(eachNum.trim());
            }
        }
        if (negativePresent)
            throw new UnsupportedOperationException("negatives not allowed. Negative numbers: "+negatives.substring(0, negatives.length()-2));
        return sum;
    }

    public int getCalledCount() {
        return called;
    }

}
