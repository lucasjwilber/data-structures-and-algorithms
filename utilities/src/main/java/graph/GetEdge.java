package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class GetEdge {

    public static Response directFlights(Graph map, String[] cities) {
        boolean canMakeDirectTrip = true;
        int cost = 0;

        //find starting node in map using cities[0]
        Graph.Node currentPlace = null;
        for (Object place : map.nodes) {
            currentPlace = (Graph.Node) place;
            if (currentPlace.value.equals(cities[0])) break;
        }

        if (currentPlace == null) return new Response(false, 0);
        //loop through the rest of the cities
        for (int i = 1; i < cities.length; i++) {
            //check if each city has the next one as a neighbor
            Object[] keySet = currentPlace.neighbors.keySet().toArray();
            boolean containsDirectNeighbor = false;
            for (int j = 0; j < keySet.length; j++) {
                Graph.Node node = (Graph.Node) keySet[j];
                if (node.value.equals(cities[i])) {
                    //cost is the value in for the key 'node' in the neighbors ht
                    cost += (Integer) currentPlace.neighbors.get(node);
                    currentPlace = node;
                    containsDirectNeighbor = true;
                }
            }
            if (!containsDirectNeighbor) return new Response(false, 0);
        }

        return new Response(canMakeDirectTrip, cost);
    }

    public static class Response {
        boolean canMakeDirectTrip;
        String cost;
        Response(boolean canMakeDirectTrip, int cost) {
            this.canMakeDirectTrip = canMakeDirectTrip;
            this.cost = "$" + Integer.toString(cost);
        }
    }

    public static void main(String[] args) {
        Graph<String, Integer> map = new Graph<>();
        {
            Graph.Node pandora = map.addNode("Pandora");
            Graph.Node metroville = map.addNode("Metroville");
            Graph.Node arendelle = map.addNode("Arendelle");
            Graph.Node narnia = map.addNode("Narnia");
            Graph.Node naboo = map.addNode("Naboo");
            Graph.Node monstropolis = map.addNode("Monstropolis");
            map.addEdge(pandora, metroville, 82);
            map.addEdge(pandora, arendelle, 150);
            map.addEdge(arendelle, metroville, 99);
            map.addEdge(arendelle, monstropolis, 42);
            map.addEdge(metroville, monstropolis, 105);
            map.addEdge(metroville, narnia, 37);
            map.addEdge(metroville, naboo, 26);
            map.addEdge(narnia, naboo, 250);
            map.addEdge(naboo, monstropolis, 73);
        }
        String[] trip1 = new String[]{"Metroville", "Pandora"};
        String[] trip2 = new String[]{"Arendelle", "Monstropolis", "Naboo"};
        String[] trip3 = new String[]{"Naboo", "Pandora"};
        String[] trip4 = new String[]{"Narnia", "Arendelle", "Naboo"};

        Response cando1 = directFlights(map, trip1);
        Response cando2 = directFlights(map, trip2);
        Response cando3 = directFlights(map, trip3);
        Response cando4 = directFlights(map, trip4);
        System.out.println(cando1.canMakeDirectTrip + ", " + cando1.cost);
        System.out.println(cando2.canMakeDirectTrip + ", " + cando2.cost);
        System.out.println(cando3.canMakeDirectTrip + ", " + cando3.cost);
        System.out.println(cando4.canMakeDirectTrip + ", " + cando4.cost);
    }
}
