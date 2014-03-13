package com.joe.ita.graph;

public abstract class AbstractEdge {

    private Vertex v = null;
    private Vertex w = null;

    public Vertex getOneVertex(){
        return v;
    }

    public Vertex getTheOtherVetex(Vertex vertex){
        if(vertex.equals(v)){
            return w;
        } else if(vertex.equals(w)){
            return v;
        } else {
            // illegal vertex.
            throw new IllegalArgumentException("This vertex doesn't belong to this edge.");
        }
    }

}
