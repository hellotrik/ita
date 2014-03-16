package com.joe.ita.graph;

import java.util.Map;

/**
 * Strongly Connected Components of the connected graph.
 * @author Joe
 *
 */
public class SCC {

    public void stronglyConnectedComponents(Graph g) {
        // first dfs 
        DFS dfs1 = new DFS();
        dfs1.depthFirstSearch(g);
        Map<Vertex, Integer> topoSortMap = dfs1.getFinshTime();
 
        // compute the transpose of graph.
        Graph gT = ITAUtils.transpose(g);

        // second dfs
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
