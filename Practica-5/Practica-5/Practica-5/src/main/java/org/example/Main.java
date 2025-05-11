package org.example;    

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        System.out.println("Lista de adyacencia:");
        System.out.println(g);

        List<Integer> path = g.shortestPath(1, 4);
        if (path != null) {
            System.out.println("Camino más corto de 1 a 4: " + path);
        } else {
            System.out.println("No hay camino entre 1 y 4");
        }
    }
}