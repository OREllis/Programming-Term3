package com.uni.term3.programming.week4.examples;

import java.util.Arrays;

public class MSTPRims {
    private final int totalNodes;

    MSTPRims(final int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int currentNode = 0; currentNode < totalNodes; currentNode++) {
            if(!mstSet[currentNode] && key[currentNode] < min) {
                min = key[currentNode];
                minIndex = currentNode;
            }
        }

        return minIndex;
    }

    public void printMST(int[] parent, int[][] graph){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < totalNodes; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public void primMST(int[][] graph) {
        int[] parent = new int[totalNodes];
        int[] key = new int[totalNodes];
        boolean[] mstSet = new boolean[totalNodes];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < totalNodes - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < totalNodes; v++) {
                if(graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        MSTPRims t =  new MSTPRims(5);

        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        t.primMST(graph);
    }
}
