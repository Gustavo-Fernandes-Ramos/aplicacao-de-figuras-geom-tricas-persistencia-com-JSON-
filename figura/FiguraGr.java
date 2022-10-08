package figura;
import ponto.PontoGr;
import reta.RetaGr;
import circulo.CirculoGr;
import circulo.FiguraCirculos;
import retangulo.RetanguloGr;
import triangulo.TrianguloGr;
import poligono.PoligonoGr;

import java.util.List;
import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Color;

public class FiguraGr{
    
    //metodo que desenha figuras salvas anteriormente
    public static void desenharFigura(Graphics g, Figura fig){
        int tam;
        
        //desenha cada ponto da figura
        PontoGr pontoItem;
        List<PontoGr> listaP = fig.getListaPontos();
        tam = listaP.size();
        for(int i = 0 ; i < tam ; i++){
            pontoItem = listaP.get(i);
            pontoItem.desenharPonto(g);
        }
        
        //desenha cada reta da figura
        RetaGr retaItem;
        List<RetaGr> listaR = fig.getListaRetas();
        tam = listaR.size();
        for(int i = 0 ; i < tam ; i++){
            retaItem = listaR.get(i);
            retaItem.desenharRetaMp(g);
        }
        
        //desenha cada circulo da figura
        CirculoGr circuloItem;
        List<CirculoGr> listaC = fig.getListaCirculos();
        tam = listaC.size();
        for(int i = 0 ; i < tam ; i++){
            circuloItem = listaC.get(i);
            circuloItem.desenharCirculoMp(g);
        }
        
        //desenha cada retangulo da figura
        RetanguloGr retanguloItem;
        List<RetanguloGr> listaRet = fig.getListaRetangulos();
        tam = listaRet.size();
        for(int i = 0 ; i < tam ; i++){
            retanguloItem = listaRet.get(i);
            retanguloItem.desenharRetanguloMp(g);
        }
        
        //desenha cada triangulo da figura
        TrianguloGr trianguloItem;
        List<TrianguloGr> listaT = fig.getListaTriangulos();
        tam = listaT.size();
        for(int i = 0 ; i < tam ; i++){
            trianguloItem = listaT.get(i);
            trianguloItem.desenharTrianguloMp(g);
        }
        
        //desenha cada poligono da figura
        PoligonoGr poligonoItem;
        List<PoligonoGr> listaPol = fig.getListaPoligonos();
        tam = listaPol.size();
        for(int i = 0 ; i < tam ; i++){
            poligonoItem = listaPol.get(i);
            poligonoItem.desenharPoligonoMp(g);
        }
        
    }
}
