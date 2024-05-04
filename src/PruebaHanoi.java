import java.util.Scanner;

public class PruebaHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de platos en cada torre:");
        int n = scanner.nextInt();
        scanner.close();

        // Mover todos los discos de B a un auxiliar (usamos C), dejando A libre para recibir los discos finales
        moverPlatos(n, 'B', 'C', 'A', 'D');
        // Ahora mover todos los discos de A y C a A
        moverTodosADestino(n, 'C', 'A', 'D');
    }

    // Método para mover discos de una torre a otra
    public static void moverPlatos(int n, char inicio, char fin, char aux1, char aux2) {
        if (n == 0) {
            return;
        }
        moverPlatos(n - 1, inicio, aux2, aux1, fin);
        System.out.println("Mover plato " + n + " de " + inicio + " a " + fin);
        moverPlatos(n - 1, aux2, fin, aux1, inicio);
    }

    // Método para combinar dos torres en una sola
    public static void moverTodosADestino(int n, char inicio, char destino, char aux) {
        if (n == 0) {
            return;
        }
        // Primero aseguramos que el subconjunto superior de la pila inicial se mueva al auxiliar
        moverTodosADestino(n - 1, inicio, aux, destino);
        // Mover el disco más grande directamente al destino
        System.out.println("Mover plato " + n + " de " + inicio + " a " + destino);
        // Mover el subconjunto del auxiliar al destino
        moverPlatos(n - 1, aux, destino, inicio, aux);
    }
}
