package com.assessment;

import java.util.StringTokenizer;
import static com.assessment.constants.Constants.*;

public class StringCalculator {

    private int timesAddIsCalled = 0;
    
    public int add(String numbers) {
        timesAddIsCalled++;
        if (numbers.isEmpty())
            return 0;
        String delimiter = COMMA;
        if (numbers.startsWith(DOUBLE_SLASH)) {
            delimiter = getDelimiter(numbers);
            numbers = getNumbers(numbers);
        } else {
            numbers = numbers.replace(NEW_LINE, COMMA);
        }
        return calculateSum(numbers, delimiter);
    }

    private String getNumbers(String numbers) {
        if (numbers.startsWith(DOUBLE_SLASH_BRACKET) && numbers.contains(BRACKET_NEW_LINE)) {
            numbers = numbers.substring(numbers.indexOf(BRACKET_NEW_LINE) + 1, numbers.length());
        } else {
            numbers = numbers.substring(numbers.indexOf(NEW_LINE) + 1, numbers.length());
        }
        return numbers;
    }

    private String getDelimiter(String numbers) {
        String delimiter;
        if (numbers.startsWith(DOUBLE_SLASH_BRACKET)) {
            delimiter = numbers.substring(numbers.indexOf(OPENING_BRACKET) + 1, numbers.indexOf(BRACKET_NEW_LINE));
            delimiter = delimiter.replace(OPENING_BRACKET, EMPTY);
            delimiter = delimiter.replace(CLOSING_BRACKET, EMPTY);
        } else {
            delimiter = numbers.substring(0, numbers.indexOf(NEW_LINE)).replace(DOUBLE_SLASH, EMPTY);
        }
        
        if (delimiter.isEmpty()) {
            delimiter = NEW_LINE;
        }
        
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
                sum += Integer.parseInt(eachNum.trim());
            }
        }
        
        if (negativePresent) {
            throw new UnsupportedOperationException("negatives not allowed. Negative numbers: "+negatives.substring(0, negatives.length()-2));
        }
        
        return sum;
    }

    private String handleBigValues(String eachNum) {
        if (Integer.parseInt(eachNum.trim()) > 1000) {
            eachNum = "0";
        }
        
        return eachNum;
    }

    private boolean handleNegative(boolean negativePresent, StringBuilder negatives,String eachNum) {
        if (Integer.parseInt(eachNum.trim()) < 0) {
            negativePresent = true;
            negatives.append(eachNum+COMMA_SPACE);
        }
        
        return negativePresent;
    }

    public int getCalledCount() {
        return timesAddIsCalled;
    }

}
