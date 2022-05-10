package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.KeyStore;

public class Cliente extends JFrame implements ActionListener, KeyListener, ComponentListener {

    private Conexion conet;
    private Container box;
    private LayoutStyle estyle;
    private JPanel[] paneles = new JPanel[8];
    private NavegacionBar menuBar;
    private int actual = -1;
    private int priv = 4;


    public Cliente()
    {
        super("El Descanso");

        conet = new Conexion();
        box.add(new JButton("Reload"),BorderLayout.NORTH);

        box = getContentPane();
        box.setLayout(new BorderLayout(5,5));

        initPanel(0);
        try {
            actualizar(0);
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        setResizable(false);

        ImageIcon logo=new ImageIcon("Imagenes\\Cloud.png");
        setIconImage(logo.getImage());

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void privilegios(){

    }

    private void initPanel(int tipo){

        switch(tipo){
            case 0:
                paneles[0] = new Login();
                break;
            case 1:
                paneles[1] = new Navegacion();
                break;
            case 2:
                paneles[2] = new Reserva_y_Registro();
                break;
            case 3:
                paneles[3] = new Consulta();
                break;
            case 4:
                paneles[4] = new Caja();
                break;
            case 5:
                paneles[5] = new Estadistica();
                break;
            case 6:
                paneles[6] = new Modificacion();
                break;
            case 7:
                paneles[7] = new Registro_Usuario();
                break;

        }

    }

    private void actualizar(int a) throws Exception {
        if(actual >= 0){
            box.remove(paneles[actual]);
        }
        actual = a;

        if(paneles[actual] != null)
        {
            box.add(paneles[actual],BorderLayout.CENTER);
        }else
        {
            throw new Exception("Panel vacio, Posiblemente no tienes permisos");
        }


        setSize(paneles[actual].getWidth()+ 15,paneles[actual].getHeight()+10);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        Cliente gui = new Cliente();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
