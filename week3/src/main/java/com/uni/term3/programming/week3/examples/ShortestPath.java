package com.uni.term3.programming.week3.examples;

import java.util.Arrays;

public class ShortestPath {

    public static final int NODES = 8;

    public int minDistance(int[] dist, boolean[] shortestPathTreeSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int n = 0; n < NODES; n++) {
            if (!shortestPathTreeSet[n] && dist[n] <= min) {
                min = dist[n];
                minIndex = n;
            }
        }

        return minIndex;
    }

    public void printSolution(int[] dist, int n) {
        System.out.println("Vertex distance from source:");

        for (int i = 0; i < NODES; i++) {
            System.out.println(i + " - " + dist[i]);
        }
    }

    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[NODES];

        boolean[] shortestPathTreeSet = new boolean[NODES];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(shortestPathTreeSet, false);

        dist[src] = 0;
        for (int count = 0; count < NODES; count++) {
            int u = minDistance(dist, shortestPathTreeSet);

            shortestPathTreeSet[u] = true;

            for (int v = 0; v < NODES; v++) {
                if(!shortestPathTreeSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, NODES);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0},
        };

        ShortestPath shortestPath = new ShortestPath();
        shortestPath.dijkstra(graph, 0);
    }
}
