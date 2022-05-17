package Frontend;


import Frontend.SubPanelAdmin.PanelAdmin;
import Frontend.SubPanelCajero.PanelCajero;
import Frontend.SubPanelGerente.PanelGerente;
import Frontend.SubPanelRecepcionista.PanelRecepcionista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//Clase padre que maneja todas las pestañas y la comunicacion entre los diferentes componentes
public class Cliente extends JFrame{

    private Container box;
    private Toolkit herramienta;
    private int sizeX,sizeY;
    private String usuario,contrasena;
    private JPanel[] panel;
    private int actual,priv;

    //Constructor de la clase principal del programa
    public Cliente(){
        super("El Descanso");

        //Coge el tamaño de la pantalla para ajustar las dimenciones del programa
        herramienta = Toolkit.getDefaultToolkit();
        this.sizeX = (int)(herramienta.getScreenSize().getWidth());
        this.sizeY = (int)(herramienta.getScreenSize().getHeight());

        //Valores iniciales del programa y cada pestaña nula hasta que se vaya ha usar
        panel = new JPanel[]{null,null,null,null,null};
        //al inicio del programa no tiene ninguna pestaña por eso la pestaña actual es menor a 0
        actual = -1;
        //al no estar la sesion iniciada tiene 0 privilegios
        priv = 0;

        //se inserta el fondo del programa y el estilo
        setContentPane(new JLabel(new ImageIcon("Imagenes/Background.jpg")));
        box = getContentPane();
        box.setLayout(null);

        //actualizamos a iniciar la pestaña Login.
        try {
            actualizar();
        } catch(Exception error){
            System.out.println(error.getMessage());
        }

        //se inserta el logo de programa y sus caracteristicas.
        ImageIcon logo=new ImageIcon("Imagenes/Cloud.png");
        setIconImage(logo.getImage());
        setResizable(false);
        setVisible(true);
        //se centra la pantalla automaticamente.
        setLocationRelativeTo(null);
    }

    //le pasan un entero del 0 a 4 para inicializar un tipo de pestaña
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
        }else if(priv == 4 && tipo != priv){

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
            setSize((panel[actual].getWidth()+ 10),(panel[actual].getHeight() + 10));
            box.add(panel[actual]);
            setLocationRelativeTo(null);
        }else if(panel[actual] == null)
        {
            throw new Exception("Panel vacio, Posiblemente no tienes permisos");
        }
    }


    public void iniciarSesion(String user,String cont){

        this.usuario = user;
        this.contrasena = cont;
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
