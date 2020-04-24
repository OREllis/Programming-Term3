package com.uni.term3.programming.week2.examples;

import com.sun.istack.internal.NotNull;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    private final HashMap<Node, LinkedList<Node>> adjacencyMap;
    private final boolean directed;

    public Graph() {
        this(false);
    }

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

    public void printEdges() {
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

        CollectionUtils.emptyIfNull(adjacencyMap.get(target)).stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(this::depthFirstSearch);
    }

    @NotNull
    public void breadthFirstSearch(final Node node) {
        final LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            final Node current = queue.removeFirst();

            if (!current.isVisited()) {
                current.visit();
                System.out.print(current.getName() + " ");

                CollectionUtils.emptyIfNull(adjacencyMap.get(current)).stream()
                        .filter(neighbor -> !neighbor.isVisited())
                        .forEach(queue::add);
            }
        }

        System.out.println();
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
        adjacencyMap.putIfAbsent(key, null);
    }
}
