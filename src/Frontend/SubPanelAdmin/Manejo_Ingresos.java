package Frontend.SubPanelAdmin;

import javax.swing.*;

public class Manejo_Ingresos extends JPanel {

    private PanelAdmin admin;
    private int sizeX,sizeY;

    public Manejo_Ingresos(int sizex,int sizey,PanelAdmin admin){
        this.sizeX = sizex;
        this.sizeY = sizey;
        setSize(sizeX,sizeY);

        this.admin = admin;

        setOpaque(false);
        setVisible(true);
    }
}
