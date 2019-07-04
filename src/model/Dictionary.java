package model;

public class Dictionary {
    private static int NUMBER_OF_RECORDS = 125723;
    private String[] dictionary;

    public Dictionary() {
        dictionary = new String[NUMBER_OF_RECORDS];
    }

    public String[] getDictionary() {
        return dictionary;
    }
}