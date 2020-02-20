package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class LeftJoin {
    public static String[][] leftJoin(HashMap<String, String> syn, HashMap<String, String> ant) {
        Iterator synIt = syn.entrySet().iterator();
        String[][] result = new String[syn.size()][];
        int i = 0;
        while (synIt.hasNext()) {
            String[] strArr = new String[3];
            //get just the key from the entry
            String key = synIt.next().toString().split("=")[0];
            strArr[0] = key;
            strArr[1] = syn.get(key);
            strArr[2] = ant.containsKey(key) ? ant.get(key) : null;
            result[i] = (strArr);
            i++;
        }
        return result;
    }

    public static String stringify(String[][] input) {
        StringBuilder response = new StringBuilder();
        for (String[] strArr : input) {
            response.append(Arrays.toString(strArr));
        }
        return response.toString();
    }

    public static void main(String[] args) {
        HashMap<String, String> syn = new HashMap<>();
        syn.put("anger", "rage");
        syn.put("outfit", "garb");
        HashMap<String, String> ant = new HashMap<>();
        ant.put("anger", "happiness");
        ant.put("flow", "jam");
        System.out.println(stringify(leftJoin(syn, ant)));
    }
}
