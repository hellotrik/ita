package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedEdge extends Edge{

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

    public static void main(String[] args) {
        List<Vertex> list = new ArrayList<Vertex>();
        
        Vertex a = new Vertex("good");
        list.add(a);
        
        Vertex b = new Vertex("good");
        System.out.println(list.contains(b));
        
        Map<Vertex, Integer> map = new HashMap<Vertex, Integer>();
        
        map.put(a, 10);
        System.out.println(map.get(a));
        System.out.println(map.get(b));
    }

}
