package Frontend;

import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin extends JPanel implements ActionListener {

    private Cliente referencia;
    private int sizeX,sizeY;
    private JButton logout;
    private JComboBox<String> funciones;
    private String[] usertype ;
    private JButton reload,back;
    private int subpanel;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6;


    public PanelAdmin(int sizex,int sizey,Cliente referencia){

        setLayout(null);
        this.sizeX = (int) (sizex * 0.80);
        this.sizeY = (int) (sizey * 0.90);
        setSize(sizeX,sizeY);

        this.referencia = referencia;

        logout = new JButton();
        logout.setIcon(loadIcon(0));
        logout.setToolTipText("Cerrar Sesion");

        usertype = new String[]{"Administrador","Gerente","Cajero","Recepcionista"};
        funciones = new JComboBox<>(usertype);

        reload = new JButton();
        reload.setIcon(loadIcon(1));
        reload.setEnabled(false);

        back = new JButton();
        back.setIcon(loadIcon(2));
        back.setEnabled(false);

        boton1 = new JButton("Usuarios");
        boton2 = new JButton("Clientes");
        boton3 = new JButton("Habitaciones");
        boton4 = new JButton("Reservas");
        boton5 = new JButton("Servicios");
        boton6 = new JButton("Ingresos");


        logout.addActionListener(this);
        funciones.addActionListener(this);
        reload.addActionListener(this);
        back.addActionListener(this);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);



        logout.setBounds((int)(sizeX * 0.927),(int) (sizeY * 0.0724),(int)(sizeX * 0.0275),(int)(sizeY * 0.044));
        funciones.setBounds((int)(sizeX * 0.80),(int)(sizeY * 0.0724),(int)(sizeX * 0.1191),(int)(sizeY * 0.044));
        reload.setBounds((int)(sizeX * 0.1005),(int) (sizeY * 0.0724),(int)(sizeX * 0.0275),(int)(sizeY * 0.044));
        back.setBounds((int)(sizeX * 0.073),(int) (sizeY * 0.0724),(int)(sizeX * 0.0275),(int)(sizeY * 0.044));
        boton1.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.30),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton2.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.45),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton3.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.60),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton4.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.30),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton5.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.45),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton6.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.60),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));

        add(logout);
        add(funciones);
        add(reload);
        add(back);
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);

        setOpaque(false);
        setBackground(null);
        setVisible(true);
    }


    private void mostrarBotones(){
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        boton1.setVisible(true);
        boton2.setVisible(true);
        boton3.setVisible(true);
        boton4.setVisible(true);
        boton5.setVisible(true);
        boton6.setVisible(true);
    }

    private void ocultarBotones(){
        boton1.setVisible(false);
        boton2.setVisible(false);
        boton3.setVisible(false);
        boton4.setVisible(false);
        boton5.setVisible(false);
        boton6.setVisible(false);
        remove(boton1);
        remove(boton2);
        remove(boton3);
        remove(boton4);
        remove(boton5);
        remove(boton6);
    }

    private Icon loadIcon(int imagen){
        String ruta = "";
        switch (imagen){
            case 0:
                ruta ="Imagenes/Out.png";
                break;
            case 1:
                ruta ="Imagenes/Reload.png";
                break;
            case 2:
                ruta ="Imagenes/Back.png";
        }
        ImageIcon icon = new ImageIcon(ruta);
        icon.setImage(icon.getImage().getScaledInstance((int)(sizeX * 0.0275),(int)(sizeY * 0.044), Image.SCALE_SMOOTH));
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            ocultarBotones();
            back.setEnabled(true);
        }else if(e.getSource() == back)
        {
            back.setEnabled(false);
            mostrarBotones();
        }

        if(e.getSource() == logout){
            referencia.cerrarSesion();
        }
    }
}
