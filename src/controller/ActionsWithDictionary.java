package controller;

import model.Dictionary;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ActionsWithDictionary {
    private Dictionary dictionary;

    public ActionsWithDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String[] getDictionary() {
        return dictionary.getDictionary();
    }

    public void getFileContent(String pathName) throws IOException {
        Scanner fileIn = new Scanner(new BufferedInputStream(new FileInputStream(
                new File(pathName)), 20 * 1024 * 1024), "Cp1251");
        int i = 0;
        while (fileIn.hasNextLine()) {
            String word = fileIn.nextLine();
            if (!word.matches("\\n")) {
                getDictionary()[i] = word;
                i++;
            }
        }
    }

    public Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        HashMap<String, List<String>> wordsMap = new HashMap<>();

        for (String word : dictionary) {
            String key = getKey(word);
            if (!wordsMap.containsKey(key)) {
                wordsMap.put(key, new ArrayList<>());
            }
            wordsMap.get(key).add(word);
        }

        String searchKey = getKey(searchAnagramsFor);
        return wordsMap.get(searchKey);
    }

    private String getKey(String word) {
        Map<Integer, Integer> map = new TreeMap<>();
        word = word.toLowerCase().trim(); // algorithm not be case-sensitive

        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i);
            int value = 1;

            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + value);
        }

        StringBuilder keyValueStringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            keyValueStringBuilder.append(entry.getKey().toString());
            keyValueStringBuilder.append(entry.getValue().toString());
        }

        return keyValueStringBuilder.toString();
    }
}
