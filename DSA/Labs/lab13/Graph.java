package lab13;
import java.util.ArrayList;

public class Graph {
    private int numVertices;
    private ArrayList<ArrayList<Edge>> adjacencyList;

    // Constructor for the Graph
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Inner class to represent an Edge
    static class Edge {
        int source;
        int dest;

        // Constructor for Edge
        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }

        @Override
        public String toString() {
            return "(" + source + " -> " + dest + ")";
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int dest) {
        // Add edge from source to dest
        adjacencyList.get(source).add(new Edge(source, dest));

        // Add edge from dest to source for an undirected graph
        adjacencyList.get(dest).add(new Edge(dest, source));
    }

    // Method to print the adjacency list
    public void getAllNeighbour() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(" " + edge);
            }
            System.out.println();
        }
    }

    // Main method to test the graph implementation
    public static void main(String[] args) {
        Graph graph = new Graph(5); // Create a graph with 5 vertices

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the adjacency list of the graph
        graph.getAllNeighbour();
    }
}

