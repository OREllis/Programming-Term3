package com.uni.term3.programming.week2.exercises;


import com.uni.term3.programming.week2.examples.GraphClosure;

public class Week2PartC {

    public static void main(String[] args) {
        //Look at the Graph class in the examples package for my attempt at implementing the transitive closure,
        // best I could get was for it to print the adjacency matrix
        final int[][] graph = new int[][] {
                { 0,0,1,0,0,1,0,0,0 },
                { 0,0,0,0,0,0,1,0,0 },
                { 0,0,0,0,0,0,1,0,0 },
                { 0,0,0,0,1,0,0,0,0 },
                { 0,0,0,0,0,1,0,0,0 },
                { 0,0,0,1,0,0,0,1,0 },
                { 0,0,0,0,0,0,0,0,0 },
                { 0,0,1,0,0,0,0,0,1 },
                { 0,0,0,0,0,0,0,0,0 }
        };

        GraphClosure util = new GraphClosure(graph.length);

        util.transitiveClosure(graph);
    }
}
