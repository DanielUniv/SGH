package Frontend.SubPanelAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_Reservas extends JPanel implements ActionListener {

    private PanelAdmin admin;
    private int sizeX,sizeY;
    private JLabel tex1,tex2,tex3,tex4,tex5,tex6;
    private JTextField casilla1,casilla2,casilla3,casilla4,casilla5,casilla6;
    private JButton registrar,buscar,eliminar,ayuda;

    public Manejo_Reservas(int sizex,int sizey,PanelAdmin admin){
        setLayout(null);
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);

        this.admin = admin;

        tex1 = new JLabel("Numero Reserva:");
        tex2 = new JLabel("Num Habitacion:");
        tex3 = new JLabel("Id Cliente:");
        tex4 = new JLabel("Fecha Entrada:");
        tex5 = new JLabel("Días:");
        tex6 = new JLabel("Valor Total");

        casilla1 = new JTextField();
        casilla2 = new JTextField();
        casilla3 = new JTextField();
        casilla4 = new JTextField();
        casilla5 = new JTextField();
        casilla6 = new JTextField();

        registrar = new JButton("Registrar");
        buscar = new JButton("Buscar");
        eliminar = new JButton("Eliminar");
        ayuda = new JButton("Ayuda");

        registrar.addActionListener(this);
        buscar.addActionListener(this);
        eliminar.addActionListener(this);
        ayuda.addActionListener(this);


        tex1.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.05),(int)(sizeX * 0.12),(int)(sizeY * 0.05));
        tex2.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.15),(int)(sizeX * 0.1),(int)(sizeY * 0.05));
        tex3.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.25),(int)(sizeX * 0.1),(int)(sizeY * 0.05));
        tex4.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.35),(int)(sizeX * 0.1),(int)(sizeY * 0.05));
        tex5.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.45),(int)(sizeX * 0.1),(int)(sizeY * 0.05));
        tex6.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.55),(int)(sizeX * 0.1),(int)(sizeY * 0.05));
        casilla1.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.05),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla2.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.15),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla3.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.25),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla4.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.35),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla5.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.45),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla6.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.55),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        buscar.setBounds(300,80,100,30);
        eliminar.setBounds(300,120,100,30);
        registrar.setBounds(300,160,100,30);
        ayuda.setBounds(410,120,100,30);



        add(tex1);
        add(tex2);
        add(tex3);
        add(tex4);
        add(tex5);
        add(tex6);
        add(casilla1);
        add(casilla2);
        add(casilla3);
        add(casilla4);
        add(casilla5);
        add(casilla6);
        add(registrar);
        add(buscar);
        add(eliminar);
        add(ayuda);


        setOpaque(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
