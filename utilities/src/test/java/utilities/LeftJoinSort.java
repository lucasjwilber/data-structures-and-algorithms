package utilities;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LeftJoinSort {
    HashMap<String, String> syn = new HashMap<>();
    HashMap<String, String> ant = new HashMap<>();
    @Before
    public void setUp() {
        syn.put("anger", "rage");
        syn.put("outfit", "garb");

        ant.put("anger", "happiness");
        ant.put("flow", "jam");
    }

    @Test
    public void leftJoin_insertsNullForNonMatches() {
        String[][] joined = LeftJoin.leftJoin(syn, ant);
        assertNull(joined[0][2]);
    }
    @Test
    public void leftJoin_isCaseSensitive() {
        HashMap<String, String> syn = new HashMap<>();
        HashMap<String, String> ant = new HashMap<>();
        syn.put("anger", "rage");
        ant.put("Anger", "happiness");
        assertNull(LeftJoin.leftJoin(syn, ant)[0][2]);
    }

    @Test
    public void leftJoin_returnsArrayOfCorrectMatches() {
        HashMap<String, String> syn = new HashMap<>();
        HashMap<String, String> ant = new HashMap<>();
        syn.put("anger", "rage");
        syn.put("outfit", "garb");
        syn.put("fond", "enamored");
        syn.put("diligent", "employed");
        syn.put("guide", "usher");

        ant.put("anger", "happiness");
        ant.put("flow", "jam");
        ant.put("fond", "averse");
        ant.put("diligent", "idle");
        ant.put("wrath", "delight");

        String expected = "[diligent, employed, idle][outfit, garb, null][anger, rage, happiness][guide, usher, null][fond, enamored, averse]";
        String actual = LeftJoin.stringify(LeftJoin.leftJoin(syn, ant));
        assertEquals(expected, actual);
    }
}
