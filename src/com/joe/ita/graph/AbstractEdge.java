package com.joe.ita.graph;

public abstract class AbstractEdge {

    private Vertex v = null;
    private Vertex w = null;

    private int weight = 0;

    public Vertex getV() {
        return v;
    }

    public void setV(Vertex v) {
        this.v = v;
    }

    public Vertex getW() {
        return w;
    }

    public void setW(Vertex w) {
        this.w = w;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

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
