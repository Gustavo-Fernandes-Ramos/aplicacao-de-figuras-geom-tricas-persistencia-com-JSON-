import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ponto.FiguraPontos;
import reta.FiguraRetas;
import circulo.FiguraCirculos;
import triangulo.FiguraTriangulos;
import retangulo.FiguraRetangulos;
import poligono.FiguraPoligonos;

import json.*;
import figura.*;

import javax.swing.JOptionPane;

public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {
    JLabel msg;           // Label para mensagens
    TipoPrimitivo tipo; // Tipo do primitivo

    Color corAtual;       // Cor atual do primitivo

    int esp;              // Diametro do ponto
    int raio;             // Raio do circulo

    // Para ponto
    int x, y;

    // Para reta, retangulo e triangulo
    int x1, y1, x2, y2, x3, y3;
    
    //figura que armazena primitivos
    Figura figuraAtual = new Figura();

    //lista de coordenadas do poligono
    List<Integer> listaCoord = new ArrayList<Integer>();

    // selecionar cada click do mouse ao desenhar um triangulo ou poligono
    private int qtdDeClicks = 0;
    
    //seleciona o primeiro click do mouse
    private boolean primeiraVez = true;

    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }
    
    //setters e getters
    public void setTipo(TipoPrimitivo tipo){ this.tipo = tipo; }

    public TipoPrimitivo getTipo(){ return this.tipo; }

    public void setEsp(int esp){ this.esp = esp; }

    public int getEsp(){ return this.esp; }

    public void setCorAtual(Color corAtual){ this.corAtual = corAtual; }

    public Color getCorAtual(){ return this.corAtual; }

    public void setMsg(JLabel msg){ this.msg = msg; }

    public JLabel getMsg(){ return this.msg; }

    public int getRaio() { return raio; }

    public void setRaio(int raio) { this.raio = raio; }

    public int getQtdDeClicks() { return this.qtdDeClicks; }

    public void setQtdDeClicks(int qtdDeClicks) { this.qtdDeClicks = qtdDeClicks; }

    public boolean getPrimeiraVez() { return this.primeiraVez; }

    public void setPrimeiraVez(boolean primeiraVez){ this.primeiraVez = primeiraVez; }

    public void paintComponent(Graphics g) { desenharPrimitivos(g); }
    
    public void limparFigura(){ figuraAtual = new Figura(); }

    // Capturando os Eventos com o mouse
    public void mousePressed(MouseEvent e) { 
        Graphics g = getGraphics();  

        if (tipo == TipoPrimitivo.PONTO){
            x = e.getX();
            y = e.getY();
            paint(g);
            
        } else if (tipo == TipoPrimitivo.RETA || tipo == TipoPrimitivo.RETANGULO){
            //retangulo e reta sao capturados da mesma forma
            if (primeiraVez == true) {
                x1 = e.getX();
                y1 = e.getY();
                primeiraVez = false;
            } else {
                x2 = e.getX();
                y2 = e.getY();
                primeiraVez = true;
                paint(g);
            } 

        }else if (tipo == TipoPrimitivo.CIRCULO){

            if (primeiraVez == true) {
                x1 = e.getX();
                y1 = e.getY();
                primeiraVez = false;
            } else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                raio = (int)Math.sqrt(Math.pow((y2-y1), 2) + Math.pow((x2-x1), 2));  // calcula o raio
                setRaio(raio);
                paint(g);
            } 

        }else if (tipo == TipoPrimitivo.TRIANGULO){
            //qtdDeClicks mostra o estado atual do desenho do triangulo: primeiro, segundo e ultimo click
            if (qtdDeClicks == 0) {
                x1 = e.getX();
                y1 = e.getY();
                qtdDeClicks++;
            } else if(qtdDeClicks == 1){
                x2 = e.getX();
                y2 = e.getY();
                qtdDeClicks++;
            } else{
                x3 = e.getX();
                y3 = e.getY();
                qtdDeClicks = 0;  //apos finalizar o desenho, qtdDeClicks = 0
                paint(g);
            }

        }else if (tipo == TipoPrimitivo.POLIGONO){
            /*qtdDeClicks mostra o estado atual do desenho do poligono: primeiro, intermediarios e ultimo click
            caso seja o primeiro click, cria uma nova lista de inteiros*/
            if(qtdDeClicks == 0) listaCoord = new ArrayList<Integer>(); 
            x = e.getX();
            y = e.getY();
            listaCoord.add(x);
            listaCoord.add(y);
            //necessario inserir pontos repetidos para que a lista de inteiros tenha a coordenada de todas as RETAS do poligono
            if(e.getButton() == MouseEvent.BUTTON1) {
                
                if(qtdDeClicks == 0){
                    //caso 1: primeiro click - adiciona um unico ponto e guarda o valor do primeiro ponto
                    x1 = x;  
                    y1 = y;
                }else{
                    //caso 2: clicks intermediarios - adiciona duas vezes o mesmo ponto
                    listaCoord.add(x);
                    listaCoord.add(y);
                }
                qtdDeClicks++;
            }else if(e.getButton() == MouseEvent.BUTTON3) {
                //caso 3: ultimo click - adiciona duas vezes o mesmo ponto e o primeiro ponto novamente
                listaCoord.add(x);
                listaCoord.add(y);
                listaCoord.add(x1);
                listaCoord.add(y1);
                qtdDeClicks = 0;
                paint(g);
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
    }

    public void carregarFiguraAnterior(){
        //le o arquivo json e o torna a figura atual
        String s;
        s = JOptionPane.showInputDialog("digite o nome do arquivo:");
        Graphics g = getGraphics();
        figuraAtual = LeituraJson.lerJson(s);
        paint(g);  //exibe a figura anterior
    }

    public void salvarFigura(){
        //cria arquivo json
        String s;
        s = JOptionPane.showInputDialog("digite o nome do arquivo: (ex: figura)");
        EscritaJson.criarJson(s, figuraAtual);
    }

    public void desenharPrimitivos(Graphics g){
        //cada primitivo definido é salvo na figura e exibido na tela
        
        if (tipo == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g, x, y, "", getEsp(), getCorAtual());
            figuraAtual.armazenarPontoGr(x, y, "", getEsp(), getCorAtual());      
        }else if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharRetaMp(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            figuraAtual.armazenarRetaGr(x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }else if (tipo==TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculoMp(g, x1, y1, getRaio(), "", getEsp(), getCorAtual());
            figuraAtual.armazenarCirculoGr(x1, y1, getRaio(), "", getEsp(), getCorAtual());
        }else if (tipo==TipoPrimitivo.TRIANGULO){
            FiguraTriangulos.desenharTrianguloMp(g, x1, y1, x2, y2, x3, y3, "", getEsp(), getCorAtual());
            figuraAtual.armazenarTrianguloGr(x1, y1, x2, y2, x3, y3, "", getEsp(), getCorAtual());
        }else if (tipo==TipoPrimitivo.RETANGULO){
            FiguraRetangulos.desenharRetanguloMp(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            figuraAtual.armazenarRetanguloGr(x1, y1, x2, y2, "", getEsp(), getCorAtual());
        }else if (tipo==TipoPrimitivo.POLIGONO){
            //uma lista de coordenadas é passada como parametro do primitivo Poligono
            FiguraPoligonos.desenharPoligonoMp(g,listaCoord, "", getEsp(), getCorAtual());
            figuraAtual.armazenarPoligonoGr(listaCoord, "", getEsp(), getCorAtual());
        }else if (tipo==TipoPrimitivo.FIGURA){
            //desenha figura anterior que foi salva em arquivo json
            FiguraGr.desenharFigura(g, figuraAtual);
        }
    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mouseDragged(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseClicked(MouseEvent e) { }

}
