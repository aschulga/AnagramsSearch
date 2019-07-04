import controller.ActionsWithDictionary;
import model.Dictionary;
import view.ViewAnagrams;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        ActionsWithDictionary actions = new ActionsWithDictionary(dictionary);
        ViewAnagrams viewAnagrams = new ViewAnagrams(actions);
        viewAnagrams.init();
    }
}