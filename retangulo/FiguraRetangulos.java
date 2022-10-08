package retangulo;

import java.awt.*;

public class FiguraRetangulos {
    //metodo que desenha o retangulo
    public static void desenharRetanguloMp(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
        RetanguloGr r = new RetanguloGr(x1, y1, x2, y2, cor, nome, esp);
        r.desenharRetanguloMp(g);
    }
}
