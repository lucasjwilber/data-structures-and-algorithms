package utilities;

import java.util.Hashtable;

public class RepeatedWord {
    public static String repeatedWord(String input) {
        if (input == null || input == "") return null;
        String[] words = input.split(" ");
        int highestCount = 0;
        String mostCommonWord = null;
        Hashtable<String, Integer> wordsTable = new Hashtable<>();

        for (String word : words) {
            String lcword = word.toLowerCase();
            int count = 1;
            if (wordsTable.containsKey(lcword)) {
                count = wordsTable.get(lcword) + 1;
            }
            wordsTable.put(lcword, count);

            if (count > highestCount) {
                highestCount = count;
                mostCommonWord = lcword;
            }
        }
        return mostCommonWord;
    }

    public static void main(String[] args) {
        String example1 = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        System.out.println(repeatedWord(example1));
        System.out.println(repeatedWord("the is but is man is"));
    }
}
