package com.joe.ita.graph;

public class Edge implements Comparable<Edge> {

    private Vertex v = null;
    private Vertex w = null;

    private int weight = 0;

    public Edge() {
        ;
    }

    public Edge(Vertex v, Vertex w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Vertex v, Vertex w) {
        this.v = v;
        this.w = w;
    }

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getOneVertex() {
        return v;
    }

    public Vertex getTheOtherVetex(Vertex vertex) {
        if (vertex.equals(v)) {
            return w;
        } else if (vertex.equals(w)) {
            return v;
        } else {
            // illegal vertex.
            throw new IllegalArgumentException(
                    "This vertex doesn't belong to this edge.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge)) {
            return false;
        }
        Edge e = (Edge) obj;
        return e.getV().equals(this.getV()) && e.getW().equals(this.getW());
    }

    @Override
    public int compareTo(Edge that) {
        int x = this.getWeight();
        int y = that.getWeight();
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(v).append(",").append(w).append(")").append("." + weight + ".");
        return sb.toString();
    }

}
