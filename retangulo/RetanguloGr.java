package retangulo;

import java.awt.Color;
import java.awt.Graphics;

import reta.RetaGr;
import ponto.PontoGr;

public class RetanguloGr extends Retangulo {
    //atributos do retangulo grafico
    Color corRetangulo = Color.BLACK;
    String nomeRetangulo = "";
    Color corNomeRetangulo  = Color.BLACK;
    int espRetangulo = 1;
    
    //construtores
    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        super(x1, y1, x2, y2);
        setCorRetangulo(cor);
        setNomeRetangulo(nome);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor, int esp){
        super(x1, y1, x2, y2);
        setCorRetangulo(cor);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(int x1, int y1, int x2, int y2){
        super(x1, y1, x2, y2);
    }
    
    public RetanguloGr(RetaGr r, Color cor, String nome, Color corNome, int esp){
        super(r);
        setCorRetangulo(cor);
        setCorNomeRetangulo(corNome);
        setNomeRetangulo(nome);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(RetaGr r, Color cor, int esp){
        super(r);
        setCorRetangulo(cor);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(RetaGr r){
        super(r);
    }
    
    public RetanguloGr(PontoGr p1, PontoGr p2, Color cor, String nome, Color corNome, int esp){
        super(p1, p2);
        setCorRetangulo(cor);
        setCorNomeRetangulo(corNome);
        setNomeRetangulo(nome);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(PontoGr p1, PontoGr p2, Color cor, int esp){
        super(p1, p2);
        setCorRetangulo(cor);
        setEspRetangulo(esp);
    }
    
    public RetanguloGr(PontoGr p1, PontoGr p2){
        super(p1, p2);
    }
    
    //construtores
    public void setCorRetangulo(Color cor) {
        this.corRetangulo = cor;
    }
        public Color getCorRetangulo() {
        return this.corRetangulo;
    }

    public void setNomeRetangulo(String str) {
        this.nomeRetangulo = str;
    }
    public String getNomeRetangulo() {
        return this.nomeRetangulo;
    }
    
    public void setEspRetangulo(int esp) {
        this.espRetangulo = esp;
    }
    public int getEspRetangulo() {
        return this.espRetangulo;
    }
    
    public void setCorNomeRetangulo(Color corNomeRetangulo) {
        this.corNomeRetangulo = corNomeRetangulo;
    }
    public Color getCorNomeRetangulo() {
        return this.corNomeRetangulo;
    }
    
    //desenhar retangulo
    public void desenharRetanguloMp(Graphics g){
        g.setColor(getCorNomeRetangulo());
        g.drawString(getNomeRetangulo(), (int)getDiagonal().getP1().getX(), (int)getDiagonal().getP1().getY());
        RetaGr r1 = new RetaGr((int)getDiagonal().getP1().getX(), (int)getDiagonal().getP1().getY(), (int)getDiagonal().getP2().getX(), (int)getDiagonal().getP1().getY(), getCorRetangulo(), getEspRetangulo());
        r1.desenharRetaMp(g);
        RetaGr r2 = new RetaGr((int)getDiagonal().getP2().getX(), (int)getDiagonal().getP1().getY(), (int)getDiagonal().getP2().getX(), (int)getDiagonal().getP2().getY(), getCorRetangulo(), getEspRetangulo());
        r2.desenharRetaMp(g);
        RetaGr r3 = new RetaGr((int)getDiagonal().getP2().getX(), (int)getDiagonal().getP2().getY(), (int)getDiagonal().getP1().getX(), (int)getDiagonal().getP2().getY(), getCorRetangulo(), getEspRetangulo());
        r3.desenharRetaMp(g);
        RetaGr r4 = new RetaGr((int)getDiagonal().getP1().getX(), (int)getDiagonal().getP2().getY(), (int)getDiagonal().getP1().getX(), (int)getDiagonal().getP1().getY(), getCorRetangulo(), getEspRetangulo());
        r4.desenharRetaMp(g);
    }
}
