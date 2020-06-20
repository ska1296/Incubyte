package com.assessment;

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
            numbers = numbers.substring(numbers.indexOf('\n')+1, numbers.length());
        } else
            numbers = numbers.replace("\n", ",");
        if (numbers.contains(delimiter)) {
            sum = calculateSum(numbers, delimiter);
        } else
            return Integer.parseInt(numbers);
        
        return sum;
    }

    private String getDelimiter(String numbers) {
        String delimter;
        delimter = numbers.substring(0, numbers.indexOf('\n')).replace("//", "");
        if (delimter.isEmpty())
            delimter = "\n";
        return delimter;
    }

    private int calculateSum(String numbers, String delimiter) {
        int sum = 0;
        String [] input = numbers.split(delimiter);
        boolean negativePresent = false;
        StringBuilder negatives = new StringBuilder();
        for (String eachNum : input) {
            if (!eachNum.isEmpty()) {
                if (Integer.parseInt(eachNum.trim()) < 0) {
                    negativePresent = true;
                    negatives.append(eachNum+", ");
                }
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
