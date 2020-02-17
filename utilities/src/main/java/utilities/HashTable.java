package utilities;

import java.util.LinkedList;
import java.util.ListIterator;

@SuppressWarnings("unchecked")
public class HashTable {
    int size;
    LinkedList<Entry>[] table;

    public HashTable(int size) {
        this.table = new LinkedList[size];
    }

    public static int hash(String key) {
        int index = 1;
        for (int i = 0; i < key.length(); i++) {
            index *= key.charAt(i);
        }
        return index % 599;
    }

    public static class Entry {
        public String key;
        public String value;
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void insert(String key, String value) {
        int index = hash(key);
        //ty Stefan https://stackoverflow.com/questions/20202889/how-can-i-create-an-array-of-linked-lists-in-java
        if (table[index] == null) {
            table[index] = new LinkedList<Entry>();
        }
        table[index].add(new Entry(key, value));
    }

    public String get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        if (bucket != null) {
            ListIterator<Entry> bucketList = bucket.listIterator(0);
            while (bucketList.hasNext()) {
                Entry current = bucketList.next();
                if (current.key.equals(key))
                    return current.value;
            }
        }
        return "Entry not found.";
    }

    public boolean contains(String key) {
        return (!this.get(key).equals("Entry not found."));
    }

}
