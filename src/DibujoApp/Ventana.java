/*
██████╗░██╗░░░██╗██╗  ███████╗██╗░░░░░██╗  ████████╗░█████╗░██╗░░░██╗░█████╗░██████╗░
██╔══██╗╚██╗░██╔╝╚═╝  ██╔════╝██║░░░░░██║  ╚══██╔══╝██╔══██╗██║░░░██║██╔══██╗██╔══██╗
██████╦╝░╚████╔╝░░░░  █████╗░░██║░░░░░██║  ░░░██║░░░██║░░██║╚██╗░██╔╝███████║██████╔╝
██╔══██╗░░╚██╔╝░░░░░  ██╔══╝░░██║░░░░░██║  ░░░██║░░░██║░░██║░╚████╔╝░██╔══██║██╔══██╗
██████╦╝░░░██║░░░██╗  ███████╗███████╗██║  ░░░██║░░░╚█████╔╝░░╚██╔╝░░██║░░██║██║░░██║
╚═════╝░░░░╚═╝░░░╚═╝  ╚══════╝╚══════╝╚═╝  ░░░╚═╝░░░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝
 */
package DibujoApp;

import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    Points p = null;
    JPanel panelm;
    JButton btnPincel;
    JMenuBar barra;
    JMenu archivo, escolor;
    JMenuItem nuevo, guardar, abrir, chcolor;
    JColorChooser colorChooser = new JColorChooser();
    
    // El color del pincel, por defecto se inicializa en negro
    Color color = BLACK;
    
    // La variable bandera, sirve para no redibujar puntos del arreglo en el
    // método Dibujar(), piense en ella como unas 'migas de pan'.
    int bandera = 0;
        
    public Ventana() {
        p = new Points();

        setTitle("Draw");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       barra = new JMenuBar();
       nuevo = new JMenu("Nuevo");
       escolor = new JMenu("Cambiar Color");
       chcolor = new JMenuItem("Color");
       archivo = new JMenu("Archivo");
       guardar = new JMenuItem("Guardar");
       abrir = new JMenuItem("Abrir");
       add(barra);
       barra.add(archivo);
       barra.add(escolor);
       escolor.add(chcolor);
       archivo.add(guardar);
       archivo.add(abrir);
       setJMenuBar(barra);//Para asociar al JFrame
       iniciar();
        addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent evt) {
                p.GuardarPuntos(evt.getX(), evt.getY());
                p.GuardarColor(color);
                System.out.println(evt.getX() + " " + evt.getY());
                Dibujar(color);
            }
        });
        añadirListeners();
    }

    private void iniciar() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        panelm = new JPanel();
        panelm.setBounds(0, 0, 700, 500);
        panelm.setBackground(WHITE);
        panel.setLayout(null);
        panel.add(panelm);

        btnPincel = new JButton("Pincel");
        btnPincel.setBounds(710, 5, 70, 40);
        panel.add(btnPincel);
    }

    public void Dibujar(Color color){
        Graphics2D g2d = (Graphics2D) panelm.getGraphics();
        int size = 20;
        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        // El ciclo de dibujado empieza donde se quedó, en lugar de empezar
        // siempre desde cero.
        
        for(int i = bandera; i < p.listax().size(); i++){
            int x = p.listax().get(i);
            int y = p.listay().get(i);
            g2d.fillOval(x, y-size*2, size, size);
            
            // Se aumenta el valor de la variable bandera
            bandera++;
        }
    }
    ActionListener oyenteDeAccion = new ActionListener(){
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==nuevo){
            System.out.println("Nuevo");
        }
        
        if(e.getSource()==abrir){
            System.out.println("Abriendo");
            File archivoSeleccionado;
            JFileChooser seleccionarArchivo;
            seleccionarArchivo = new JFileChooser();
            seleccionarArchivo.showOpenDialog(null);
            archivoSeleccionado = seleccionarArchivo.getSelectedFile();
            System.out.println("El archivo seleccionado es: " + archivoSeleccionado);
            System.out.println("Path actual: " + seleccionarArchivo.getCurrentDirectory());
        }
        
        if(e.getSource()==guardar){
            System.out.println("Guardando");  
        }
        
        if(e.getSource() == chcolor){
            System.out.println("Cambiar color");
            color = JColorChooser.showDialog(null, "Elige un color", Color.RED);
        }
    }
    };
    
    public void guardar(){
        
            
    }
    
    private void añadirListeners(){
        nuevo.addActionListener(oyenteDeAccion);
        abrir.addActionListener(oyenteDeAccion);
        guardar.addActionListener(oyenteDeAccion);
        chcolor.addActionListener(oyenteDeAccion);
    }

}
