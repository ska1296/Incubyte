package com.assessment;

import java.util.StringTokenizer;

public class StringCalculator {

    private int called = 0;
    public int add(String numbers) {
        called++;
        if (numbers.isEmpty())
            return 0;
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            delimiter = getDelimiter(numbers);
            numbers = getNumbers(numbers);
        } else
            numbers = numbers.replace("\n", ",");
        return calculateSum(numbers, delimiter);
    }

    private String getNumbers(String numbers) {
        if (numbers.startsWith("//[") && numbers.contains("]\n"))
            numbers = numbers.substring(numbers.indexOf("]\n")+1, numbers.length());
        else
            numbers = numbers.substring(numbers.indexOf('\n')+1, numbers.length());
        return numbers;
    }

    private String getDelimiter(String numbers) {
        String delimiter;
        if (numbers.startsWith("//[")) {
            delimiter = numbers.substring(numbers.indexOf('[')+1, numbers.indexOf("]\n"));
            delimiter = delimiter.replace("[", "");
            delimiter = delimiter.replace("]", "");
        }
        else
            delimiter = numbers.substring(0, numbers.indexOf('\n')).replace("//", "");
        if (delimiter.isEmpty())
            delimiter = "\n";
        return delimiter;
    }

    private int calculateSum(String numbers, String delimiter) {
        int sum = 0;
        StringTokenizer strToken = new StringTokenizer(numbers, delimiter);
        boolean negativePresent = false;
        StringBuilder negatives = new StringBuilder();
        while (strToken.hasMoreElements()) {
            String eachNum = strToken.nextToken();
            if (!eachNum.isEmpty()) {
                negativePresent = handleNegative(negativePresent, negatives, eachNum);
                eachNum = handleBigValues(eachNum);
                sum+=Integer.parseInt(eachNum.trim());
            }
        }
        if (negativePresent)
            throw new UnsupportedOperationException("negatives not allowed. Negative numbers: "+negatives.substring(0, negatives.length()-2));
        return sum;
    }

    private String handleBigValues(String eachNum) {
        if (Integer.parseInt(eachNum.trim()) > 1000)
            eachNum = "0";
        return eachNum;
    }

    private boolean handleNegative(boolean negativePresent, StringBuilder negatives,String eachNum) {
        if (Integer.parseInt(eachNum.trim()) < 0) {
            negativePresent = true;
            negatives.append(eachNum+", ");
        }
        return negativePresent;
    }

    public int getCalledCount() {
        return called;
    }

}
