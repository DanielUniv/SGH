package Frontend;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cliente extends JFrame{

    private Container box;
    private Toolkit herramienta;
    private int sizeX,sizeY;
    private String usuario;
    private String contrasena;
    private JPanel[] panel;
    private int actual;
    private int priv;


    public Cliente()
    {
        super("El Descanso");

        herramienta = Toolkit.getDefaultToolkit();
        this.sizeX = (int)(herramienta.getScreenSize().getWidth());
        this.sizeY = (int)(herramienta.getScreenSize().getHeight());

        panel = new JPanel[5];
        actual = -1;
        priv = 4;

        setContentPane(new JLabel(new ImageIcon("Imagenes/Background.jpg")));
        box = getContentPane();
        box.setLayout(null);

        try {
            actualizar();
        } catch(Exception error){
            System.out.println(error.getMessage());
        }


        ImageIcon logo=new ImageIcon("Imagenes/Cloud.png");
        setIconImage(logo.getImage());
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }


    private void initPanel(int tipo) throws Exception {

        if (tipo == priv){
            switch(tipo){
                case 0:
                    panel[0] = new Login(sizeX,sizeY,this);
                    break;
                case 1:
                    panel[1] = new PanelRecepcionista(sizeX,sizeY,false);
                    break;
                case 2:
                    panel[2] = new PanelCajero(sizeX,sizeY,false);
                    break;
                case 3:
                    panel[3] = new PanelGerente(sizeX,sizeY,false);
                    break;
                case 4:
                    panel[4] = new PanelAdmin(sizeX,sizeY,this);
                    break;
                default:
            }
        }else{
            throw new Exception("No tienes los pribilegios para esas funciones");
        }
    }

    private void actualizar() throws Exception {
        if(actual >= 0){
            panel[actual].setVisible(false);
            box.remove(panel[actual]);
            panel[actual] = null;
        }

        actual = priv;
        initPanel(actual);

        if(panel[actual] != null)
        {
            panel[actual].setBounds(5,5,panel[actual].getWidth(),panel[actual].getHeight());
            setSize(panel[actual].getWidth()+ 10,panel[actual].getHeight()+10);
            box.add(panel[actual]);
            setLocationRelativeTo(null);
        }else if(panel[actual] == null)
        {
            throw new Exception("Panel vacio, Posiblemente no tienes permisos");
        }
    }

    public void usuarioListo(String user){
        Login a = (Login) panel[0];
        a.setSalt("hola");
        this.usuario = user;
    }

    public void contrasenaListo(String cont){
        this.contrasena = cont;
        iniciarSesion();
    }

    public void iniciarSesion(){
            priv = 4;
            try {
                actualizar();
            }catch (Exception e){
                System.out.println(e);
            }
    }

    public void cerrarSesion(){
        usuario = "";
        contrasena = "";
        priv = 0;
        try {
            actualizar();
        }catch (Exception e){
            System.out.println("Error entre paneles");
        }
    }

    public static void main(String[] args){
        Cliente gui = new Cliente();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
