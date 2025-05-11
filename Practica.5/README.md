# Práctica 5 - Implementación de un Grafo Genérico en Java

Este proyecto implementa una estructura de datos de tipo **grafo dirigido y genérico** en Java. Permite:

- Añadir vértices.
- Añadir aristas (creando vértices si no existen).
- Obtener los adyacentes de un vértice.
- Verificar si un vértice existe.
- Calcular el **camino más corto** entre dos vértices usando una versión adaptada del algoritmo de Dijkstra (para grafos no ponderados).

## 📁 Clase Principal

```java
public class Graph<V>

Graph<String> grafo = new Graph<>();

grafo.addEdge("A", "B");
grafo.addEdge("B", "C");
grafo.addEdge("A", "D");

System.out.println(grafo);

List<String> camino = grafo.shortestPath("A", "C");
System.out.println("Camino más corto: " + camino);

