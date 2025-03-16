// Ejercicio 27: Explicación de conceptos de pruebas de software


    Prueba de caja blanca: Evalúa el código fuente internamente, verificando 
    estructuras de control, lógica y flujo de datos.
    
    Prueba de caja negra: Evalúa el software sin conocer su código, probando 
    entradas y salidas según los requisitos funcionales.

    Prueba unitaria: Se prueban componentes individuales del software de forma aislada.
    
    Prueba de integración: Se verifica la interacción entre varios módulos del sistema.
    
    Prueba de sistema: Evalúa el sistema completo para verificar que cumple con 
    los requisitos especificados.
    
    Prueba de aceptación: Prueba realizada por el usuario final para validar que 
    el sistema cumple con sus necesidades.
    

// Ejercicio 28: Diseño de pruebas para los programas del ejercicio 2

import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasMatematicas {

    @Test
    public void testSumaNaturales() {
        assertEquals(10, Matematicas.sumaNumeros(4)); // 0+1+2+3+4 = 10
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Matematicas.factorial(5)); // 5! = 120
    }

    @Test
    public void testPotencia() {
        assertEquals(8, Matematicas.potencia(2, 3)); // 2^3 = 8
    }

    @Test(expected = ArithmeticException.class)
    public void testSumaNumerosNegativo() {
        Matematicas.sumaNumeros(-5); // Debería lanzar una excepción
    }
}

// Ejercicio 29: Implementación de pruebas unitarias con JUnit

import org.junit.Test;
import static org.junit.Assert.*;

public class MatematicasTest {

    @Test
    public void testSumaCero() {
        assertEquals(0, Matematicas.sumaNumeros(0));
    }

    @Test
    public void testSumaPositiva() {
        assertEquals(6, Matematicas.sumaNumeros(3)); // 0+1+2+3 = 6
    }

    @Test(expected = ArithmeticException.class)
    public void testSumaNegativa() {
        Matematicas.sumaNumeros(-1);
    }
}

// Ejercicio 30: Implementación de pruebas unitarias para más funciones

import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasExtra {

    @Test
    public void testSumaLista() {
        int[] lista = {1, 2, 3, 4};
        assertEquals(10, Matematicas.sumaLista(lista));
    }

    @Test
    public void testMediaAritmetica() {
        double[] lista = {2.0, 4.0, 6.0, 8.0};
        assertEquals(5.0, Matematicas.mediaAritmetica(lista), 0.001);
    }

    @Test
    public void testFibonacci() {
        assertEquals(13, Matematicas.fibonacci(7)); // F(7) = 13
    }
}


