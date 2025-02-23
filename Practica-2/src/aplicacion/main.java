package aplicacion;

import mates.Matematicas;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el programa para calcular una aproximación de pi
 * utilizando el método de Monte Carlo con un enfoque recursivo.
 */
public class main {

    /**
     * Método principal que solicita al usuario la cantidad de muestras a generar
     * y calcula una aproximación del valor de pi utilizando la clase {@code Matematicas}.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la cantidad de muestras a generar: ");

        long numSamples = scanner.nextInt();

        double piApproximation = Matematicas.calcularPiRecursivo(numSamples);
        System.out.println("Aproximación de pi: " + piApproximation);

        scanner.close();
    }
}
