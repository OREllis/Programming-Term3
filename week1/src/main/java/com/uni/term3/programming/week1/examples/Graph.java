package com.uni.term3.programming.week1.examples;

import java.util.HashMap;
import java.util.LinkedList;

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
