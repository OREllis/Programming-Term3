package com.uni.term3.programming.week2.examples;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

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
        adjacencyMap.putIfAbsent(source, null);
        adjacencyMap.putIfAbsent(destination, null);

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
        return adjacencyMap.containsKey(src) && CollectionUtils.emptyIfNull(adjacencyMap.get(src)).contains(dest);
    }

    public void depthFirstSearch(final Node target) {
        target.visit();
        System.out.print(target.getName() + " ");

        CollectionUtils.emptyIfNull(adjacencyMap.get(target)).stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(this::depthFirstSearch);
    }

    public void breadthFirstSearch(final Node node) {
        final LinkedList<Node> queue = new LinkedList<>(Collections.singletonList(node));

        while (!queue.isEmpty()) {
            final Node current = queue.removeFirst();

            if (current.isNorVisited()) {
                current.visit();
                System.out.print(current.getName() + " ");

                CollectionUtils.emptyIfNull(adjacencyMap.get(current)).stream()
                        .filter(neighbor -> !neighbor.isVisited())
                        .forEach(queue::add);
            }
        }

        System.out.println();
    }

    public void printTransitiveClosure() {
        List<Node> graphNodes = new ArrayList<>(adjacencyMap.keySet());
        graphNodes.sort(new Node.NodeComparator());

        System.out.print("   ");
        graphNodes.forEach(x -> System.out.print(x.getName() + " "));
        System.out.println();

        for (Node k : graphNodes) {
            System.out.print(k.getName() + "| ");

            for (Node i : graphNodes) {
                System.out.print((hasEdge(k, i) ? "1" : "0") + " ");
            }

            System.out.println();
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
}
