package graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph {

    List<Node> nodes = new ArrayList<>();

    public class Node {
        List<Edge> edges;
        Hashtable<Node, Integer> neighbors;
        int value;
        Node(int value) {
            this.value = value;
            this.edges = new ArrayList<>();
            this.neighbors = new Hashtable<>();
        }
    }

    public class Edge {
        Node node1;
        Node node2;
        int weight;
        Edge (Node node1, Node node2) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = 0;
        }
        Edge (Node node1, Node node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
        void setWeight(int weight) { this.weight = weight; }
    }

    public Node addNode(int value) {
        Node node = new Node(value);
        nodes.add(node);
        return node;
    }

    public Edge addEdge(Node node1, Node node2) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge edge = new Edge(node1, node2);
            node1.edges.add(edge);
            node1.neighbors.put(node2, 0);
            node2.edges.add(edge);
            node2.neighbors.put(node1, 0);
            return edge;
        } else {
            return null;
        }
    }
    public Edge addEdge(Node node1, Node node2, int weight) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge edge = new Edge(node1, node2, weight);
            node1.edges.add(edge);
            node1.neighbors.put(node2, weight);
            node2.edges.add(edge);
            node2.neighbors.put(node1, weight);
            return edge;
        } else {
            return null;
        }
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public Hashtable<Node, Integer> getNeighbors(Node node) {
        return node.neighbors;
    }

    public int size() {
        return this.nodes.size();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node1 = graph.addNode(1);
        Node node2 = graph.addNode(2);
        Node node3 = graph.addNode(3);
        Edge edge12 = graph.addEdge(node1, node2);
        Edge edge23 = graph.addEdge(node2, node3);
        Edge edge13 = graph.addEdge(node1, node3);
        System.out.println(graph.size());
    }


}
