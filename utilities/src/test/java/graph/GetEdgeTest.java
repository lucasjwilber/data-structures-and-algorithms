package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetEdgeTest {
    Graph<String, Integer> map;
    @Before
    public void setUp() {
        map = new Graph<>();
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
    }
    @Test
    public void getEdge_returnsFalseIfThereIsNoDirectFlight() {
        String[] itinerary1 = new String[]{"Naboo", "Pandora"};
        String[] itinerary2 = new String[]{"Narnia", "Arendelle", "Naboo"};
        GetEdge.Response trip1 = GetEdge.directRoute(map, itinerary1);
        GetEdge.Response trip2 = GetEdge.directRoute(map, itinerary2);

        assertFalse(trip1.canMakeDirectRoute);
        assertFalse(trip2.canMakeDirectRoute);
    }

    @Test
    public void getEdge_returnsTrueIfThereIsADirectFlight() {
        String[] itinerary1 = new String[]{"Metroville", "Pandora"};
        String[] itinerary2 = new String[]{"Arendelle", "Monstropolis", "Naboo"};
        GetEdge.Response trip1 = GetEdge.directRoute(map, itinerary1);
        GetEdge.Response trip2 = GetEdge.directRoute(map, itinerary2);

        assertTrue(trip1.canMakeDirectRoute);
        assertTrue(trip2.canMakeDirectRoute);
    }

    @Test
    public void getEdge_returnsCostOfZeroIfThereIsNoDirectFlight() {
        String[] itinerary = new String[]{"Narnia", "Arendelle", "Naboo"};
        GetEdge.Response trip = GetEdge.directRoute(map, itinerary);
        assertEquals(0, trip.sumOfWeights);
    }

    @Test
    public void getEdge_returnsActualCostForDirectFlights() {
        String[] itinerary = new String[]{"Arendelle", "Monstropolis", "Naboo"};
        GetEdge.Response trip = GetEdge.directRoute(map, itinerary);
        assertEquals(115, trip.sumOfWeights);
    }
}
