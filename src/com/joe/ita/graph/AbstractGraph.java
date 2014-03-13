package com.joe.ita.graph;

public abstract class AbstractGraph {

    private final int vertexNum = 0;

    private int edgeNum = 0;

    /**
     * return vertex num of the graph.
     * @return
     */
    public int getVertexNum() {
        return vertexNum;
    }

    /**
     *  Return edge num of the graph.
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * Add one edge into the graph.
     */
    public abstract void addEdge(Vertex v, Vertex w);

}