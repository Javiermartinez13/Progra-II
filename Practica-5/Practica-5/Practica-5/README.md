# Calculadora de Distancias

Este código implementa una calculadora de distancia de edición, también conocida como distancia de Levenshtein, que calcula la cantidad mínima de operaciones requeridas para transformar una cadena de caracteres en otra.

## Descripción del Código

El código está escrito en Java y consta de una clase `CalculadoraDistancias`. Aquí hay un resumen de las partes clave del código:

- `public static int calcularDistancia(String s1, String s2)`: Método estático que calcula la distancia de edición entre dos cadenas de caracteres `s1` y `s2` utilizando el algoritmo de distancia de Levenshtein.

- `public static void main(String[] args)`: Método principal que demuestra cómo usar la función `calcularDistancia`. Calcula la distancia de edición entre dos palabras de ejemplo y muestra el resultado en la consola.

## Uso

Para usar este código, simplemente ejecútalo en un entorno de desarrollo Java. Puedes modificar las palabras de ejemplo en el método `main` para calcular la distancia de edición entre otras palabras.

## Ejemplo de Uso

```java
String palabra1 = "kitten";
String palabra2 = "sitting";
int distancia = calcularDistancia(palabra1, palabra2);
System.out.println("La distancia de edición entre \"" + palabra1 + "\" y \"" + palabra2 + "\" es: " + distancia);
