package circulo;
import ponto.Ponto;

/**
 * Write a description of class TestaReta here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestaCirculo
{
    public static void main(String args[]) {
        Ponto p = new Ponto(23.5, 45.7);
        Circulo c = new Circulo(10, 10, 20);
        Circulo c1 = new Circulo(c);
        Circulo c2 = new Circulo(p, 22);
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
    }
}