package com.uni.term3.programming.week2.examples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GraphClosure {

    private final int nodes;

    public void transitiveClosure(final int graph[][]) {
        if (nodes == 0) {
            return;
        }
        int reach[][] = new int[nodes][nodes];
        int i, j, k;

        for (i = 0; i < nodes; i++) {
            for (j = 0; j < nodes; j++) {
                reach[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < nodes; k++) {
            for (i = 0; i < nodes; i++) {
                for (j = 0; j < nodes; j++) {
                    reach[i][j] = (reach[i][j] != 0 || (reach[i][k] != 0 && reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }

        printSolution(reach);
    }

    private void printSolution(int[][] reach) {
        System.out.println("The following solution is a transative closure of the given graph");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        GraphClosure g = new GraphClosure(graph.length);
        g.transitiveClosure(graph);
    }
}