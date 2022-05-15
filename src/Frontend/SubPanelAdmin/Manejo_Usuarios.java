package Frontend.SubPanelAdmin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_Usuarios extends JPanel implements ActionListener{

    private PanelAdmin admin;
    private int sizeX,sizeY;
    private JLabel tex1,tex2,tex3,tex4;
    private JTextField casilla1,casilla2,casilla3,casilla4;
    private JButton registrar,buscar,eliminar,ayuda;

    public Manejo_Usuarios(int sizex,int sizey,PanelAdmin admin){
        setLayout(null);
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);

        this.admin = admin;

        tex1 = new JLabel("Nombre:");
        tex2 = new JLabel("Cargo:");
        tex3 = new JLabel("Usuario:");
        tex4 = new JLabel("Contraseña");

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


        tex1.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.05),(int)(sizeX * 0.08),(int)(sizeY * 0.05));
        tex2.setBounds((int)(sizeX * 0.05),(int)(sizeY * 0.15),(int)(sizeX * 0.08),(int)(sizeY * 0.05));
        tex3.setBounds(300,5,100,50);
        tex4.setBounds(300,5,100,50);
        casilla1.setBounds((int)(sizeX * 0.12),(int)(sizeY * 0.05),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla2.setBounds((int)(sizeX * 0.12),(int)(sizeY * 0.15),(int)(sizeX * 0.09),(int)(sizeY * 0.05));
        casilla3.setBounds(300,5,100,50);
        casilla4.setBounds(300,5,100,50);
        registrar.setBounds(300,5,100,50);
        buscar.setBounds(300,5,100,50);
        eliminar.setBounds(300,5,100,50);
        ayuda.setBounds(300,5,100,50);


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
        setBorder(new LineBorder(Color.RED));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
