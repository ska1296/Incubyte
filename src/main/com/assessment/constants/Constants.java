package com.assessment.constants;


public class Constants {

    private Constants() {
        throw new IllegalStateException("Constants class");
    }

    public static final String CLOSING_BRACKET = "]";
    public static final String COMMA = ",";
    public static final String DOUBLE_SLASH = "//";
    public static final String EMPTY = "";
    public static final String NEW_LINE = "\n";
    public static final String OPENING_BRACKET = "[";

    public static final String DOUBLE_SLASH_BRACKET = DOUBLE_SLASH+OPENING_BRACKET;
    public static final String BRACKET_NEW_LINE = CLOSING_BRACKET+NEW_LINE;
    public static final String COMMA_SPACE = COMMA+" ";

    public static final String NO_NEGATIVES = "negatives not allowed.";

}
