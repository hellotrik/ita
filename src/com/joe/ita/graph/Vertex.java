package com.joe.ita.graph;

public class Vertex {

    private String flag = "Nil";

    public Vertex(String flag) {
        this.flag = flag;
    }

    
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o instanceof Vertex){
           Vertex that = (Vertex)o;
           return that.flag.equals(this.flag);
        }

        return false;
    }


    @Override
    public int hashCode() {
        return flag.hashCode();
    }


    @Override
    public String toString() {
        return flag;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("s");
        Vertex b = new Vertex("t");
        Vertex c = new Vertex("t");

        System.out.println(a == b);
        System.out.println(c == b);
        System.out.println(c.equals(b));
        
        System.out.println("b: hashcode:" + b.hashCode());
        System.out.println("c: hashcode:" + c.hashCode());
    }
}
