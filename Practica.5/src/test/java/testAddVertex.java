import org.example.Graph;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.assertEquals;

public class testAddVertex {

    Graph<Integer> g;

    @BeforeMethod
    public void setUp(Method m){
        System.out.println("\nTest " + m.getName() + " empezando");
        System.out.println("----------------------------");

        g = new Graph<>();
    }

    @AfterMethod
    public void finish(Method m){
        System.out.println("\nTest " + m.getName() + " terminado");
    }

    @Test
    public void agregarVerticeVacio(){
        // We build the graph
        boolean res = g.addVertex(null);
        assertEquals(false, res); // Por diseño considero false el que no agrege nada (no hacer nada se parece a false)
    }

    @Test
    public void agregarMismoVerticeDosVeces(){
        g.addVertex(1);
        boolean res = g.addVertex(1);
        assertEquals(false, res); // Da false por existir anteriormente
    }

    @Test
    public void agregarVerticeNormal(){
        boolean res = g.addVertex(1);
        assertEquals(true, res); // True por no haber un vértice igual a este anteriormente
    }

    // TODO hacer test para data mismatch:  agergar un entero con una string o con un floatdouble
}
