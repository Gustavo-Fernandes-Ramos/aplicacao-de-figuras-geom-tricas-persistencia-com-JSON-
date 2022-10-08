package json;
//API de arquivo json, necessario baixar arquivo jar
//https://code.google.com/archive/p/json-simple/
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.List;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;

import ponto.PontoGr;
import reta.Reta;
import reta.RetaGr;
import circulo.CirculoGr;
import circulo.FiguraCirculos;
import retangulo.RetanguloGr;
import triangulo.TrianguloGr;
import poligono.PoligonoGr;
import figura.Figura;

//import java.text.DecimalFormat;

public class EscritaJson {
    //metodo escreve arquivos json que representam figuras 2D
    public static void criarJson(String s, Figura fig) {
        //cria objeto json figura
        JSONObject JSONFigura = new JSONObject();
    
        int tam, tamPol; //tam e tamPol sao utilizados como limite das estruturas de repeticao
        
        //variaveis utilizadas para difinir todos os dados da figura json
        JSONObject primitivo;
        JSONArray JSONListaCoord;
        JSONArray JSONCoord;
        JSONArray JSONColor;
        
        JSONArray JSONPontos = new JSONArray();  //cria uma lista de pontos json
        PontoGr pontoItem; //usado para percorrer a lista de pontos
        List<PontoGr> listaP = fig.getListaPontos(); //obtem lista de pontos da figura
        tam = listaP.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                pontoItem = listaP.get(i);
                primitivo = new JSONObject(); //objeto json
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(pontoItem.getCorPto().getRed());
                JSONColor.add(pontoItem.getCorPto().getGreen());
                JSONColor.add(pontoItem.getCorPto().getBlue());
                //coordenadas do ponto
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(pontoItem.getX()));
                JSONCoord.add(obterCoordNormalizadaY(pontoItem.getY()));
                //inicializa ponto json
                primitivo.put("nome", pontoItem.getNomePto());
                primitivo.put("coord", JSONCoord);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", pontoItem.getDiametro());
                //adiciona ponto json a lista de pontos json
                JSONPontos.add(primitivo);
            }
            JSONFigura.put("pontos", JSONPontos); //adiciona a lista de pontos json a figura json
        }
        
        
        JSONArray JSONRetas = new JSONArray(); //cria uma lista de retas json       
        RetaGr retaItem; //usado para percorrer a lista de retas
        List<RetaGr> listaR = fig.getListaRetas(); //obtem lista de retas da figura
        tam = listaR.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                retaItem = listaR.get(i);
                
                primitivo = new JSONObject(); //objeto json
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(retaItem.getCorReta().getRed());
                JSONColor.add(retaItem.getCorReta().getGreen());
                JSONColor.add(retaItem.getCorReta().getBlue());
                //lista de pontos de cada reta
                JSONListaCoord = new JSONArray();
                //ponto 1 da reta
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(retaItem.getP1().getX()));
                JSONCoord.add(obterCoordNormalizadaY(retaItem.getP1().getY()));
                JSONListaCoord.add(JSONCoord);
                //ponto 2 da reta
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(retaItem.getP2().getX()));
                JSONCoord.add(obterCoordNormalizadaY(retaItem.getP2().getY()));
                JSONListaCoord.add(JSONCoord);
                //inicializa reta json
                primitivo.put("nome", retaItem.getNomeReta());
                primitivo.put("pontos", JSONListaCoord);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", retaItem.getEspReta());
                
                JSONRetas.add(primitivo); // adiciona a reta json a lista de retas json
            }
            JSONFigura.put("retas", JSONRetas); //adiciona a lista de retas json a figura json
        }
        
        
        JSONArray JSONCirculos = new JSONArray();  //cria uma lista de circulos json    
        CirculoGr circuloItem; //usado para percorrer a lista de circulos
        List<CirculoGr> listaC = fig.getListaCirculos(); //obtem lista de circulos da figura
        tam = listaC.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                circuloItem = listaC.get(i);
                
                primitivo = new JSONObject(); //objeto json
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(circuloItem.getCorCirculo().getRed());
                JSONColor.add(circuloItem.getCorCirculo().getGreen());
                JSONColor.add(circuloItem.getCorCirculo().getBlue());
                //centro do circulo
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(circuloItem.getCentro().getX()));
                JSONCoord.add(obterCoordNormalizadaY(circuloItem.getCentro().getY()));
                //inicializa circulo json
                primitivo.put("nome", circuloItem.getNomeCirculo());
                primitivo.put("centro", JSONCoord);
                primitivo.put("raio", (circuloItem.getRaio())/Constantes.XW_MAX);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", circuloItem.getEspCirculo());
                
                JSONCirculos.add(primitivo);
            }
            JSONFigura.put("circulos", JSONCirculos);
        }
        
        
        JSONArray JSONRetangulos = new JSONArray();  //cria uma lista de retangulos json   
        RetanguloGr retanguloItem; //usado para percorrer a lista de retangulos
        List<RetanguloGr> listaRet = fig.getListaRetangulos(); //obtem lista de retangulos da figura
        tam = listaRet.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                retanguloItem = listaRet.get(i);
                
                primitivo = new JSONObject(); //objeto json
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(retanguloItem.getCorRetangulo().getRed());
                JSONColor.add(retanguloItem.getCorRetangulo().getGreen());
                JSONColor.add(retanguloItem.getCorRetangulo().getBlue());
                //lista de pontos do retangulo
                JSONListaCoord = new JSONArray();
                //ponto 1
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(retanguloItem.getDiagonal().getP1().getX()));
                JSONCoord.add(obterCoordNormalizadaY(retanguloItem.getDiagonal().getP1().getY()));
                JSONListaCoord.add(JSONCoord);
                //ponto 2
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(retanguloItem.getDiagonal().getP2().getX()));
                JSONCoord.add(obterCoordNormalizadaY(retanguloItem.getDiagonal().getP2().getY()));
                JSONListaCoord.add(JSONCoord);
                //inicializa retangulo json
                primitivo.put("nome", retanguloItem.getNomeRetangulo());
                primitivo.put("pontos", JSONListaCoord);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", retanguloItem.getEspRetangulo());
                
                JSONRetangulos.add(primitivo);
            }
            JSONFigura.put("retangulos", JSONRetangulos);
        }
        
        JSONArray JSONTriangulos = new JSONArray(); //cria uma lista de triangulos json       
        TrianguloGr trianguloItem; //usado para percorrer a lista de triangulos
        List<TrianguloGr> listaT = fig.getListaTriangulos(); //obtem lista de triangulos da figura
        tam = listaT.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                trianguloItem = listaT.get(i);
                
                primitivo = new JSONObject(); 
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(trianguloItem.getCorTriangulo().getRed());
                JSONColor.add(trianguloItem.getCorTriangulo().getGreen());
                JSONColor.add(trianguloItem.getCorTriangulo().getBlue());
                
                //lista de pontos do triangulo
                JSONListaCoord = new JSONArray();
                //ponto 1
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(trianguloItem.getReta1().getP1().getX()));
                JSONCoord.add(obterCoordNormalizadaY(trianguloItem.getReta1().getP1().getY()));
                JSONListaCoord.add(JSONCoord);
                //ponto 2
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(trianguloItem.getReta1().getP2().getX()));
                JSONCoord.add(obterCoordNormalizadaY(trianguloItem.getReta1().getP2().getY()));
                JSONListaCoord.add(JSONCoord);
                //ponto 3
                JSONCoord = new JSONArray();
                JSONCoord.add(obterCoordNormalizadaX(trianguloItem.getReta2().getP2().getX()));
                JSONCoord.add(obterCoordNormalizadaY(trianguloItem.getReta2().getP2().getY()));
                JSONListaCoord.add(JSONCoord);
                
                //inicializa triangulo json
                primitivo.put("nome", trianguloItem.getNomeTriangulo());
                primitivo.put("pontos", JSONListaCoord);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", trianguloItem.getEspTriangulo());
                
                JSONTriangulos.add(primitivo);
            }
            JSONFigura.put("triangulos", JSONTriangulos);
        }
        
        Reta retaPol; //usado para percorrer as retas do poligono
        List<Reta> listaRetasPol; //usado para obter as retas do poligono
        
        JSONArray JSONPoligonos = new JSONArray();  //cria uma lista de poligonos json     
        PoligonoGr poligonoItem; //usado para percorrer a lista de poligonos
        List<PoligonoGr> listaPol = fig.getListaPoligonos(); //obtem lista de poligonos da figura
        tam = listaPol.size();
        if(tam != 0){
            for(int i = 0; i < tam ; i++){
                poligonoItem = listaPol.get(i);
                
                primitivo = new JSONObject(); //objeto json
                //cor
                JSONColor = new JSONArray();
                JSONColor.add(poligonoItem.getCorPoligono().getRed());
                JSONColor.add(poligonoItem.getCorPoligono().getGreen());
                JSONColor.add(poligonoItem.getCorPoligono().getBlue());
                //lista de pontos do poligono
                JSONListaCoord = new JSONArray();
                
                //obtem as retas do poligono
                listaRetasPol = poligonoItem.getListaRetas();
                tamPol = listaRetasPol.size();
                //percorre as retas do poligono
                for(int j = 0; j < tamPol ; j++){
                    retaPol = listaRetasPol.get(j);
                    //pontos do poligono
                    JSONCoord = new JSONArray();
                    JSONCoord.add(obterCoordNormalizadaX(retaPol.getP2().getX()));
                    JSONCoord.add(obterCoordNormalizadaY(retaPol.getP2().getY()));
                    JSONListaCoord.add(JSONCoord);
                }
                
                //inicializa poligono json
                primitivo.put("nome", poligonoItem.getNomePoligono());
                primitivo.put("pontos", JSONListaCoord);
                primitivo.put("cor", JSONColor);
                primitivo.put("esp", poligonoItem.getEspPoligono());
                
                JSONPoligonos.add(primitivo); //adiciona poligono json a lista de poligonos json
            }
            JSONFigura.put("poligonos", JSONPoligonos); //adiciona a lista de poligonos json a figura json
        }
        
        //classe de escrita de arquivo
        try(FileWriter arquivoJson = new FileWriter(s + ".json")){
            //cria arquivo json
            arquivoJson.write(JSONFigura.toJSONString());
            arquivoJson.flush();
        }catch(IOException e){
           e.printStackTrace();
        }
        
    }
    
    //transforma a coordenada x de janela para coordenada normalizada
    private static double obterCoordNormalizadaX(double xw){
        double x;
        x = (xw - Constantes.XW_MIN)/(Constantes.XW_MAX - Constantes.XW_MIN);
        return x;
    }
    
    //transforma a coordenada y de janela para coordenada normalizada
    private static double obterCoordNormalizadaY(double yw){
        double y;
        y = (yw - Constantes.YW_MIN)/(Constantes.YW_MAX - Constantes.YW_MIN);
        return y;
    }
    
}
