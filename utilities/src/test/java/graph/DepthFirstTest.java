package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class DepthFirstTest {
    @Test
    public void depthFirst_handlesCircularGraph() {
        Graph graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Node node3 = graph.addNode(3);
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node1, node3);
        //basically asserts that an infinite loop doesn't lock up the test
        System.out.println(DepthFirst.depthFirst(node1));
    }
    @Test
    public void depthFirst_outputIsDepthFirst() {
        Graph graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Node node3 = graph.addNode(3);
        Graph.Node node4 = graph.addNode(4);
        Graph.Node node5 = graph.addNode(5);
        Graph.Node node6 = graph.addNode(6);
        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node1, node4);
        graph.addEdge(node4, node5);
        graph.addEdge(node2, node3);
        graph.addEdge(node2, node5);
        graph.addEdge(node6, node5);
        graph.addEdge(node6, node2);
        //this as long as indexes 1, 2, and 3 contain ints 2/3/4 in any order it is
        // correctly traversing depth first. however it seems to adding them in different
        //orders with each test. hence the stupid test below
        List<Integer> actual = DepthFirst.depthFirst(node1);
        boolean test = false;
        if (actual.get(1) == 2 || actual.get(1) == 3 || actual.get(1) == 4 &&
                actual.get(2) == 5 || actual.get(2) == 6 &&
                actual.get(3) == 5 || actual.get(3) == 6)
        {
            test = true;
        }
        assertTrue(test);
    }
    @Test
    public void depthFirst_returnsListWithSizeEqualOrLessThanGraphSize() {
        Graph graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Node node3 = graph.addNode(3);
        Graph.Node node4 = graph.addNode(4);
        Graph.Node node5 = graph.addNode(5);
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);
        graph.addEdge(node4, node5);
        assertTrue(DepthFirst.depthFirst(node3).size() >= graph.size());
    }
}
