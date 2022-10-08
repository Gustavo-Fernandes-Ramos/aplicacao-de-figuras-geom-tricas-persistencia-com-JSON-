package poligono;
import java.util.List;
import java.util.ArrayList;
import reta.Reta;

public class testaPoligono {

    
    public static void main(String args[]) {
        
        int tam;
        List<Integer> coord = new ArrayList<Integer>();
        
        coord.add(10); coord.add(12); coord.add(15); coord.add(17);
        coord.add(13); coord.add(14); coord.add(20); coord.add(2);
        coord.add(20); coord.add(2); coord.add(43); coord.add(3);
        
        Poligono p = new Poligono(coord);
        
        System.out.println(p);
    }

}
