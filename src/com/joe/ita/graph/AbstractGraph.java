package com.joe.ita.graph;

import java.util.List;

public abstract class AbstractGraph {

    protected int vertexNum = 0;

    protected int edgeNum = 0;

    /**
     * return vertex num of the graph.
     * 
     * @return
     */
    public int getVertexNum() {
        return vertexNum;
    }

    /**
     * Return edge num of the graph.
     * 
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    public abstract void addVertex(Vertex v);

    /**
     * Add one edge (v, w) into the graph.
     */
    public abstract void addEdge(Vertex v, Vertex w);

    /**
     * Add one edge e into the graph
     * 
     * @param e
     */
    public abstract void addEdge(AbstractEdge e);

    /**
     * Get all the vertices of this graph.
     * 
     * @return
     */
    public abstract Vertex[] getVertices();

    /**
     * Get adjancy vertices of vertex v.
     * 
     * @param v
     * @return
     */
    public abstract List<Vertex> getAdj(Vertex v);

}
