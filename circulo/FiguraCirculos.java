package circulo;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Desenhar figuras com circulo.
 * 
 * @author Julio Arakaki
 * @version 27/08/2021
 */
public class FiguraCirculos {
    public static void desenharCirculoEq(Graphics g, int xc, int yc, int raio, String nome, int esp, Color cor){
        CirculoGr c = new CirculoGr(xc, yc, raio, cor, nome, esp);
        c.desenharCirculoEq(g);
    }
    public static void desenharCirculoMp(Graphics g, int xc, int yc, int raio, String nome, int esp, Color cor){
        CirculoGr c = new CirculoGr(xc, yc, raio, cor, nome, esp);
        c.desenharCirculoMp(g);
    }
    public static void desenharCirculos(Graphics g, int qtde, int esp){
        for(int i=0; i < qtde; i++) {
            int xc = (int) (Math.random() * 701);
            int yc = (int) (Math.random() * 601);
            int raio = (int) (Math.random() * 601);

            // R, G e B aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            CirculoGr c = new CirculoGr(xc, yc, raio, cor, "", esp);
            c.desenharCirculoMp(g);
        }
    }
}
