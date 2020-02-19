package utilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RepeatedWordTest {
    @Test
    public void repeatedWord_returnsFirstRepeatedWord() {
        String testInput = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        String expected = "it";
        String actual = RepeatedWord.repeatedWord(testInput);
        assertEquals(expected, actual);
    }
    @Test
    public void repeatedWord_testStringWithPunctuation() {
        String testInput = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";
        String expected = "summer";
        String actual = RepeatedWord.repeatedWord(testInput);
        assertEquals(expected, actual);
    }
    @Test
    public void repeatedWord_notCaseSensitive() {
        String testInput = "tHe fIrSt rEpEatEd WorD iN thIs SeNtEnCe iS REPEAted";
        String expected = "repeated";
        String actual = RepeatedWord.repeatedWord(testInput);
        assertEquals(expected, actual);
    }
    @Test
    public void repeatedWord_returnsNullForEmptyStrings() {
        String testInput = "";
        assertNull(RepeatedWord.repeatedWord(testInput));
    }
    @Test
    public void repeatedWord_returnsNullForNullStrings() {
        String testInput = null;
        assertNull(RepeatedWord.repeatedWord(testInput));
    }
    @Test
    public void repeatedWord_ignoresTailingPunctuation() {
        String testInput = "He was. Was she?";
        String expected = "was";
        String actual = RepeatedWord.repeatedWord(testInput);
        assertEquals(expected, actual);
    }
}
