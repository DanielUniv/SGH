package Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_Usuarios extends JPanel implements ActionListener{

    private int sizeX,sizeY;

    public Manejo_Usuarios(int sizex,int sizey){
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);



        setOpaque(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
