package graph;

import java.util.*;

public class BreadthFirst {

    public static List<Integer> breadthFirst(Graph.Node node) {
        Set<Graph.Node> seenNodes = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        LinkedList<Graph.Node> queue = new LinkedList<>();
        if (node.neighbors.size() == 0) return results;

        queue.add(node);
        while (!queue.isEmpty()) {
            Graph.Node current = queue.removeFirst();
            if (seenNodes.contains(current)) continue;
            seenNodes.add(current);
            results.add(current.value);
            for (Graph.Node neighbor : current.neighbors.keySet()) {
                if (!seenNodes.contains(neighbor)) queue.addLast(neighbor);
            }
        }
        return results;
    }
}
