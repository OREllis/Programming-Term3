package com.uni.term3.programming.week3.examples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalGraph {

    private final int nodeCount;
    private final LinkedList<Integer>[] adjacency;

    public TopologicalGraph(final int nodeCount) {
        this.nodeCount = nodeCount;
        this.adjacency = new LinkedList[nodeCount];
        Arrays.fill(adjacency, new LinkedList<>());
    }

    public void addEdge(final int v, final int w) {
        adjacency[v].add(w);
    }

    public void topologicalUtil(final int v, boolean[] visited, final Stack<Integer> stack) {
        visited[v] = true;

        for (Integer integer : adjacency[v]) {
            if (!visited[integer]) {
                topologicalUtil(integer, visited, stack);
            }
        }

        stack.push(v);
    }

    public void topologicalSort() {
        final Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodeCount];
        Arrays.fill(visited, false);

        for (int i = 0; i < nodeCount; i++) {
            if(!visited[i]) {
                topologicalUtil(i, visited, stack);
            }
        }

        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalGraph graph =  new TopologicalGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);

        graph.topologicalSort();
    }
}
