package com.joe.ita.graph;

public class DirectedEdge extends AbstractEdge{

    public DirectedEdge(Vertex s, Vertex e, int weight) {
        super.setV(s);
        super.setW(e);
        super.setWeight(weight);
    }

    public DirectedEdge(Vertex s, Vertex e) {
        super.setV(s);
        super.setW(e);
        super.setWeight(1);
    }

    public Vertex getStartVertex(){
        return getV();
    }

    public Vertex getEndVertex(){
        return getW();
    }


}
