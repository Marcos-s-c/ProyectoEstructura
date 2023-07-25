import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué función desea utilizar?");
        System.out.println("1. Calcular Ecuación Lineal");
        System.out.println("2. Verificar Alquiler de Local");

        int opcion = scanner.nextInt();
        if (opcion == 1) {
            calcularEcuacionLineal();
        } else if (opcion == 2) {
            verificarAlquilerLocal();
        } else {
            System.out.println("Opción inválida. Por favor, ingrese 1 o 2.");
        }
    }

    public static void verificarAlquilerLocal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la distancia hacia el centro (en km): ");
        double distanciaAlCentro = scanner.nextDouble();

        System.out.print("Ingrese el precio del local: ");
        double precioLocal = scanner.nextDouble();

        if (precioLocal < 500000 && distanciaAlCentro < 2) {
            System.out.println("Puede ser alquilado.");
        } else {
            System.out.println("No se puede alquilar.");
        }
    }

    public static void calcularEcuacionLineal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Ecuaciones Lineales");
        // Se crea la variable para x1, x2, y1, y2 y b
        double x1, x2, y1, y2, b = 0;

        // Se recolectan los valores para las variables y se preguntan si es un número
        // irreal o una letra inválida
        System.out.println("Ingresa las coordenadas del primer punto (X1, Y1):");
        if (sc.hasNextDouble()) {
            x1 = sc.nextDouble();
        } else {
            System.out.println("Error: Debes ingresar un número real.");
            return;
        }

        if (sc.hasNextDouble()) {
            y1 = sc.nextDouble();
        } else {
            System.out.println("Error: Debes ingresar un número real.");
            return;
        }

        System.out.println("Ingresa las coordenadas del segundo punto (X2, Y2):");
        if (sc.hasNextDouble()) {
            x2 = sc.nextDouble();
        } else {
            System.out.println("Error: Debes ingresar un número real.");
            return;
        }

        if (sc.hasNextDouble()) {
            y2 = sc.nextDouble();
        } else {
            System.out.println("Error: Debes ingresar un número real.");
            return;
        }

        // ¿Las entradas no son números o son números irreales?
        // Calcula la pendiente (m)
        double pendiente = calcularPendiente(x1, y1, x2, y2);
        System.out.println("La pendiente (m) es: " + pendiente);

        // ¿La pendiente es igual a 0?
        if (pendiente == 0) {
            // Si la función es constante entonces termina el programa
            System.out.println("La función es una constante");
            return;
        } else if (x1 == 0 || x2 == 0) {
            // Revisa cuál de las dos x es la que es igual a 0
            double condiX = xCero(x1, x2);

            // Se le asigna a la b, la y de la x que es = 0
            if (condiX == 1) {
                b = y1;
            } else {
                b = y2;
            }

        } else {
            // Calcula la ordenada al origen (b)
            b = calcularOrdenadaAlOrigen(x1, y1, pendiente);
            System.out.println("La ordenada al origen (b) es: " + b);
        }

        // Calcula el valor de y para un valor de x dado
        System.out.println("La ecuación de la función es: f(x) = " + pendiente + " * x + " + b);
    }

    // Calcula la pendiente (m) dados dos puntos (x1, y1) y (x2, y2)
    public static double calcularPendiente(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    // Calcula la ordenada al origen (b) dados un punto (x1, y1) y la pendiente (m)
    public static double calcularOrdenadaAlOrigen(double x1, double y1, double pendiente) {
        return y1 - pendiente * x1;
    }

    // Detectar 0
    public static double xCero(double x1, double x2) {
        if (x1 == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}