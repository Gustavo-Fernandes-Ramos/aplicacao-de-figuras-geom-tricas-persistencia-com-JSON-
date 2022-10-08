package retangulo;
import reta.Reta;
import ponto.Ponto;

public class Retangulo{
    
    //reta que armazena os pontos que definem a diagonal do retangulo
    private Reta diagonal;
    
    //construtores
    public Retangulo(double x1, double y1, double x2, double y2){
        setDiagonal(new Reta(x1, y1, x2, y2));
    }
    
    public Retangulo(Ponto p1, Ponto p2){
        setDiagonal(new Reta(p1, p2));
    }
    
    public Retangulo(Reta r){
        setDiagonal(r);
    }
    
    //setters e getters
    public void setDiagonal(Reta diagonal){
        this.diagonal = diagonal;
    }
    public Reta getDiagonal(){
        return this.diagonal;
    }
    
    public String toString(){
        String s;
        s = "Diagonal do retangulo: " + getDiagonal().toString();
        return s;
    }
}