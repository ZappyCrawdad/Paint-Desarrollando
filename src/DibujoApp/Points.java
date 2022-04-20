package DibujoApp;

import java.util.LinkedList;

public class Points {

    LinkedList<Integer> PuntosX = new LinkedList();
    LinkedList<Integer> PuntosY = new LinkedList();

    public void GuardarPuntos(int x, int y) {

        PuntosX.add(x);
        PuntosY.add(y);
    }

    public LinkedList<Integer> listax() {

        return PuntosX;
    }

    public LinkedList<Integer> listay() {

        return PuntosY;
    }
}
