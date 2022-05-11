package Frontend;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.KeyStore;

public class Cliente extends JFrame implements ActionListener {

    private Conexion conet;
    private Container box;
    private LayoutStyle estyle;
    private JPanel[] paneles = new JPanel[8];
    private NavegacionBar menuBar;
    private int actual = -1;
    private int priv = 0;

    public Cliente()
    {
        super("El Descanso");

        conet = new Conexion();
        setContentPane(new JLabel(new ImageIcon("Imagenes/Background.jpg")));

        box = getContentPane();
        box.setLayout(new BorderLayout(5,5));

        initPanel(0);
        try {
            actualizar(0);
        } catch(Exception error){
            System.out.println(error.getMessage());
        }


        ImageIcon logo=new ImageIcon("Imagenes/Cloud.png");
        setIconImage(logo.getImage());
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }


    private void initPanel(int tipo){

        switch(tipo){
            case 0:
                paneles[0] = new Login();
                break;
            case 1:
                paneles[1] = new PanelRecepcionista();
                break;
            case 2:
                paneles[2] = new PanelCajero();
                break;
            case 3:
                paneles[3] = new PanelGerente();
                break;
            case 4:
                paneles[4] = new PanelAdmin();
                break;
        }

    }

    private void actualizar(int a) throws Exception {
        if(actual >= 0){
            box.remove(actual);
        }
        actual = a;

        if(paneles[actual] != null)
        {
            box.add(paneles[actual],BorderLayout.CENTER,actual);
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
}
