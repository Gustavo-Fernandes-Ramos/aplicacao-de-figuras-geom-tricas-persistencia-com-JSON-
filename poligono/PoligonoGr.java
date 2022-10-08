package poligono;

import java.util.List;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;

import reta.Reta;
import reta.RetaGr;

public class PoligonoGr extends Poligono{
    //atributos do poligono grafico
    Color corPoligono = Color.BLACK;
    String nomePoligono = "";
    Color corNomePoligono  = Color.BLACK;
    int espPoligono = 1;
    
    //construtores
    public PoligonoGr(List<Integer> coord, Color cor, String nome, int esp, Color corNome){
        super(coord);
        setCorPoligono(cor);
        setCorNomePoligono(corNome);
        setNomePoligono(nome);
        setEspPoligono(esp);
    }
    
    public PoligonoGr(List<Integer> coord, Color cor, String nome, int esp){
        super(coord);
        setCorPoligono(cor);
        setNomePoligono(nome);
        setEspPoligono(esp);
    }
    
    public PoligonoGr(List<Integer> coord, Color cor, int esp){
        super(coord);
        setCorPoligono(cor);
        setEspPoligono(esp);
    }
    
    public PoligonoGr(List<Integer> coord){
        super(coord);
    }
    
    //setters e getters
    public void setCorPoligono(Color cor) {
        this.corPoligono = cor;
    }
        public Color getCorPoligono() {
        return this.corPoligono;
    }

    public void setNomePoligono(String str) {
        this.nomePoligono = str;
    }
    public String getNomePoligono() {
        return this.nomePoligono;
    }
    
    public void setEspPoligono(int esp) {
        this.espPoligono = esp;
    }
    public int getEspPoligono() {
        return this.espPoligono;
    }
    
    public void setCorNomePoligono(Color corNome) {
        this.corNomePoligono = corNome;
    }
    public Color getCorNomePoligono() {
        return this.corNomePoligono;
    }

    //metodo que desenha o poligono
    public void desenharPoligonoMp(Graphics g){
        int x1, y1, tam;
        Reta retaItem;
        RetaGr retaGrafica;
        
        List<Reta> retaLista = getListaRetas();
        
        tam = retaLista.size();
        //se a lista de poligonos não for vazia
        if(tam != 0){
            //exibe o nome do poligono proximo a seu primeiro ponto
            retaItem = retaLista.get(0);
            g.setColor(getCorNomePoligono());
            g.drawString(getNomePoligono(), (int)retaItem.getP1().getX(), (int)retaItem.getP1().getY());
            
            //exibe cada reta do poligono
            for(int i = 0 ; i < tam ; i++){
                retaItem = retaLista.get(i);
                retaGrafica = new RetaGr((int)retaItem.getP1().getX(), (int)retaItem.getP1().getY(), 
                                         (int)retaItem.getP2().getX(), (int)retaItem.getP2().getY(), 
                                         getCorPoligono(), "", getEspPoligono());
                retaGrafica.desenharRetaMp(g);
            }
        }
    }   
}

