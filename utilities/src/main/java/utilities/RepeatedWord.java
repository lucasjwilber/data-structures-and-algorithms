package utilities;

import java.util.ArrayList;

public class RepeatedWord {
    public static String repeatedWord(String input) {
        if (input == null || input.equals("")) return null;

        for (int i = 0; i < input.length(); i++) {

        }








        String[] words = input.split(" ");
        ArrayList<String> seenWords = new ArrayList<>();

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
            //return the word if it's a repeat
            if (seenWords.contains(lcword)) {
                return lcword;
            } else {
                seenWords.add(lcword);
            }
        }
        //if no repeats were seen
        return null;
    }
}
