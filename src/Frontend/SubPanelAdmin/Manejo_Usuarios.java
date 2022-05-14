package Frontend.SubPanelAdmin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_Usuarios extends JPanel implements ActionListener{

    private PanelAdmin admin;
    private int sizeX,sizeY;

    public Manejo_Usuarios(int sizex,int sizey,PanelAdmin admin){
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);

        this.admin = admin;


        setOpaque(true);
        setVisible(true);
        setBorder(new LineBorder(Color.RED));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
