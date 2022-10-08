package poligono;
import java.util.List;
import java.util.ArrayList;
import reta.Reta;

public class Poligono {
    //armazena as retas do poligono
    List<Reta> listaRetas = new ArrayList<Reta>();
    
    //construtor que recebe uma lista de coordenadas que vao compor o poligono
    public Poligono(List<Integer> coord){
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0; 
        
        int aux, tam = coord.size();
        
        List<Reta> retas = new ArrayList<Reta>();
        /*devem ser armazenadas todas as coordenadas de cada reta, caso falte qualquer 
        uma de suas quatro coordenadas(x1, y1, x2, y2), a reta nao sera adicionada*/
        for(int i = 0 ; i < tam ; i++){
            aux = i%4;
            switch(aux){
                case 0:
                    x1 = coord.get(i);
                    break;
                case 1:
                    y1 = coord.get(i);
                    break;
                case 2:
                    x2 = coord.get(i);
                    break;
                case 3:
                    y2 = coord.get(i);
                    retas.add(new Reta(x1, y1, x2, y2)); //armazena a reta do poligono
                    break;
                default:
                    break;
            }
        }
        setListaRetas(retas);
    }
    //setters e getters
    public void setListaRetas(List retas){
        this.listaRetas = retas;
    }
    
    public List getListaRetas(){
        return this.listaRetas;
    }
    
    public String toString(){
        String s;
        List<Reta> r = getListaRetas();
        int tam = r.size();
        s = "poligono: ";
        for(int i = 0; i < tam ; i++){
            s = s + "reta " + i + " = " + r.get(i).toString();
        }
        return s;
    }
}
