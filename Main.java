import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
}
