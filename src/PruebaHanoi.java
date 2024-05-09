import java.util.Scanner;

public class PruebaHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de discos en la Torre A: ");
        int numDiscosA = scanner.nextInt();
        System.out.print("Ingrese el número de discos en la Torre B: ");
        int numDiscosB = scanner.nextInt();

        System.out.println("Moviendo todos los discos a la Torre A:");
        // Mover discos de B a C usando D y A como auxiliares
        moverDiscos(numDiscosB, 'B', 'C', 'D', 'A');
        // Mover discos de A a D usando B y C como auxiliares
        moverDiscos(numDiscosA, 'A', 'D', 'B', 'C');
        // Mover discos de C a A usando B y D como auxiliares
        moverDiscos(numDiscosB, 'C', 'A', 'B', 'D');
        // Finalmente, mover discos de D a A usando B y C como auxiliares
        moverDiscos(numDiscosA, 'D', 'A', 'B', 'C');
    }

    // Método recursivo para mover los discos
    public static void moverDiscos(int n, char fromTower, char toTower, char auxTower1, char auxTower2) {
        if (n == 0) return;
        if (n == 1) {
            System.out.println("Mueva el disco 1 desde " + fromTower + " hasta " + toTower);
            return;
        }

        moverDiscos(n - 1, fromTower, auxTower1, auxTower2, toTower);
        System.out.println("Mueva el disco " + n + " desde " + fromTower + " hasta " + toTower);
        moverDiscos(n - 1, auxTower1, toTower, fromTower, auxTower2);
    }
}