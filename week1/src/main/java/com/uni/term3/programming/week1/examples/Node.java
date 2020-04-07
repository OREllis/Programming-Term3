package com.uni.term3.programming.week1.examples;


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
}
