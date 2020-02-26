package graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph<T, W> {

    public List<Node<T>> nodes = new ArrayList<>();

    public class Node<T> {
        public ArrayList<Edge<W>> edges;
        public Hashtable<Node, W> neighbors;
        public T value;
        Node(T value) {
            this.value = value;
            this.edges = new ArrayList<Edge<W>>();
            this.neighbors = new Hashtable<>();
        }
    }

    public class Edge<W> {
        public Node node1;
        public Node node2;
        public W weight;
        Edge (Node node1, Node node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
        Edge (Node node1, Node node2, W weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }
        public void setWeight(W weight) { this.weight = weight; }
        public W getWeight() { return this.weight; }
    }

    public Node<T> addNode(T value) {
        Node<T> node = new Node<T>(value);
        nodes.add(node);
        return node;
    }

    public Edge<W> addEdge(Node node1, Node node2) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge<W> edge = new Edge<W>(node1, node2);
            node1.edges.add(edge);
            node1.neighbors.put(node2, 0);
            node2.edges.add(edge);
            node2.neighbors.put(node1, 0);
            return edge;
        } else {
            return null;
        }
    }
    public Edge<W> addEdge(Node node1, Node node2, W weight) {
        if (nodes.contains(node1) && nodes.contains(node2)) {
            Edge<W> edge = new Edge<>(node1, node2, weight);
            node1.edges.add(edge);
            node1.neighbors.put(node2, weight);
            node2.edges.add(edge);
            node2.neighbors.put(node1, weight);
            return edge;
        } else {
            return null;
        }
    }

    public List<Node<T>> getNodes() {
        return this.nodes;
    }

    public Hashtable<Node<T>, Integer> getNeighbors(Node node) {
        return node.neighbors;
    }

    public int size() {
        return this.nodes.size();
    }

}
