package Frontend;

import javax.swing.*;

public class PanelGerente extends JPanel {

    private int sizeX,sizeY;

    public PanelGerente(int sizex,int sizey,boolean real){
        setLayout(null);
        if(real){
            this.sizeX = sizex;
            this.sizeY = sizey;
        }else {
            this.sizeX = (int) (sizex * 0.80);
            this.sizeY = (int) (sizey * 0.90);
        }
        setSize(sizeX,sizeY);
        System.out.println(getSize());

    }
}
