package graph;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    Graph graph;

    @Test
    public void graph_canInstantiate() {
        graph = new Graph();
        assertNotNull(graph);
    }
    @Test
    public void graph_canAddNewNodes() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        assertNotNull(node1);
        assertEquals(1, node1.value);
    }
    @Test
    public void graph_canAddEdges() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Edge edge = graph.addEdge(node1, node2);
        assertNotNull(edge);
    }
    @Test
    public void graph_canAddEdgesWithWeight() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Edge edge = graph.addEdge(node1, node2, 10);
        assertNotNull(edge);
        assertEquals(10, edge.weight);
    }
    @Test
    public void graph_canGetEdgeWeight() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Edge edge = graph.addEdge(node1, node2, 10);
        assertEquals(10, node1.edges.get(0).weight);
    }
    @Test
    public void graph_edgesAddToNodeNeighborsList() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Edge edge = graph.addEdge(node1, node2);
        assertTrue(node1.neighbors.containsKey(node2));
        assertTrue(node2.neighbors.containsKey(node1));
    }
    @Test
    public void graph_canGetListOfAllNodes() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Node node3 = graph.addNode(223);
        Graph.Node node4 = graph.addNode(543254);
        assertEquals(4, graph.size());
    }
    @Test
    public void graph_nodeNeighborsContainNodesAndWeights() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Edge edge = graph.addEdge(node1, node2, 50);
        assertTrue(node1.neighbors.get(node2) == 50);
        assertTrue(node2.neighbors.get(node1) == 50);
    }
    @Test(expected = NullPointerException.class)
    public void graph_edgesRequireTwoExistingNodes() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Edge edge = graph.addEdge(node1, null);
        assertEquals(1, edge.node1.value);
    }
    @Test
    public void graph_getNodesReturnsListOfNodes() {
        graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(5522342);
        assertEquals(3, graph.getNodes().size());
    }
    @Test
    public void graph_getNeighborsReturnsAHashTableOfNeighbors() {
        graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);

        assertEquals(0, graph.getNeighbors(node1).size());

        graph.addEdge(node1, node2);
        assertEquals(1, graph.getNeighbors(node1).size());
    }
}
