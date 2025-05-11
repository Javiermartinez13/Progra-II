import org.example.Graph;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

public class testObtainAdjacents {
    Graph<Integer> g;

    @BeforeMethod
    public void setUp(Method m){
        System.out.println("\nTest de Add Edge para " + m.getName() + " empezando");
        System.out.println("----------------------------");

        g = new Graph<>();
        /*g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(5,6);*/
    }

    @Test
    public void listaAdjGrafoVacio(){
        Map<Integer, Set<Integer>> expectedAdjMap = new HashMap<>();
        Map<Integer, Set<Integer>> realAdjMap  = g.obtainAdjacents(null);
        assertEquals(expectedAdjMap, realAdjMap);
    }

    @Test
    public void listaAdjGrafoVacio(){
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(5,6);
        Set<Integer> expectedAdj = new HashSet<>(Arrays.asList(3, 2));
        Set<Integer> realAdj = g.obtainAdjacents(1);
        assertEquals(expectedAdj, realAdj);
    }
}
