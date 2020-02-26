package graph;

public class GetEdge {

    public static Response directRoute(Graph graph, String[] values) {
        int sumOfWeights = 0;

        //find starting node in the graph using values[0]
        Graph.Node currentPlace = null;
        for (Object place : graph.nodes) {
            currentPlace = (Graph.Node) place;
            if (currentPlace.value.equals(values[0])) break;
        }

        if (currentPlace == null) return new Response(false, 0);
        //loop through the rest of the values
        for (int i = 1; i < values.length; i++) {
            //check if each node has the next one as a neighbor
            Object[] keySet = currentPlace.neighbors.keySet().toArray();
            boolean containsDirectNeighbor = false;
            for (int j = 0; j < keySet.length; j++) {
                Graph.Node node = (Graph.Node) keySet[j];
                if (node.value.equals(values[i])) {
                    //sumOfWeights is the value in for the key 'node' in the neighbors ht
                    sumOfWeights += (Integer) currentPlace.neighbors.get(node);
                    currentPlace = node;
                    containsDirectNeighbor = true;
                }
            }
            //if containsDirectNeighbor was never flipped, there is no direct flight
            if (!containsDirectNeighbor) return new Response(false, 0);
        }

        return new Response(true, sumOfWeights);
    }

    public static class Response {
        boolean canMakeDirectRoute;
        int sumOfWeights;
        Response(boolean canMakeDirectRoute, int sumOfWeights) {
            this.canMakeDirectRoute = canMakeDirectRoute;
            this.sumOfWeights = sumOfWeights;
        }
    }
}
