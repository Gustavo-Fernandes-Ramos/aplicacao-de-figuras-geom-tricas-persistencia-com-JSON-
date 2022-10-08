package poligono;

import java.util.List;
import java.util.ArrayList;

import java.awt.*;

public class FiguraPoligonos{
    //recebe como parametro uma lista de coordenadas
    //metodo que exibe o poligono
    public static void desenharPoligonoMp(Graphics g, List<Integer> listaCoord, String nome, int esp, Color cor){
        PoligonoGr p = new PoligonoGr(listaCoord, cor, nome, esp);
        p.desenharPoligonoMp(g);
    }
}


