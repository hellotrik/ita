package com.joe.ita.graph;

public class SCC {

    public static void main(String[] args) {
        String vertices = "a, b, c, d, e, f, g, h";

        String edges = "a->b, b->c, c->d, d->c, e->a, "
                + "b->e, b->f, c->g, d->h, h->h,"
                + "e->f, f->g, g->f, g->h";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println("vertex num:" + g.getVertexNum());
        System.out.println("edge num:" + g.getEdgeNum());
        
        
        
    }

}
