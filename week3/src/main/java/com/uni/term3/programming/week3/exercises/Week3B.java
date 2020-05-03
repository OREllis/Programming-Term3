package com.uni.term3.programming.week3.exercises;

import com.uni.term3.programming.week3.examples.ShortestPath;

public class Week3B {

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 6, 0, 9, 0, 0, 0, 0},
                {7, 0, 1, 0, 0, 0, 5, 0},
                {0, 0, 0, 0, 0, 8, 0, 0},
                {0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 6},
                {0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 0, 7},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        ShortestPath dijkstra = new ShortestPath();

        dijkstra.dijkstra(graph, 0);
    }
}
