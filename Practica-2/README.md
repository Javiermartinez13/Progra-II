# Practica-2
# Proyecto: Cálculo de PI mediante Métodos Iterativo y Recursivo

## Descripción
Este proyecto en Java permite calcular una aproximación del número **PI** utilizando el método de Monte Carlo. Se proporcionan dos implementaciones diferentes:
1. **Método Iterativo**
2. **Método Recursivo**

El programa ejecuta el método recursivo desde la clase principal `main.java`, pidiendo al usuario el número de puntos a utilizar en la simulación.

## Estructura del Proyecto
El proyecto está dividido en dos paquetes:
- **`mates`**: Contiene la clase `Matematicas.java`, donde se implementan los métodos para calcular PI.
- **`aplicacion`**: Contiene la clase `main.java`, encargada de la ejecución del programa y la interacción con el usuario.

## Archivos Principales

### `Matematicas.java`
Ubicado en el paquete `mates`, contiene:
- `calcularPiIterativo(int pasos)`: Implementación iterativa para calcular PI.
- `calcularPiRecursivo(long pasos)`: Implementación recursiva.
- `calcularPiRecursivoAux(long pasos, long actual, long puntosEnCirculo)`: Método auxiliar para la recursión.

### `main.java`
Ubicado en el paquete `aplicacion`, contiene:
- `main(String[] args)`: Solicita al usuario el número de puntos y llama al método `calcularPiRecursivo`.

## Instrucciones de Ejecución
1. **Abrir el proyecto en Visual Studio Code**
2. **Compilar las clases:**
   ```sh
   javac -d . Matematicas.java main.java
   ```
3. **Ejecutar el programa:**
   ```sh
   java aplicacion.main
   ```
4. **Ingresar el número de puntos** que se usará para la simulación cuando el programa lo solicite.

## Ejemplo de Uso
```
Introduce la cantidad de puntos que desees:
1000000
Aproximación de PI: 3.141592
```

## Diagrama UML
Se incluirá un diagrama UML que representa la estructura del código, mostrando la relación entre `Matematicas.java` y `main.java`.



