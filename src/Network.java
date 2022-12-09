import java.util.*;

/**
 * Class to store and manipulate social networks.
 */
public class Network {
    // Adjacency List used to store follow information.
    Map<String, LinkedList<String>> adjList;

    /**
     * This is the constructor of the Network class.
     */
    Network() {
        adjList = new HashMap<String, LinkedList<String>>();
    }

    /**
     * Add a vertex to the social network.
     * @param vertex The vertex to add to the network.
     */
    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<String>());
    }

    /**
     * Add edges to the social network.
     * @param start The start of the edge.
     * @param end The end of the edge.
     */
    public void addEdge(String start, String end) {
        adjList.get(start).add(end);
    }

    /**
     * Get adjacent nodes of a specific node.
     * @param node Current node that want to get adjacent node with.
     * @return A list of adjacent nodes of current node.
     */
    public List<String> getAdjNodes(String node) {
        return adjList.get(node);
    }

    // Find all the mutual friends for a node in the network.

    // FInd all the shortest path between two people in the network.

    /**
     * Find the nth level friends for a person in the network.
     * @param node Current node to find nth level friends with.
     * @param depth Depth to find friends with.
     * @return A list of friends of `node` with level `depth`.
     */
    public List<String> recommend(String node, int depth) {
        // Standard BFS add nodes within specific depth to res.
        List<String> res = new LinkedList<String>();

        final int V = this.getVertexNum();

        // Store nodes already visited.
        Map<String, Boolean> visited = new HashMap<String, Boolean>();

        // Create a queue for BFS method
        LinkedList<String> queue = new LinkedList<String>();

        // Add the source node to queue and mark it as visited.
        visited.put(node, true);
        queue.add(node);
        // Using null to help keep level information.
        queue.add(null);

        int current_depth = 1;

        // If the queue is not empty and not reach the specific level, continue the loop.
        while (queue.size()!= 0 && current_depth <= depth) {
            // Dequeue a vertex from the queue.
            String s = queue.poll();

            if (s == null) {
                current_depth++;
                queue.add(null);
            } else {
                // Get all adjacent nodes of the current node.
                List<String> adjNodes = this.getAdjNodes(s);

                // Iterate all adjacent nodes and add them to res, queue and mark them as visited.
                Iterator<String> itr = adjNodes.iterator();
                while (itr.hasNext()) {
                    String newNode = itr.next();
                    if (!visited.getOrDefault(newNode, false)) {
                        visited.put(newNode, true);
                        queue.add(newNode);
                        res.add(newNode);
                    }
                }

            }
        }

        return res;
    }

    private int getVertexNum() {
        return adjList.size();
    }

    @Override
    public String toString() {
        return "adjacencyList=" + adjList;
    }
}
