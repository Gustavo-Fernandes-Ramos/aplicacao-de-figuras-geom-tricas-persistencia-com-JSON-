package ponto;
import java.awt.*;

/**
 * Escreva a descricao da classe FiguraCirculos aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */
public class FiguraPontos {
    
    public static void desenharPonto(Graphics g, int x, int y, String nome, int diametro, Color cor){
            // Color cor = new Color((int) (Math.random() * 256),  
                    // (int) (Math.random() * 256),  
                    // (int) (Math.random() * 256));
            PontoGr p = new PontoGr(x, y, cor, nome, diametro);
            p.desenharPonto(g);
    }
    
   public static void desenharPontos(Graphics g, int qtde, int larg){

        for(int i=0; i < qtde; i++) {
            int x = (int) (Math.random() * 801);
            int y = (int) (Math.random() * 801);

            // R, G e B aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            PontoGr p = new PontoGr(x, y, cor, larg);
            p.desenharPonto(g);
        }
    }
}
