import java.util.Stack;

public class PruebaHanoi {

    static int discos = 0;
    static void towerOfHanoi(int n, char de_torre, char para_torre, char aux_torre, boolean finalMovement)
    {
        if (finalMovement) {
            System.out.println("Mover disco " + n + " de torre "
                    + de_torre + " para torre "
                    + para_torre);
            return;
        }

        if (n == 1) {
            System.out.println("Mover disco 1 de torre "
                    + de_torre + " para torre "
                    + para_torre);
            return;
        }
        towerOfHanoi(n - 1, de_torre, aux_torre, para_torre, finalMovement);
        System.out.println("Mover disco " + n + " de torre "
                + de_torre + " para torre "
                + para_torre);
            towerOfHanoi(n - 1, aux_torre, para_torre, aux_torre, finalMovement);
    }

    //  Driver method
    public static void main(String args[])
    {
        discos = 3; // Numero de discos
        System.out.println("Moviendo discos de la torra A a D");
        towerOfHanoi(discos - 1, 'A', 'D', 'C', false);
        System.out.println(" ");

        System.out.println("Moviendo discos de la torra B a C");
        towerOfHanoi(discos - 1, 'B', 'C', 'A', false);
        System.out.println(" ");

        // Movemos los discos mas grandes pendientes de la torre B a la torre A
        System.out.println("Moviendo disco grande de la torra B a A");
        towerOfHanoi(discos, 'B', 'A', 'C', true);
        System.out.println(" ");


        //Movemos los discos de las torres C y D para apilar por el mismo tamaño
        System.out.println("Apilado discos por tamaño:");
        towerOfHanoi(discos - 2, 'D', 'B', 'A', true);
        towerOfHanoi(discos - 2, 'C', 'B', 'A', true);
        towerOfHanoi(discos - 1, 'C', 'A', 'D', true);
        towerOfHanoi(discos - 1, 'D', 'A', 'D', true);
        towerOfHanoi(discos - 2, 'B', 'A', 'D', true);
        towerOfHanoi(discos - 2, 'B', 'A', 'D', true);
        System.out.println(" ");
    }
}