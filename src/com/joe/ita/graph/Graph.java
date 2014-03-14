package com.joe.ita.graph;


public class Graph extends AbstractGraph {

    private Bag[] adj;

    private int index = 0;

    public Graph(int vertexNum) {
        if (vertexNum <= 0) {
            throw new IllegalArgumentException(
                    "The number of vertex should be positive!");
        }

        this.vertexNum = vertexNum;
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new Bag();
        }
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {

        if (v == null || w == null) {
            throw new IllegalArgumentException("illegal vertex!");
        }

        // find bags of v and w
        int vIndex = findIndexInAdj(v);
        int wIndex = findIndexInAdj(w);
        // insert w into v's bag
        adj[vIndex].addNode(w);
        // insert v into w's bag
        adj[wIndex].addNode(v);
        //
        edgeNum++;
    }

    @Override
    public void addVertex(Vertex v) {
        if (isExist(v)) {
            return;
        }

        if (index < 0 || index >= this.vertexNum - 1) {
            return;
        }

        Bag currentBag = adj[index];
        currentBag.setHead(v);
    }

    private boolean isExist(Vertex v) {
        int index = findIndexInAdj(v);
        return index != -1;
    }

    private int findIndexInAdj(Vertex v) {

        for (int i = 0; i < adj.length; i++) {
            Bag bag = adj[i];
            Vertex headV = bag.getHead().getValue();
            if (headV.equals(v)) {
                return i;
            }
        }

        return -1;
    }

}
