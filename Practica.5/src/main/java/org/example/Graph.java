package org.example;

import java.util.*;

public class Graph<V> {

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /******************************************************************
     * Añade el vértice `v` al grafo.
     *
     * @param v vértice a añadir.
     * @return `true` si no estaba anteriormente y ` false` en caso
     * contrario. NO SE REEMPLAZA
     ******************************************************************/

    public boolean addVertex(V v){
        if (containsVertex(v) || v == null)
            return false;

        Set<V> listaVacia = new HashSet<>();
        adjacencyList.put(v, listaVacia);
        return true;
    }

    /******************************************************************
     * Añade o reemplaza el vértice `v` al grafo.
     *
     * @param v vértice a añadir o a reemplazar.
     * @return `true` si no estaba anteriormente y ` false` en caso
     * contrario.
     ******************************************************************/

    public boolean addVertexV2(V v){
        Set<V> listaVacia = new HashSet<>();
        V anterior = (V) adjacencyList.put(v, listaVacia); // El método put devuelve el valor anterior que pisa, y si no hay nada devuelve null
        return anterior == null;
    }

    /******************************************************************
     * Añade un arco entre los vértices `v1` y `v2` al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     **
     @param v1 el origen del arco.
      * @param v2 el destino del arco.
     * @return ` true` si no existía el arco y ` false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2){
        if (!containsVertex(v1)){
            addVertex(v1);
            System.out.println("Vértice de origen creado");
        }

        if (!containsVertex(v2)){
            addVertex(v2);
            System.out.println("Vértice de destino creado");
        }

        boolean noExistia = adjacencyList.get(v1).add(v2); // Add nos retorna un true si no estaba presente en el set
        // No dirigido adjacencyList.get(v2).add(v1)
        return noExistia; // equivalente a: -> return adjacencyList.get(v1).add(v2)
    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a `v`.
     **
     @param v vértice del que se obtienen los adyacentes.
      * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception{
        if (!containsVertex(v))
            throw new Exception("El vértice indicado no está en el grafo");

        return adjacencyList.get(v);
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     **
     @param v vértice para el que se realiza la comprobación.
      * @return `true` si `v` es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }

    /******************************************************************
     * Mé todo `toString()` reescrito para la clase `Grafo. java`.
     * @return una cadena de caracteres con la lista de
     * adyacencia.
     ******************************************************************/
    @Override
    public String toString(){
        String text = "";
        for (V vertex: adjacencyList.keySet()) {
            text += vertex + " -> " + adjacencyList.get(vertex) + '\n';
        }
        return text;
    }

    /**
     * Obtiene, en caso de que exista, el camino más corto entre
     * `v1` y ` v2`. En caso contrario, devuelve ` null`.
     **
     @param v1 el vértice origen.
      * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto
     * entre ` v1` y ` v2`
     */

    public List<V> shortestPath(V v1, V v2){
        // Si alguno de los dos vértices no existe, terminamos con error
        if (!containsVertex(v1) || !containsVertex(v1)) {
            System.out.println("Error, al menos uno de los dos vértices no existe");
            return null; // Esto código hay que modificarlo.
        }

        // Iniciamos todas las distancias a infinito (no conectado) menos el vértice inicial.
        Map<V, Integer> distancias = new HashMap<>();
        for (V vertice: adjacencyList.keySet()){
            distancias.put(vertice, Integer.MAX_VALUE); // no podemos poner el valor infinito, pero ponemos el mayor posible
        }
        distancias.put(v1, 0);

        // Ponemos todos los vértices previos a nulo
        Map<V, V> previos = new HashMap<>();
        for (V vertice: adjacencyList.keySet()){
            previos.put(vertice, null); // Inicialmente no tenemos valores previos.
        }

        // Hacemos una cola de las comprobaciones de vértices según Dijkstra
        PriorityQueue<V> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        cola.add(v1); // Empezamos a recorrerlo desde v1

        while(!cola.isEmpty()){
            V actual = cola.poll();

            if (actual == v2){
                break; // En ppio si encontramos v2, ya tenemos el camino más corto
            }

            for (V adj: adjacencyList.get(actual)){
                int dist = distancias.get(actual) + 1;
                if (dist < distancias.get(adj)){
                    distancias.put(adj, dist);
                    previos.put(adj, actual);
                    cola.add(adj);
                }
            }
        }

        if(!previos.containsKey(v2)){
            return null;
        }

        // Rehacemos el camino en base a los previos.
        List<V> camino = new ArrayList<>();
        V actual = v2;

        while(actual != null){
            camino.add(actual);
            actual = previos.get(actual);
        }

        Collections.reverse(camino);

        return camino;
    }
}
