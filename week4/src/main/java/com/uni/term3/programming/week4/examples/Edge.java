package com.uni.term3.programming.week4.examples;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private int source;
    private int dest;
    private int weight;

    @Override
    public String toString() {
        return "Source: " + this.source +
                " Destination: " + this.dest + " Weight: " + this.weight;
    }
}
