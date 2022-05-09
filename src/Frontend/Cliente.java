package Frontend;

import javax.swing.*;
import java.awt.*;
import java.security.KeyStore;

public class Cliente extends JFrame {

    private Container box;
    private LayoutStyle estyle;
    private Login login;
    private Navegacion menu;
    private Registro_Usuario registro;
    private Reserva_y_Registro reserva;


    public Cliente()
    {
        super("El Descanso");

        box = getContentPane(this);
        box.setLayout(new BorderLayout());



        setSize()
        setResizable(false);
        setVisible(true);
    }

    private void Resize(){

    }

    public static void main(String[] args){
        Cliente gui = new Cliente;
    }
}
