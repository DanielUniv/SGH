package Frontend.SubPanelAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_Habitaciones extends JPanel implements ActionListener {

    private PanelAdmin admin;
    private int sizeX,sizeY;
    private JLabel tex1,tex2,tex3,tex4;
    private JTextField casilla1,casilla2,casilla3,casilla4;
    private JButton registrar,buscar,eliminar,ayuda;

    public Manejo_Habitaciones (int sizex,int sizey,PanelAdmin admin){
        setLayout(null);
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);

        this.admin = admin;

        tex1 = new JLabel("Numero habitacion:");
        tex2 = new JLabel("Tipo:");
        tex3 = new JLabel("Precio Habitacion:");
        tex4 = new JLabel("Estado:");

        casilla1 = new JTextField();
        casilla2 = new JTextField();
        casilla3 = new JTextField();
        casilla4 = new JTextField();

        registrar = new JButton("Registrar");
        buscar = new JButton("Buscar");
        eliminar = new JButton("Eliminar");
        ayuda = new JButton("Ayuda");

        registrar.addActionListener(this);
        buscar.addActionListener(this);
        eliminar.addActionListener(this);
        ayuda.addActionListener(this);


        tex1.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.05),(int)(sizeX * 0.12),(int)(sizeY * 0.05));
        tex2.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.13),(int)(sizeX * 0.08),(int)(sizeY * 0.05));
        tex3.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.21),(int)(sizeX * 0.13),(int)(sizeY * 0.05));
        tex4.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.29),(int)(sizeX * 0.08),(int)(sizeY * 0.05));
        casilla1.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.05),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla2.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.13),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla3.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.21),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla4.setBounds((int)(sizeX * 0.18),(int)(sizeY * 0.29),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        buscar.setBounds(300,30,100,30);
        eliminar.setBounds(300,70,100,30);
        registrar.setBounds(300,110,100,30);
        ayuda.setBounds(410,70,100,30);



        add(tex1);
        add(tex2);
        add(tex3);
        add(tex4);
        add(casilla1);
        add(casilla2);
        add(casilla3);
        add(casilla4);
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
