package Frontend.SubPanelAdmin;
import Frontend.Cliente;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin extends JPanel implements ActionListener {

    private Cliente referencia;
    private int sizeX,sizeY;
    private JButton logout;
    private JComboBox<String> funciones;
    private String[] usertype ;
    private JButton back;
    private int panelactual;
    private JPanel[] subPanel;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6;


    public PanelAdmin(int sizex,int sizey,Cliente referencia){

        setLayout(null);
        this.sizeX = (int) (sizex * 0.80);
        this.sizeY = (int) (sizey * 0.80);
        setSize(sizeX,sizeY);

        this.referencia = referencia;
        subPanel = new JPanel[]{null,null,null,null,null,null};
        panelactual = -1;

        logout = new JButton();
        logout.setIcon(loadIcon(0));
        logout.setToolTipText("Cerrar Sesion");

        usertype = new String[]{"Administrador","Gerente","Cajero","Recepcionista"};
        funciones = new JComboBox<>(usertype);

        back = new JButton();
        back.setIcon(loadIcon(1));
        back.setEnabled(false);

        boton1 = new JButton("Usuarios");
        boton2 = new JButton("Clientes");
        boton3 = new JButton("Habitaciones");
        boton4 = new JButton("Reservas");
        boton5 = new JButton("Servicios");
        boton6 = new JButton("Ingresos");


        logout.addActionListener(this);
        funciones.addActionListener(this);
        back.addActionListener(this);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);



        logout.setBounds((int)(sizeX * 0.8995),(int) (sizeY * 0.0724),(int)(sizeX * 0.0275),(int)(sizeY * 0.044));
        funciones.setBounds((int)(sizeX * 0.7804),(int)(sizeY * 0.0724),(int)(sizeX * 0.1191),(int)(sizeY * 0.044));
        back.setBounds((int)(sizeX * 0.073),(int) (sizeY * 0.0724),(int)(sizeX * 0.0275),(int)(sizeY * 0.044));
        boton1.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.30),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton2.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.45),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton3.setBounds((int)(sizeX * 0.15),(int)(sizeY * 0.60),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton4.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.30),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton5.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.45),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));
        boton6.setBounds((int)(sizeX * 0.35),(int)(sizeY * 0.60),(int)(sizeX * 0.1391),(int)(sizeY * 0.088));

        add(logout);
        add(funciones);
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
        setBorder(new LineBorder(Color.RED));
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
                ruta ="Imagenes/Back.png";
        }
        ImageIcon icon = new ImageIcon(ruta);
        icon.setImage(icon.getImage().getScaledInstance((int)(sizeX * 0.0275),(int)(sizeY * 0.044), Image.SCALE_SMOOTH));
        return icon;
    }

    private void initSubPanel(int tipo)
    {
        switch (tipo){
            case 0:
                subPanel[tipo] = new Manejo_Usuarios((int)(sizeX *0.854 ),(int)(sizeY * 0.699),this);
        }

    }

    private void actualizarSubPabel(int cambio){
        if(panelactual >= 0){
            subPanel[panelactual].setVisible(false);
            remove(subPanel[panelactual]);
            subPanel[panelactual] = null;
        }

        panelactual = cambio;
        initSubPanel(panelactual);

        try {
            if (subPanel[panelactual] != null && panelactual >= 0) {
                subPanel[panelactual].setVisible(false);
                subPanel[panelactual].setBounds((int)(sizeX * 0.073),(int) (sizeY * 0.1604),(int)(sizeX *0.854),(int)(sizeY * 0.6792));
                add(subPanel[panelactual]);
                subPanel[panelactual].setVisible(true);
            } else if(panelactual == -1){
                mostrarBotones();
            }else if (subPanel[panelactual] == null) {
                throw new Exception("Panel vacio, Posiblemente no tienes permisos");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            ocultarBotones();
            back.setEnabled(true);
            actualizarSubPabel(0);
        }else if(e.getSource() == back)
        {
            back.setEnabled(false);
            mostrarBotones();
            actualizarSubPabel(-1);
        }

        if(e.getSource() == logout){
            referencia.cerrarSesion();
        }
    }
}
