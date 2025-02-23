package mates;

import java.util.Random;

/**
 * Clase que proporciona métodos para aproximar el número pi utilizando el método de Monte Carlo.
 */
public class Matematicas {

    /**
     * Aproxima el valor de pi utilizando un método iterativo basado en el principio de Monte Carlo.
     * Se generan puntos aleatorios dentro de un cuadrado de lado 1, y se determina cuántos caen dentro del círculo de radio 1.
     *
     * @param numSamples Número de muestras a generar.
     * @return Aproximación del valor de pi.
     */
    public static double calcularPiIterativo(int numSamples) {
        Random random = new Random();
        int insideCircleCount = generateSamples(numSamples, random);
        return 4.0 * insideCircleCount / numSamples;
    }

    /**
     * Aproxima el valor de pi utilizando un método recursivo basado en el principio de Monte Carlo.
     *
     * @param numSamples Número de muestras a generar.
     * @return Aproximación del valor de pi.
     */
    public static double calcularPiRecursivo(long numSamples) {
        return calcularPiRecursivoAux(numSamples, 0, 0);
    }

    /**
     * Método auxiliar recursivo para calcular una aproximación de pi.
     *
     * @param numSamples       Número total de muestras.
     * @param currentSample    Muestra actual en el proceso recursivo.
     * @param insideCircleCount Contador de puntos que han caído dentro del círculo.
     * @return Aproximación del valor de pi.
     */
    private static double calcularPiRecursivoAux(long numSamples, long currentSample, long insideCircleCount) {
        if (currentSample >= numSamples) {
            return 4.0 * insideCircleCount / numSamples;
        }
        Random random = new Random();
        double x = random.nextDouble();
        double y = random.nextDouble();
        if (x * x + y * y <= 1) {
            insideCircleCount++;
        }
        return calcularPiRecursivoAux(numSamples, currentSample + 1, insideCircleCount);
    }

    /**
     * Genera muestras aleatorias y cuenta cuántas de ellas están dentro del círculo unitario.
     *
     * @param numSamples Número de muestras a generar.
     * @param random     Generador de números aleatorios.
     * @return Cantidad de muestras dentro del círculo.
     */
    private static int generateSamples(int numSamples, Random random) {
        int count = 0;
        for (int i = 0; i < numSamples; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                count++;
            }
        }
        return count;
    }
}
