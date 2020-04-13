package com.uni.term3.programming.week2.examples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;

public class Graph {

    private final HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(final boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public void addEdge(final Node source, final Node destination) {
        addKeyIfNotInMap(source);
        addKeyIfNotInMap(destination);

        addEdgeHelper(source, destination);

        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    public void printEdgres() {
        for (Node n : adjacencyMap.keySet()) {
            System.out.print("The " + n.getName() + " has an edge towards ");
            adjacencyMap.get(n).forEach(neighbor -> System.out.print(neighbor.getName() + " "));
            System.out.println();
        }
    }

    public boolean hasEdge(final Node src, final Node dest) {
        return adjacencyMap.containsKey(src) && adjacencyMap.get(src).contains(dest);
    }

    public void depthFirstSearch(final Node target) {
        target.visit();
        System.out.print(target.getName() + " ");

        final LinkedList<Node> neighbors = adjacencyMap.get(target);

        if (neighbors != null) {
            for (Node neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    depthFirstSearch(neighbor);
                }
            }
        }
    }

    private void addEdgeHelper(final Node a, final Node b) {
        LinkedList<Node> temp = adjacencyMap.get(a);

        if (temp != null) {
            temp.remove(b);
        } else {
            temp = new LinkedList<>();
        }

        temp.add(b);
        adjacencyMap.put(a, temp);
    }

    private void addKeyIfNotInMap(final Node key) {
        if (!adjacencyMap.containsKey(key)) {
            adjacencyMap.put(key, null);
        }
    }
}
