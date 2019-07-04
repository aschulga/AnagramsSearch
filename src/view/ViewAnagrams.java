package view;

import controller.ActionsWithDictionary;

import java.io.IOException;
import java.util.Collection;

public class ViewAnagrams {
    private static String PATH_NAME = "dictionary.txt";
    private static String ANAGRAM_FOR_SEARCH = "шубка";

    private ActionsWithDictionary actions;

    public ViewAnagrams(ActionsWithDictionary actions) {
        this.actions = actions;
    }

    public void init() {
        try {
            actions.getFileContent(PATH_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collection anagrams = actions.collectAnagrams(actions.getDictionary(), ANAGRAM_FOR_SEARCH);

        if (anagrams != null) {
            System.out.println("Output (anagrams found):");
            for (Object anagram : anagrams) {
                System.out.print(anagram + " ");
            }
        }
    }
}