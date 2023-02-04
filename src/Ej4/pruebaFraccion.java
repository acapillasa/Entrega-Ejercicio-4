package Ej4;

public class pruebaFraccion {
    public static void main(String[] args) throws FractionException {
        Fraccion fr = new Fraccion(5,10);
        Fraccion fra = new Fraccion(5, 2);

        System.out.println("LA SUMA");
        System.out.println(fr.sumar(fra));

        System.out.println();

        System.out.println("LA RESTA");
        System.out.println(fr.restar(fra));

        System.out.println();

        System.out.println("LA MULTIPLICACIÓN");
        System.out.println(fr.multiplicar(fra));

        System.out.println();

        System.out.println("LA DIVISIÓN");
        System.out.println(fr.dividir(fra));
    }
}
