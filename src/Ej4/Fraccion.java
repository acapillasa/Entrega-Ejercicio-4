package Ej4;

public class Fraccion {
    private int numerador;
    private int denominador;

    Fraccion(int numerador, int denominador) throws FractionException {

        if (denominador == 0) {
            throw new FractionException("ERROR: No se puede crear una instancia de una fracción con denominador 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;

    }

    Fraccion sumar(Fraccion otraFraccion) throws FractionException {
        Fraccion sumado;
        int totalDenominador = getDenominador()*otraFraccion.getDenominador();
        int totalNumerador = ((totalDenominador/getDenominador())*getNumerador())+(totalDenominador/otraFraccion.getDenominador())*otraFraccion.getNumerador();

        if ((totalDenominador/getDenominador())*getNumerador() == 0 || (totalDenominador/otraFraccion.getDenominador())*otraFraccion.getNumerador() == 0) {
            throw new FractionException("ERROR: Esta operación da como resultado una fracción no válida");
        }

        sumado = simplificarFraccion(totalNumerador,totalDenominador);
        return sumado;
    }
    Fraccion restar(Fraccion otraFraccion) throws FractionException {
        Fraccion restado;
        int totalDenominador = getDenominador()*otraFraccion.getDenominador();
        int totalNumerador = ((totalDenominador/getDenominador())*getNumerador())-(totalDenominador/otraFraccion.getDenominador())*otraFraccion.getNumerador();

        if ((totalDenominador/getDenominador())*getNumerador() == 0 || (totalDenominador/otraFraccion.getDenominador())*otraFraccion.getNumerador() == 0) {
            throw new FractionException("ERROR: Esta operación da como resultado una fracción no válida");
        }

        restado = simplificarFraccion(totalNumerador,totalDenominador);
        return restado;
    }
    Fraccion multiplicar(Fraccion otraFraccion) throws FractionException {
        Fraccion frMul = new Fraccion(getNumerador()*otraFraccion.getNumerador(),getDenominador()*otraFraccion.getDenominador());
        return simplificarFraccion(frMul.getNumerador(),frMul.getDenominador());
    }
    Fraccion dividir(Fraccion otraFraccion) throws FractionException {
        Fraccion frDiv = new Fraccion(getNumerador()*otraFraccion.getDenominador(),getDenominador()*otraFraccion.getNumerador());
        return simplificarFraccion(frDiv.getNumerador(), frDiv.getDenominador());

    }

    static int mcd(int a, int b) {
        return (b == 0) ? a : mcd(b, a % b);
    }

    static Fraccion simplificarFraccion(int numerador, int denominador) {
        int mcd = mcd(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
        return new Fraccion(numerador,denominador);
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                "numerador=" + numerador +
                ", denominador=" + denominador +
                '}';
    }

}
