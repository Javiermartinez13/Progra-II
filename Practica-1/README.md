# Proyecto: Aproximación del Número Pi

## Descripción
Este proyecto en Java implementa un método para aproximar el valor del número Pi (π) utilizando el método de Montecarlo. El código consta de dos archivos principales:

- **`matematicas.java`**: Contiene la lógica para la generación de Pi usando el método de Montecarlo.
- **`aplicacion.java`**: Es el punto de entrada del programa y llama a la función de `matematicas.java` para obtener la aproximación de Pi.

## Funcionamiento
El programa utiliza el método de Montecarlo para estimar el valor de Pi. El método consiste en generar puntos aleatorios dentro de un cuadrado unitario y contar cuántos de esos puntos caen dentro de un círculo inscrito dentro del cuadrado. La relación entre estos dos valores permite aproximar Pi con la fórmula:

```
π ≈ 4 × (puntos dentro del círculo / puntos totales generados)
```

### Archivo `matematicas.java`
Este archivo define la clase `matematicas`, que contiene el método:

- `generarNumeroPi(long pasos)`: Genera una aproximación del número Pi usando el método de Montecarlo. Acepta un parámetro `pasos`, que indica la cantidad de puntos aleatorios a generar. Mientras mayor sea el número de pasos, más precisa será la aproximación.

El método principal (`main`) en `matematicas.java` permite probar directamente la generación de Pi sin necesidad de usar `aplicacion.java`.

### Archivo `aplicacion.java`
Este archivo contiene la clase `aplicacion` con un método `main`, que es el punto de entrada del programa. Su función es recibir un valor como argumento (el número de pasos a utilizar) y llamar al método `generarNumeroPi()` de la clase `matematicas`. Luego, muestra el resultado en la consola.

## Ejecución
### Compilar los archivos
```
javac matematicas.java aplicacion.java
```

### Ejecutar el programa
```
java aplicacion 1000000
```
Donde `1000000` es la cantidad de puntos aleatorios generados para calcular Pi. Puedes cambiar este valor según el nivel de precisión deseado.

## Notas
- Un mayor número de pasos proporciona una mejor aproximación de Pi, pero aumenta el tiempo de ejecución.
- Este es un método probabilístico, por lo que el resultado puede variar ligeramente en cada ejecución.

## Autor
Proyecto desarrollado como demostración del uso del método de Montecarlo en Java.


