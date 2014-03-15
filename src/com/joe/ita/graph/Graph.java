package com.joe.ita.graph;

import java.util.List;

public abstract class Graph extends AbstractGraph {

    protected Bag[] adj;

    private int index = 0;

    public Graph(int vertexNum) {
        if (vertexNum <= 0) {
            throw new IllegalArgumentException(
                    "The number of vertex should be positive!");
        }

        adj = new Bag[vertexNum];
        this.vertexNum = vertexNum;
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new Bag();
        }
    }

    @Override
    public void addVertex(Vertex v) {
        if (isExist(v)) {
            return;
        }

        if (index < 0 || index >= this.vertexNum) {
            return;
        }

        Bag currentBag = adj[index++];
        currentBag.setHead(v);
    }

    private boolean isExist(Vertex v) {
        int index = findIndexInAdj(v);
        return index != -1;
    }

    protected int findIndexInAdj(Vertex v) {

        for (int i = 0; i < adj.length; i++) {
            Bag bag = adj[i];
            if (bag.isEmpty()) {
                continue;
            }
            Vertex headV = bag.getHead().getValue();
            if (headV.equals(v)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Bag bag : adj) {
            sb.append(bag);
            sb.append(ITAUtils.lineSeparator);
        }

        return sb.substring(0, sb.lastIndexOf(ITAUtils.lineSeparator));
    }
    
    @Override
    public Vertex[] getVertices() {
        Vertex[] vertices = new Vertex[adj.length];
        for (int i = 0; i < adj.length; i++) {
            vertices[i] = adj[i].getHead().getValue();
        }
        return vertices;
    }

    @Override
    public List<Vertex> getAdj(Vertex v) {
        int index = findIndexInAdj(v);
        Bag bag = adj[index];

        return bag.getAdjVertices();
    }

}
