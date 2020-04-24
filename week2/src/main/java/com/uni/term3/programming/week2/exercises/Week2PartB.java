package com.uni.term3.programming.week2.exercises;

import com.uni.term3.programming.week2.examples.Graph;
import com.uni.term3.programming.week2.examples.Node;

public class Week2PartB {

    public static void main(final String[] args) {
        Graph graph = new Graph(true);

        Node node_1 = new Node(0, "0");
        Node node_2 = new Node(1, "1");
        Node node_3 = new Node(2, "2");
        Node node_4 = new Node(3, "3");
        Node node_5 = new Node(4, "4");
        Node node_6 = new Node(5, "5");
        Node node_7 = new Node(6, "6");
        Node node_8 = new Node(7, "7");

        //Mode 1 Edges
        graph.addEdge(node_1, node_3);
        graph.addEdge(node_1, node_4);
        graph.addEdge(node_1, node_5);

        //Mode 2 Edges
        graph.addEdge(node_2, node_1);
        graph.addEdge(node_2, node_3);
        graph.addEdge(node_2, node_4);
        graph.addEdge(node_2, node_6);

        //Mode 3 Edges
        graph.addEdge(node_3, node_6);
        graph.addEdge(node_3, node_7);

        //Mode 4 Edges
        graph.addEdge(node_4, node_2);
        graph.addEdge(node_4, node_8);

        //Mode 5 Edge
        graph.addEdge(node_5, node_3);

        //Mode 6 Edges
        graph.addEdge(node_6, node_2);
        graph.addEdge(node_6, node_8);

        //Mode 8 Edge
        graph.addEdge(node_8, node_7);

        graph.breadthFirstSearch(node_1);

    }
}
