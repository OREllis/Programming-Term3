package com.uni.term3.programming.week2.exercises;

import com.uni.term3.programming.week2.examples.Graph;
import com.uni.term3.programming.week2.examples.Node;

public class Week2PartA {

    public static final Node rootNode = new Node(1, "0");

    public static Graph task1() {
        final Node node2 = new Node(2, "1");
        final Node node3 = new Node(3, "2");
        final Node node4 = new Node(4, "3");
        final Node node5 = new Node(5, "4");
        final Node node6 = new Node(6, "5");
        final Node node7 = new Node(7, "6");
        final Node node8 = new Node(8, "7");

        final Graph outgraph = new Graph(true);

        outgraph.addEdge(rootNode, node5);

        outgraph.addEdge(node2, node4);
        outgraph.addEdge(node2, node6);

        outgraph.addEdge(node3, rootNode);

        outgraph.addEdge(node4, node6);

        outgraph.addEdge(node5, node7);

        outgraph.addEdge(node6, node2);
        outgraph.addEdge(node6, node4);

        outgraph.addEdge(node7, node6);
        outgraph.addEdge(node7, node8);

        outgraph.addEdge(node8, node6);

        return outgraph;
    }

    public static void task2(final Graph inGraph) {
        inGraph.depthFirstSearch(rootNode);
    }


    public static void main(final String[] args) {
        final Graph testGraph = task1();
        task2(testGraph);
    }
}
