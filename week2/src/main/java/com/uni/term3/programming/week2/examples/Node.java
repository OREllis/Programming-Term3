package com.uni.term3.programming.week2.examples;

import lombok.Getter;

import java.util.Comparator;

@Getter
public class Node {
    private int n;
    private String name;
    private boolean visited;

    public Node(final int n, final String name) {
        this.n = n;
        this.name = name;
        this.visited = false;
    }

    public void visit() {
        this.visited = true;
    }

    public void unvisit() {
        this.visited = false;
    }

    public boolean isNorVisited() {
        return !this.isVisited();
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(final Node node1, final Node node2) {
            return node1.getN() - node2.getN();
        }
    }
}
