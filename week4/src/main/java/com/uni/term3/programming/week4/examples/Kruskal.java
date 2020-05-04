package com.uni.term3.programming.week4.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public static class Graph {
        private int vertices;
        List<Edge> allEdges = new ArrayList<>();

        Graph(final int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(final int source, final int dest, final int weight) {
            allEdges.add(new Edge(source, dest, weight));
        }

        public void kruskalMST() {
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(Edge::getWeight));

            for (Edge edge : allEdges) {
                priorityQueue.add(edge);
                int[] parent = new int[vertices];

                makeSet(parent);

                List<Edge> mstSet = new ArrayList<>();

                for (int index = 0; index < vertices - 1;) {
                    Edge queueEdge = priorityQueue.remove();
                    int xSet = find(parent, queueEdge.getSource());
                    int ySet = find(parent, queueEdge.getDest());

                    if (xSet != ySet) {
                        mstSet.add(queueEdge);
                        index++;
                        union(parent, xSet, ySet);
                    }
                }

                System.out.println("Minimum Spanning Tree:");
                printGraph(mstSet);
            }
        }

        private void printGraph(final List<Edge> mstSet) {
            for (int i = 0; i < mstSet.size(); i++) {
               Edge edge = mstSet.get(i);
                System.out.println("Edge- " + i + " " + edge.toString());
            }
        }

        private void union(int[] parent, final int xSet, final int ySet) {
            int xSetParent = find(parent, xSet);
            int ySetParent = find(parent, ySet);

            parent[ySetParent] = xSetParent;
        }

        private int find(int[] parent, int source) {
            if(parent[source] != source) {
                return find(parent, parent[source]);
            }

            return source;
        }

        private void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
               parent[i] = i;
            }
        }
    }
}
