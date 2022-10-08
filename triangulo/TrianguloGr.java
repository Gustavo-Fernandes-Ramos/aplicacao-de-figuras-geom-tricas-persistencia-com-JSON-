package triangulo;

import java.awt.Color;
import java.awt.Graphics;

import reta.RetaGr;
import ponto.PontoGr;

public class TrianguloGr extends Triangulo{
    //atributos do triangulo grafico
    Color corTriangulo = Color.BLACK;
    String nomeTriangulo = "";
    Color corNomeTriangulo  = Color.BLACK;
    int espTriangulo = 1;

    //construtores
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor, String nome, int esp){
        super(x1, y1, x2, y2, x3, y3);
        setCorTriangulo(cor);
        setNomeTriangulo(nome);
        setEspTriangulo(esp);
    }
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor, int esp){
        super(x1, y1, x2, y2, x3, y3);
        setCorTriangulo(cor);
        setEspTriangulo(esp);
    }
    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3){
        super(x1, y1, x2, y2, x3, y3);
    }
    
    public TrianguloGr(RetaGr r1, RetaGr r2, RetaGr r3, Color cor, String nome, Color corNome, int esp){
        super(r1, r2, r3);
        setCorTriangulo(cor);
        setCorNomeTriangulo(corNome);
        setNomeTriangulo(nome);
        setEspTriangulo(esp);
    }
    public TrianguloGr(RetaGr r1, RetaGr r2, RetaGr r3, Color cor, int esp){
        super(r1, r2, r3);
        setCorTriangulo(cor);
        setEspTriangulo(esp);
    }
    public TrianguloGr(RetaGr r1, RetaGr r2, RetaGr r3){
        super(r1, r2, r3);
    }
    
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3, Color cor, String nome, Color corNome, int esp){
        super(p1, p2, p3);
        setCorTriangulo(cor);
        setCorNomeTriangulo(corNome);
        setNomeTriangulo(nome);
        setEspTriangulo(esp);
    }
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3, Color cor, int esp){
        super(p1, p2, p3);
        setCorTriangulo(cor);
        setEspTriangulo(esp);
    }
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3){
        super(p1, p2, p3);
    }
    
    //setters e getters
    public void setCorTriangulo(Color cor) {
        this.corTriangulo = cor;
    }
        public Color getCorTriangulo() {
        return this.corTriangulo;
    }

    public void setNomeTriangulo(String str) {
        this.nomeTriangulo = str;
    }
    public String getNomeTriangulo() {
        return this.nomeTriangulo;
    }
    
    public void setEspTriangulo(int esp) {
        this.espTriangulo = esp;
    }
    public int getEspTriangulo() {
        return(this.espTriangulo);
    }
    
    public void setCorNomeTriangulo(Color corNomeTriangulo) {
        this.corNomeTriangulo = corNomeTriangulo;
    }
    public Color getCorNomeTriangulo() {
        return this.corNomeTriangulo;
    }
    
    //desenhar triangulo
    public void desenharTrianguloMp(Graphics g){
        //desenha o nome do triangulo
        g.setColor(getCorNomeTriangulo());
        g.drawString(getNomeTriangulo(), (int)getReta1().getP1().getX(), (int)getReta1().getP1().getY());
        
        RetaGr r1 = new RetaGr((int)getReta1().getP1().getX(), (int)getReta1().getP1().getY(), (int)getReta1().getP2().getX(), (int)getReta1().getP2().getY(), getCorTriangulo(), getEspTriangulo());
        r1.desenharRetaMp(g);
        RetaGr r2 = new RetaGr((int)getReta2().getP1().getX(), (int)getReta2().getP1().getY(), (int)getReta2().getP2().getX(), (int)getReta2().getP2().getY(), getCorTriangulo(), getEspTriangulo());
        r2.desenharRetaMp(g);
        RetaGr r3 = new RetaGr((int)getReta3().getP1().getX(), (int)getReta3().getP1().getY(), (int)getReta3().getP2().getX(), (int)getReta3().getP2().getY(), getCorTriangulo(), getEspTriangulo());
        r3.desenharRetaMp(g);
    }
}


