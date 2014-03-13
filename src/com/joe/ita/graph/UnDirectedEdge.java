package com.joe.ita.graph;

public class UnDirectedEdge extends AbstractEdge{

    public UnDirectedEdge(Vertex s, Vertex e, int weight) {
        super.setV(s);
        super.setW(e);
        super.setWeight(weight);
    }

    public UnDirectedEdge(Vertex s, Vertex e) {
        super.setV(s);
        super.setW(e);
        super.setWeight(1);
    }

}
