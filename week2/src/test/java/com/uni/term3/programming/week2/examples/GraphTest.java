package com.uni.term3.programming.week2.examples;

import org.junit.Test;

public class GraphTest {

    private final Node a = new Node(0, "0");
    private final Node b = new Node(1, "1");
    private final Node c = new Node(2, "2");
    private final Node d = new Node(3, "3");
    private final Node e = new Node(4, "4");

    @Test
    public void testDepthFirstSearch() {
        final Graph testGraph = makeGraph();

        testGraph.printEdgres();
        testGraph.depthFirstSearch(b);
    }

    @Test
    public void testDepthFirstSearchNullGraph() {
        final Graph nullGraph = new Graph(false);
        nullGraph.printEdgres();
        nullGraph.depthFirstSearch(b);
    }

    private Graph makeGraph() {
        final Graph graph = new Graph(false);

        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(c, b);
        graph.addEdge(e, d);

        return graph;
    }
}
