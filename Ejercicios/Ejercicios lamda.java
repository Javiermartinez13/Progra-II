#12
//Una expresión lambda es una forma concisa de escribir funciones anónimas en Java. 
//Se usa principalmente para implementar interfaces funcionales de manera más clara y compacta

#13
import java.util.function.Function;

public class Integracion {
    public static double integral(double a, double b, double h, Function<Double, Double> funcion) {
        double suma = 0.0;
        for (double x = a; x <= b; x += h) {
            suma += funcion.apply(x) * h;
        }
        return suma;
    }
}

#14
import java.util.Random;
import java.util.stream.IntStream;

public class StreamsEjemplo {
    public static void main(String[] args) {
        // 1. Stream de números con "of"
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        // 2. Stream de números en un rango
        IntStream.range(1, 6).forEach(System.out::println);

        // 3. Stream infinito con "iterate"
        IntStream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);

        // 4. Stream de números aleatorios
        new Random().doubles(5).forEach(System.out::println);
    }
}
#15
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FuncionesLambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // 1. Suma de números naturales hasta n
        int suma = IntStream.rangeClosed(1, 5).sum();
        System.out.println("Suma de 1 a 5: " + suma);

        // 2. Factorial de un número
        int factorial = IntStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * b);
        System.out.println("Factorial de 5: " + factorial);

        // 3. Potencia n-ésima de un número
        Function<Integer, Integer> cuadrado = n -> n * n;
        System.out.println("Cuadrado de 4: " + cuadrado.apply(4));

        // 4. Suma de una lista
        int sumaLista = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Suma de la lista: " + sumaLista);

        // 5. Media aritmética
       // double media = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);
        //System.out.println("Media: " + media);

        // 6. Números pares en la lista
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Pares: " + pares);
    }
}

#16
import java.util.function.Function;
import java.util.stream.DoubleStream;

public class IntegralConStreams {
    public static double integral(double a, double b, double h, Function<Double, Double> funcion) {
        return DoubleStream.iterate(a, x -> x + h)
                .limit((long) ((b - a) / h) + 1)
                .map(funcion::apply)
                .sum() * h;
    }
}
#17
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Persona {
    private String nombre;
    private LocalDate fechaDeNacimiento;

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public long calcularEdad() {
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}

class Personas {
    private List<Persona> lista = new ArrayList<>();

    public void annadirPersona(Persona persona) {
        lista.add(persona);
    }

    public Persona elMasJoven() {
        return lista.stream().min(Comparator.comparing(Persona::calcularEdad)).orElse(null);
    }

    public long calcularSumaEdades() {
        return lista.stream().mapToLong(Persona::calcularEdad).sum();
    }

    public long calcularEdadMinima() {
        return lista.stream().mapToLong(Persona::calcularEdad).min().orElse(0);
    }

    public double calcularMediaDeEdad() {
        return lista.stream().mapToLong(Persona::calcularEdad).average().orElse(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Personas personas = new Personas();
        personas.annadirPersona(new Persona("Juan", LocalDate.of(2000, 5, 15)));
        personas.annadirPersona(new Persona("María", LocalDate.of(1995, 10, 22)));
        personas.annadirPersona(new Persona("Pedro", LocalDate.of(2010, 3, 8)));

        System.out.println("Persona más joven: " + personas.elMasJoven().getNombre());
        System.out.println("Suma de edades: " + personas.calcularSumaEdades());
        System.out.println("Edad mínima: " + personas.calcularEdadMinima());
        System.out.println("Media de edad: " + personas.calcularMediaDeEdad());
    }
}
