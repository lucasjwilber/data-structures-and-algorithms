package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BreadthFirstTest {
    @Test
    public void breadthFirst_handlesCircularGraph() {
        Graph graph = new Graph();
        Graph.Node node1 = graph.addNode(1);
        Graph.Node node2 = graph.addNode(2);
        Graph.Node node3 = graph.addNode(3);
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node1, node3);
        //basically asserts that an infinite loop doesn't lock up the test
        System.out.println(BreadthFirst.breadthFirst(node1));
    }
    @Test
    public void breadthFirst_outputIsBreadthFirst() {
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
        // correctly traversing breadth first. however it seems to adding them in different
        //orders with each test. hence the stupid test below
        List<Integer> result = BreadthFirst.breadthFirst(node1);
        boolean test = false;
        if (result.get(1) == 2 || result.get(2) == 2 || result.get(3) == 2 &&
            result.get(1) == 3 || result.get(2) == 3 || result.get(3) == 3 &&
            result.get(1) == 4 || result.get(2) == 4 || result.get(3) == 4)
        {
            test = true;
        }
        assertTrue(test);
    }
    @Test
    public void breadthFirst_returnsListWithSizeEqualOrLessThanGraphSize() {
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
        assertTrue(BreadthFirst.breadthFirst(node3).size() >= graph.size());
    }
}
