public class Main {
    public static void main(String[] args) {
        // Create a social network.
        Network network = new Network();

        // Add all vertices to this social network.
        network.addVertex("Alice");
        network.addVertex("Bob");
        network.addVertex("Max");
        network.addVertex("Eve");
        network.addVertex("Zoe");
        network.addVertex("Ivy");
        network.addVertex("Amy");

        // Add all edges to this social network.
        network.addEdge("Alice", "Bob");
        network.addEdge("Alice", "Eve");
        network.addEdge("Bob", "Max");
        network.addEdge("Max", "Zoe");
        network.addEdge("Zoe", "Amy");
        network.addEdge("Amy", "Ivy");
        network.addEdge("Eve", "Alice");
        network.addEdge("Eve", "Bob");
        network.addEdge("Eve", "Max");
        network.addEdge("Eve", "Zoe");
        network.addEdge("Eve", "Amy");
        network.addEdge("Eve", "Ivy");

        // Print out the social network.
        System.out.println(network);

        // Print out Alice's friends with level 2.
        System.out.println(network.recommend("Alice", 2));

        // Print out Alice's friends with level 1.
        System.out.println(network.recommend("Alice", 1));

        // Print out Eve's friends with level 2.
        System.out.println(network.recommend("Eve", 2));

        // Print out Ivy's friends with level 1.
        System.out.println(network.recommend("Ivy", 1));
    }
}