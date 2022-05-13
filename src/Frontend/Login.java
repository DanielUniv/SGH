package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {

    private int sizeX;
    private int sizeY;
    private JLabel title;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTextField user;
    private JPasswordField pass;
    private JButton init;
    private JTextArea mesg;
    private String outLog;

    public Login(int sizex,int sizey)
    {
        setLayout(null);
        sizeX = (int) (sizex * 0.22);
        sizeY = (int) (sizey * 0.457);
        setSize(sizeX,sizeY);

        title = new JLabel("Hotel El Descanso");
        ImageIcon icono = new ImageIcon("Imagenes/Cloud.png");
        icono.setImage(icono.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
        title.setIcon(icono);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);

        etiqueta1 = new JLabel("Usuario");
        etiqueta2 = new JLabel("Contraseña");

        //title.setFont(title.getFont().deriveFont((float) (sizeY * 0.02858)));
        //etiqueta1.setFont(etiqueta1.getFont().deriveFont(10F /*(float) (sizeY * 0.02858)*/));
        //etiqueta2.setFont(etiqueta2.getFont().deriveFont(10F /*(float) (sizeY * 0.02858)*/));
        //title.setFont(title.getFont().deriveFont(10.4F)); is how change the Font size

        user = new JTextField();
        user.setToolTipText("Escribe tu Usuario/Codigo de Empleado");

        pass = new JPasswordField();
        pass.setToolTipText("Escribe tu Constraseña asignada por tu Administrador");

        init = new JButton("Iniciar");
        init.addActionListener(this);

        mesg = new JTextArea();
        mesg.setLineWrap(true);
        mesg.setWrapStyleWord(true);
        mesg.setOpaque(false);



        title.setBounds((int) (sizeX * 0.33),(int)(sizeY * 0.071),(int) (sizeX * 0.34),(int)(sizeY * 0.28571));
        etiqueta1.setBounds((int) (sizeX * 0.184),(int) (sizeY * 0.415),(int)(sizeX * 0.22),(int)(sizeY * 0.0572));
        etiqueta2.setBounds((int) (sizeX * 0.184),(int)(sizeY * 0.5143),(int)(sizeX * 0.22),(int)(sizeY * 0.0572));
        user.setBounds((int)(sizeX * 0.4167),(int) (sizeY * 0.415),(int)(sizeX * 0.4),(int)(sizeY * 0.0572));
        pass.setBounds((int)(sizeX * 0.4167),(int)(sizeY * 0.5143),(int)(sizeX * 0.4),(int)(sizeY * 0.0572));
        init.setBounds((int)(sizeX * 0.367),(int)(sizeY * 0.6143),(int)(sizeX * 0.2667),(int)(sizeY * 0.08572));
        mesg.setBounds((int)(sizeX * 0.167),(int)(sizeY * 0.743),(int)(sizeX * 0.6667),(int)(sizeY * 0.1144));



        add(title);
        add(mesg);
        add(etiqueta1);
        add(user);
        add(etiqueta2);
        add(pass);
        add(init);


        setOpaque(false);
        setBackground(null);
        setVisible(true);
    }

    private void hashPass(){
        char[] a = pass.getPassword();

    }

    private void error(String er){
        this.mesg.setVisible(false);
        this.mesg.setText(er);
        this.mesg.setForeground(Color.RED);
        this.mesg.setVisible(true);
    }

    private void initSession(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == init) {
            if (user.getText() == null){
                error("Ingrese el Usuario");
            }else if(pass.getPassword() == null){
                error("Ingrese la Contraseña");
            }else{
                error("Contraseña o Usuario Erroneo");
            }
        }
    }

}
