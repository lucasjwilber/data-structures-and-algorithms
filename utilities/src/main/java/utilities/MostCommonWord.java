package utilities;

import java.util.Hashtable;

public class MostCommonWord {
    public static String mostCommonWord(String input) {
        if (input == null || input.equals("")) return null;
        String[] words = input.split(" ");
        int highestCount = 0;
        String mostCommonWord = null;
        Hashtable<String, Integer> wordsTable = new Hashtable<>();

        for (String word : words) {
            //lowercaseify the word and remove trailing punctuation for fair comparisons
            String lcword = word.toLowerCase();
            if (lcword.substring(lcword.length() - 1).equals(",") ||
                    lcword.substring(lcword.length() - 1).equals(".") ||
                    lcword.substring(lcword.length() - 1).equals("'") ||
                    lcword.substring(lcword.length() - 1).equals("\"") ||
                    lcword.substring(lcword.length() - 1).equals("!"))
            {
                lcword = lcword.substring(0, lcword.length() - 1);
            }
            //remove leading punctuation
            if (lcword.substring(1).equals("'") ||
                    lcword.substring(1).equals(("\""))) {
                lcword = lcword.substring(1);
            }

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
}
