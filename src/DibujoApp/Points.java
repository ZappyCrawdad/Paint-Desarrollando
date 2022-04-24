package DibujoApp;

import java.awt.Color;
import java.util.LinkedList;

public class Points {

    LinkedList<Integer> PuntosX = new LinkedList();
    LinkedList<Integer> PuntosY = new LinkedList();
    LinkedList<Color> Colores = new LinkedList();

    public void GuardarPuntos(int x, int y) {

        PuntosX.add(x);
        PuntosY.add(y);
    }
    
    public void GuardarColor(Color color){
        Colores.add(color);
    }

    public LinkedList<Integer> listax() {

        return PuntosX;
    }

    public LinkedList<Integer> listay() {

        return PuntosY;
    }
    
    public LinkedList<Color> listaColor(){
        return Colores;
    }
}
