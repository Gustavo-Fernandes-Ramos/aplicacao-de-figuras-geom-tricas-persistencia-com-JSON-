package json;
//API de arquivo json, necessario baixar arquivo jar
//https://code.google.com/archive/p/json-simple/
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.awt.Color;
import figura.Figura;

import javax.swing.JOptionPane;

public class LeituraJson {
    //metodo le arquivos json que representam figuras 2D
    public static Figura lerJson(String s){
        //variaveis que manipulam os atributos de cada tipo de primitivo
        String nome;   Color cor; 
        int esp, tam, tamPol; //tam e tamPol sao utilizados como limite das estruturas de repeticao
        double x, y, x1, y1, x2, y2, x3, y3, raio;
        
        Figura figura = new Figura(); //figura que sera obtida do arquivo json
        
        JSONParser jsonParser = new JSONParser(); //parser
        
        //classe de leitura de arquivo
        try(FileReader leitor = new FileReader(s + ".json")){
            //obtem o objeto figura em formato json
            Object obj = jsonParser.parse(leitor);
            JSONObject JSONFigura = (JSONObject) obj;
            
            //variaveis utilizadas para percorrer todos os dados da figura json
            JSONObject JSONPrimitivo;  //JSONObject representa um objeto json
            JSONArray JSONListaCoord; //JSONArray representa um array json
            JSONArray JSONCoord;
            JSONArray JSONCores;
            
            //lista de primitivos pontos
            if(JSONFigura.containsKey("pontos")){
                
                //lista de pontos
                JSONArray JSONListaPontos = (JSONArray) JSONFigura.get("pontos");
                tam = JSONListaPontos.size();
                for(int i = 0 ; i < tam ; i++){
                    //ponto
                    JSONPrimitivo = (JSONObject) JSONListaPontos.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //coordenadas
                    JSONCoord = (JSONArray) JSONPrimitivo.get("coord");
                    x = Double.parseDouble(JSONCoord.get(0).toString());
                    y = Double.parseDouble(JSONCoord.get(1).toString());
                    
                    //adicionar a figura
                    figura.armazenarPontoGr(obterCoordWindowX(x), obterCoordWindowY(y),  nome, esp, cor);
                }
            }
            
            //lista de primitivos retas
            if(JSONFigura.containsKey("retas")){
                
                //lista de retas
                JSONArray JSONListaRetas = (JSONArray) JSONFigura.get("retas");
                tam = JSONListaRetas.size();
                for(int i = 0 ; i < tam ; i++){
                    //reta
                    JSONPrimitivo = (JSONObject) JSONListaRetas.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //lista pontos da reta
                    JSONListaCoord = (JSONArray) JSONPrimitivo.get("pontos");
                    
                    //ponto 1
                    JSONCoord = (JSONArray) JSONListaCoord.get(0);
                    x1 = Double.parseDouble(JSONCoord.get(0).toString());
                    y1 = Double.parseDouble(JSONCoord.get(1).toString());
                    //ponto 2                    
                    JSONCoord = (JSONArray) JSONListaCoord.get(1);                
                    x2 = Double.parseDouble(JSONCoord.get(0).toString());
                    y2 = Double.parseDouble(JSONCoord.get(1).toString());
                    
                    //adicionar a figura
                    figura.armazenarRetaGr(obterCoordWindowX(x1), obterCoordWindowY(y1), obterCoordWindowX(x2), obterCoordWindowY(y2), nome, esp, cor);
                }
            }
            
            //lista de primitivos circulos
            if(JSONFigura.containsKey("circulos")){
                
                //lista de circulos
                JSONArray JSONListaCirculos = (JSONArray) JSONFigura.get("circulos");
                tam = JSONListaCirculos.size();
                for(int i = 0 ; i < tam ; i++){
                    //circulo
                    JSONPrimitivo = (JSONObject) JSONListaCirculos.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //ponto central do circulo
                    JSONCoord = (JSONArray) JSONPrimitivo.get("centro");
                    x = Double.parseDouble(JSONCoord.get(0).toString());
                    y = Double.parseDouble(JSONCoord.get(1).toString());
                    
                    //raio
                    raio = (Double.parseDouble(JSONPrimitivo.get("raio").toString()))*Constantes.XW_MAX;
                    
                    //adicionar a figura
                    figura.armazenarCirculoGr(obterCoordWindowX(x), obterCoordWindowY(y), (int)raio, nome, esp, cor);
                }
            }
            
            //lista de primitivos retangulos
            if(JSONFigura.containsKey("retangulos")){
                //lista de retangulos
                JSONArray JSONListaRetangulos = (JSONArray) JSONFigura.get("retangulos");
                tam = JSONListaRetangulos.size();
                for(int i = 0 ; i < tam ; i++){
                    //retangulo
                    JSONPrimitivo = (JSONObject) JSONListaRetangulos.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //lista pontos do retangulo
                    JSONListaCoord = (JSONArray) JSONPrimitivo.get("pontos");
                    //ponto 1
                    JSONCoord = (JSONArray) JSONListaCoord.get(0);
                    x1 = Double.parseDouble(JSONCoord.get(0).toString());
                    y1 = Double.parseDouble(JSONCoord.get(1).toString());
                    //ponto 2
                    JSONCoord = (JSONArray) JSONListaCoord.get(1);                
                    x2 = Double.parseDouble(JSONCoord.get(0).toString());
                    y2 = Double.parseDouble(JSONCoord.get(1).toString());
                    
                    //adicionar a figura
                    figura.armazenarRetanguloGr(obterCoordWindowX(x1), obterCoordWindowY(y1), obterCoordWindowX(x2), obterCoordWindowY(y2), nome, esp, cor);
                }
            }
            
            //lista de primitivos triangulos
            if(JSONFigura.containsKey("triangulos")){
                //lista de triangulos
                JSONArray JSONListaTriangulos = (JSONArray) JSONFigura.get("triangulos");
                tam = JSONListaTriangulos.size();
                for(int i = 0 ; i < tam ; i++){
                    //triangulo
                    JSONPrimitivo = (JSONObject) JSONListaTriangulos.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //lista pontos do triangulo
                    JSONListaCoord = (JSONArray) JSONPrimitivo.get("pontos");
                    
                    //ponto 1
                    JSONCoord = (JSONArray) JSONListaCoord.get(0);
                    x1 = Double.parseDouble(JSONCoord.get(0).toString());
                    y1 = Double.parseDouble(JSONCoord.get(1).toString());
                    //ponto 2
                    JSONCoord = (JSONArray) JSONListaCoord.get(1);                
                    x2 = Double.parseDouble(JSONCoord.get(0).toString());
                    y2 = Double.parseDouble(JSONCoord.get(1).toString());
                    //ponto 3
                    JSONCoord = (JSONArray) JSONListaCoord.get(2);                
                    x3 = Double.parseDouble(JSONCoord.get(0).toString());
                    y3 = Double.parseDouble(JSONCoord.get(1).toString());
                    
                    //adicionar a figura
                    figura.armazenarTrianguloGr(obterCoordWindowX(x1), obterCoordWindowY(y1), obterCoordWindowX(x2), obterCoordWindowY(y2), 
                                                obterCoordWindowX(x3), obterCoordWindowY(y3), nome, esp, cor);
                }
            }
            //lista de primitivos poligonos
            if(JSONFigura.containsKey("poligonos")){
                
                List<Integer> listaCoord; //lista de coordenadas sera passada ao construtor do poligono
                JSONArray JSONListaPoligonos = (JSONArray) JSONFigura.get("poligonos"); //lista de poligonos
                tam = JSONListaPoligonos.size();
                for(int i = 0 ; i < tam ; i++){
                    listaCoord = new ArrayList();
                    //poligono
                    JSONPrimitivo = (JSONObject) JSONListaPoligonos.get(i);
                    //nome
                    nome = (String)JSONPrimitivo.get("nome");
                    //cor
                    JSONCores = (JSONArray) JSONPrimitivo.get("cor");
                    cor = new Color(Integer.parseInt(JSONCores.get(0).toString()),  
                                    Integer.parseInt(JSONCores.get(1).toString()),  
                                    Integer.parseInt(JSONCores.get(2).toString()));
                    //espessura
                    esp = Integer.parseInt(JSONPrimitivo.get("esp").toString());
                    
                    //lista pontos do poligono
                    JSONListaCoord = (JSONArray) JSONPrimitivo.get("pontos");
                    tamPol = (JSONListaCoord.size())-1;
                    
                    //insere duas vezes cada ponto, para que a lista represente todas as retas que formam o poligono
                    
                    JSONCoord = (JSONArray) JSONListaCoord.get(tamPol);
                    //ponto inicial do poligono
                    x1 = Double.parseDouble(JSONCoord.get(0).toString());
                    y1 = Double.parseDouble(JSONCoord.get(1).toString()); 
                    listaCoord.add(obterCoordWindowX(x1));
                    listaCoord.add(obterCoordWindowY(y1));
                    for(int j = 0 ; j < tamPol ; j++){
                        //pontos do poligono
                        JSONCoord = (JSONArray) JSONListaCoord.get(j);
                        x = Double.parseDouble(JSONCoord.get(0).toString());
                        y = Double.parseDouble(JSONCoord.get(1).toString());
                        listaCoord.add(obterCoordWindowX(x));
                        listaCoord.add(obterCoordWindowY(y));
                        listaCoord.add(obterCoordWindowX(x));
                        listaCoord.add(obterCoordWindowY(y));
                    }
                    //adiciona novamente ponto inicial do poligono
                    listaCoord.add(obterCoordWindowX(x1));
                    listaCoord.add(obterCoordWindowY(y1));
                    //adicionar a figura
                    figura.armazenarPoligonoGr(listaCoord, nome, esp, cor);
                }
            }
            
        }catch (org.json.simple.parser.ParseException e){
            e.printStackTrace();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "o arquivo não existe");
        }catch(NullPointerException e){
            e.printStackTrace();
        }catch(IOException e){
           e.printStackTrace();
        }
        
        return figura;
    }

    //transforma a coordenada x de normalizada para as coordenadas de janela
    private static int obterCoordWindowX(double xn){
        double x;
        x = xn*(Constantes.XW_MAX - Constantes.XW_MIN) + Constantes.XW_MIN;
        return (int) x;
    }
    
    //transforma a coordenada y de normalizada para as coordenadas de janela
    private static int obterCoordWindowY(double yn){
        double y;
        y = yn*(Constantes.YW_MAX - Constantes.YW_MIN) + Constantes.YW_MIN;
        return (int) y;
    }
}
