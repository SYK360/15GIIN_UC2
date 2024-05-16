public class PruebaHanoi {

    /**
     * Resuelve el problema de las Torres de Hanoi moviendo `n` discos desde
     * `de_torre` hasta `para_torre` utilizando `aux_torre` como torre auxiliar.
     * Si `finalMovement` es verdadero, realiza solo el movimiento final del disco
     * más grande, de lo contrario, sigue el proceso estándar de Hanoi.
     *
     * @param n el número de discos a mover
     * @param de_torre la torre de origen
     * @param para_torre la torre de destino
     * @param aux_torre la torre auxiliar
     * @param finalMovement indicador para determinar si se realiza solo el movimiento final
     */
    static void torresHanoi(int n, char de_torre, char para_torre, char aux_torre, boolean finalMovement) {
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
        torresHanoi(n - 1, de_torre, aux_torre, para_torre, finalMovement);
        System.out.println("Mover disco " + n + " de torre "
                + de_torre + " para torre "
                + para_torre);
        torresHanoi(n - 1, aux_torre, para_torre, de_torre, finalMovement);
    }

    /**
     * Método principal que ejecuta varios casos de prueba para la solución de las
     * Torres de Hanoi. Utiliza 3 discos e imprime los pasos necesarios para mover
     * los discos entre diferentes torres según los requisitos específicos.
     *
     * @param args los argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int discos = 3; // Número de discos
        System.out.println("Moviendo discos de la torre A a D");
        torresHanoi(discos - 1, 'A', 'D', 'C', false);
        System.out.println(" ");

        System.out.println("Moviendo discos de la torre B a C");
        torresHanoi(discos - 1, 'B', 'C', 'A', false);
        System.out.println(" ");

        // Movemos los discos más grandes pendientes de la torre B a la torre A
        System.out.println("Moviendo disco grande de la torre B a A");
        torresHanoi(discos, 'B', 'A', 'C', true);
        System.out.println(" ");

        // Movemos los discos de las torres C y D para apilar por el mismo tamaño
        System.out.println("Apilando discos por tamaño:");
        torresHanoi(discos - 2, 'D', 'B', 'A', true);
        torresHanoi(discos - 2, 'C', 'B', 'A', true);
        torresHanoi(discos - 1, 'C', 'A', 'D', true);
        torresHanoi(discos - 1, 'D', 'A', 'D', true);
        torresHanoi(discos - 2, 'B', 'A', 'D', true);
        torresHanoi(discos - 2, 'B', 'A', 'D', true);
        System.out.println(" ");
    }
}
