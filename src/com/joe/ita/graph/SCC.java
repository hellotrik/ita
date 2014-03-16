package com.joe.ita.graph;

import java.util.Map;

public class SCC {

    public void stronglyConnectedComponents(Graph g) {
        // TopologicalSort ts = new TopologicalSort();
        // List<Vertex> tsList = ts.topologicalSort(g);
        // System.out.println(tsList);

        DFS dfs1 = new DFS();
        dfs1.depthFirstSearch(g);
        Map<Vertex, Integer> topoSortMap = dfs1.getFinshTime();

        Graph gT = ITAUtils.transpose(g);
        // System.out.println(gT + "\n" + "gT's vertices:" + gT.getVertexNum() +
        // ";gT's edges:" + gT.getEdgeNum());

        DFS dfs2 = new DFS();
        dfs2.depthFirstSearchByTopoSort(gT, topoSortMap);
        System.out.println(dfs2.getParent());
        System.out.println(dfs2.getStronglyConnectedComponents());
    }

    public static void main(String[] args) {
        SCC scc = new SCC();

        String vertices = "a, b, c, d, e, f, g, h";

        String edges = "a->b, b->c, c->d, d->c, e->a, "
                + "b->e, b->f, c->g, d->h, h->h," + "e->f, f->g, g->f, g->h";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println("vertex num:" + g.getVertexNum());
        System.out.println("edge num:" + g.getEdgeNum());
        scc.stronglyConnectedComponents(g);

    }

}
