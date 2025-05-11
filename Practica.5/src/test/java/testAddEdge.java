import org.example.Graph;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.assertEquals;

public class testAddEdge {

    Graph<Integer> g;

    @BeforeMethod
    public void setUp(Method m){
        System.out.println("\nTest de Add Edge para " + m.getName() + " empezando");
        System.out.println("----------------------------");

        g = new Graph<>();
    }

    @Test
    public void agregarEdgeEntreDosVerticesNoExistentes(){
        boolean res = g.addEdge(1,3);
        assertEquals(true, res);
    }

    @Test
    public void agregarEdgeEntreUnVerticesNoExistente(){
        g.addVertex(1);
        boolean res = g.addEdge(1,3);
        assertEquals(true, res);
    }

    @Test
    public void agregarEdgeYaExistente(){
        g.addEdge(1,3);
        boolean res = g.addEdge(1,3);
        assertEquals(false, res);
    }

    @Test
    public void agregarEdgeNormal(){
        g.addVertex(1);
        g.addVertex(3);
        boolean res = g.addEdge(1,3);
        assertEquals(true, res);
    }
}
