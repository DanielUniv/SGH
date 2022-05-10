package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavegacionBar extends JPanel implements ActionListener {

    private JButton[] botones;

    public NavegacionBar(int ancho){

        setLayout(new FlowLayout());


        setAncho(ancho);
        setVisible(true);
    }

    public void setAncho(int nuevo){
        setSize(nuevo - 10,40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}