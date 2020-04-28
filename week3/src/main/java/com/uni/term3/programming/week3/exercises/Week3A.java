package com.uni.term3.programming.week3.exercises;

import com.uni.term3.programming.week3.examples.Graph;
import com.uni.term3.programming.week3.examples.Node;

public class Week3A {

    public static void main(String[] args) {

        final Node node0 = new Node(0, "0");
        final Node node1 = new Node(1, "1");
        final Node node2 = new Node(2, "2");
        final Node node3 = new Node(3, "3");
        final Node node4 = new Node(4, "4");
        final Node node5 = new Node(5, "5");
        final Node node6 = new Node(6, "6");
        final Node node7 = new Node(7, "7");
        final Node node8 = new Node(8, "8");
        final Node node9 = new Node(9, "9");
        final Node node10 = new Node(10, "10");

        final Graph outgraph = new Graph(true);

        //Node 0 Edges
        outgraph.addEdge(node0, node2);
        outgraph.addEdge(node0, node4);
        outgraph.addEdge(node0, node7);

        //Node 1 Edge
        outgraph.addEdge(node1, node2);

        //Node 2 Edge
        outgraph.addEdge(node2, node5);

        //Node 3 Edge
        outgraph.addEdge(node3, node6);
        outgraph.addEdge(node3, node10);

        //Node 4 Edge
        outgraph.addEdge(node4, node5);

        //Node 5 Edges
        outgraph.addEdge(node5, node8);
        outgraph.addEdge(node5, node9);

        //Node 8 Edge
        outgraph.addEdge(node8, node9);

        //Node 9 Edge
        outgraph.addEdge(node9, node10);

        outgraph.printTopologicalSort();
    }
}
