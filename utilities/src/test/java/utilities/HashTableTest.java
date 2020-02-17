package utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable ht;
    @Before
    public void setUp() {
        ht = new HashTable(1024);
    }
    @Test
    public void hashTable_canInit() {
        HashTable ht1 = new HashTable(1020);
        assertNotNull(ht1);
    }
    @Test
    public void hashTable_hashesStrings() {
        //hacky way of checking for a number
        assertTrue(HashTable.hash("foo") > 0);
    }
    @Test
    public void hashTable_canInsert() {
        //basically no NPE == pass
        ht.insert("color", "blue");
    }
    @Test public void hashTable_canGet() {
        ht.insert("capital of the world", "flavortown");
        assertEquals("flavortown", ht.get("capital of the world"));
    }
    @Test
    public void hashTable_contains() {
        ht.insert("abra", "kadabra");
        assertTrue(ht.contains("abra"));
        assertFalse(ht.contains("as;ldfjasldfjasdf"));
    }
    @Test
    public void hashTable_handlesCollisions() {
        ht.insert("abc", "first");
        ht.insert("bca", "second");
        ht.insert("cab", "third");
        //verify they all get the same hash/same bucket first
        assertEquals(HashTable.hash("abc"), HashTable.hash("bca"), HashTable.hash("cab"));

        assertEquals(ht.get("abc"), "first");
        assertEquals(ht.get("bca"), "second");
        assertEquals(ht.get("cab"), "third");
    }
}
