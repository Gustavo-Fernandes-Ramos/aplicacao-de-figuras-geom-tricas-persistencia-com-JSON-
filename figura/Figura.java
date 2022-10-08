package figura;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import ponto.PontoGr;
import reta.RetaGr;
import circulo.CirculoGr;
import retangulo.RetanguloGr;
import triangulo.TrianguloGr;
import poligono.PoligonoGr;

//classe que armazena todos os primitivos
public class Figura {
    
    //listas que armazenam cada tipo de primitivo
    List<PontoGr> listaPontos;      List<RetaGr> listaRetas;
    List<CirculoGr> listaCirculos;    List<TrianguloGr> listaTriangulos;
    List<RetanguloGr> listaRetangulos;  List<PoligonoGr> listaPoligonos;
    
    //construtor
    public Figura() {
        setListaPontos(new ArrayList<PontoGr>());
        setListaRetas(new ArrayList<RetaGr>());
        setListaCirculos(new ArrayList<CirculoGr>());
        setListaTriangulos(new ArrayList<TrianguloGr>());
        setListaRetangulos(new ArrayList<RetanguloGr>());
        setListaPoligonos(new ArrayList<PoligonoGr>());
    }
    
    //setters e getters
    public void setListaPontos(List<PontoGr> listaPontos){ this.listaPontos = listaPontos; }
    public List<PontoGr> getListaPontos(){ return listaPontos; }
    
    public void setListaRetas(List<RetaGr> listaRetas){ this.listaRetas = listaRetas; }
    public List<RetaGr> getListaRetas(){ return listaRetas; }
    
    public void setListaCirculos(List<CirculoGr> listaCirculos){ this.listaCirculos = listaCirculos; }
    public List<CirculoGr> getListaCirculos(){ return listaCirculos; }
    
    public void setListaRetangulos(List<RetanguloGr> listaRetangulos){ this.listaRetangulos = listaRetangulos; }
    public List<RetanguloGr> getListaRetangulos(){ return listaRetangulos; }
    
    public void setListaTriangulos(List<TrianguloGr> listaTriangulos){ this.listaTriangulos = listaTriangulos; }
    public List<TrianguloGr> getListaTriangulos(){ return listaTriangulos; }
    
    public void setListaPoligonos(List<PoligonoGr> listaPoligonos){ this.listaPoligonos = listaPoligonos; }
    public List<PoligonoGr> getListaPoligonos(){ return listaPoligonos; }
    
    //armazena os pontos obtidos atraves do painel de desenho
    public void armazenarPontoGr(int x, int y, String nome, int esp, Color cor){
        PontoGr p = new PontoGr(x, y, cor, nome, esp);
        List<PontoGr> lista = getListaPontos();
        lista.add(p);
    }
    
    //armazena as retas obtidas atraves do painel de desenho
    public void armazenarRetaGr(int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
        RetaGr r = new RetaGr(x1, y1, x2, y2, cor, nome, esp);
        List<RetaGr> lista = getListaRetas();
        lista.add(r);
    }
    
    //armazena os circulos obtidos atraves do painel de desenho
    public void armazenarCirculoGr(int x, int y, int raio, String nome, int esp, Color cor){
        CirculoGr c = new CirculoGr(x, y, raio, cor, nome, esp);
        List<CirculoGr> lista = getListaCirculos();
        lista.add(c);
    }
    
    //armazena os triangulos obtidos atraves do painel de desenho
    public void armazenarTrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, String nome, int esp, Color cor){
        TrianguloGr t = new TrianguloGr(x1, y1, x2, y2, x3, y3, cor, nome, esp);
        List<TrianguloGr> lista = getListaTriangulos();
        lista.add(t);
    }
    
    //armazena os retangulos obtidos atraves do painel de desenho
    public void armazenarRetanguloGr(int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
        RetanguloGr r = new RetanguloGr(x1, y1, x2, y2, cor, nome, esp);
        List<RetanguloGr> lista = getListaRetangulos();
        lista.add(r);
    }
    
    //armazena os poligonos obtidos atraves do painel de desenho
    public void armazenarPoligonoGr(List<Integer> listaCoord, String nome, int esp, Color cor){
        PoligonoGr p = new PoligonoGr(listaCoord, cor, nome, esp);
        List<PoligonoGr> lista = getListaPoligonos();
        lista.add(p);
    }
}
