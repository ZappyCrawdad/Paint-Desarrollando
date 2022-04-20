/*
██████╗░██╗░░░██╗██╗  ███████╗██╗░░░░░██╗  ████████╗░█████╗░██╗░░░██╗░█████╗░██████╗░
██╔══██╗╚██╗░██╔╝╚═╝  ██╔════╝██║░░░░░██║  ╚══██╔══╝██╔══██╗██║░░░██║██╔══██╗██╔══██╗
██████╦╝░╚████╔╝░░░░  █████╗░░██║░░░░░██║  ░░░██║░░░██║░░██║╚██╗░██╔╝███████║██████╔╝
██╔══██╗░░╚██╔╝░░░░░  ██╔══╝░░██║░░░░░██║  ░░░██║░░░██║░░██║░╚████╔╝░██╔══██║██╔══██╗
██████╦╝░░░██║░░░██╗  ███████╗███████╗██║  ░░░██║░░░╚█████╔╝░░╚██╔╝░░██║░░██║██║░░██║
╚═════╝░░░░╚═╝░░░╚═╝  ╚══════╝╚══════╝╚═╝  ░░░╚═╝░░░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝
 */
package DibujoApp;

import static java.awt.Color.green;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    Points p = null;
    JPanel panelm;
    JButton boton1;

    public Ventana() {
        p = new Points();

        setTitle("Draw");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        iniciar();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciar() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        panelm = new JPanel();
        panelm.setBounds(0, 0, 700, 500);
        panelm.setBackground(green);
        panel.setLayout(null);
        panel.add(panelm);

        boton1 = new JButton("Pincel");
        boton1.setBounds(710, 5, 70, 40);
        panel.add(boton1);
    }

    public void mouseDragged(MouseEvent evt) {
        
        System.out.println("arastrando");
        p.GuardarPuntos(evt.getX(), evt.getY());
        Dibujar();
    }
    
    public void Dibujar(){
        
        for(int i = 0; i < p.listax().size(); i++){
            int x = p.listax().get(i);
            int y = p.listay().get(i);
            panelm.getGraphics().fillOval(x, y, 20, 20);
        }
    }
}
