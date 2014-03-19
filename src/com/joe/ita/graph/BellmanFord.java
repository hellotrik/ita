package com.joe.ita.graph;

public class BellmanFord extends SingleSourceShortestPaths {

    private boolean ssst(Graph g, Vertex s) {
        initSingleSource(g, s);
        for (int i = 1; i < g.getVertices().length; i++) {
            for (Edge e : g.getAllEdges()) {
                relax(e.getV(), e.getW(), e.getWeight());
            }
        }

        for (Edge e : g.getAllEdges()) {
            Vertex v = e.getV();
            Vertex w = e.getW();
            if (distanceMap.get(w) > distanceMap.get(v) + e.getWeight()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String vertices = "s, t, x, y, z";

        String edges = "s->t_6, t->x_5, x->t_-2, s->y_7, y->z_9, z->s_2, "
                + "t->y_8, t->z_-4, y->x_-3, z->x_7";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println(g);
        System.out.println("edge num:" + g.getEdgeNum());
        System.out.println("vertex num:" + g.getVertexNum());

        BellmanFord bf = new BellmanFord();
        Vertex s = new Vertex("s");
        System.out.println(bf.ssst(g, s));
        System.out.println(bf.distanceMap);
        System.out.println(bf.parentMap);
    }

}
