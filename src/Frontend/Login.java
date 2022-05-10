package Frontend;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;

public class Login extends JPanel implements ActionListener {

    private JLabel title;
    private JLabel mesg;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTextField user;
    private JPasswordField pass;
    private JButton init;
    private String outLog;

    public Login()
    {
        setLayout(new FlowLayout());

        title = new JLabel("");//"Hotel El Descanso"
        //title.setIcon(new ImageIcon("Imagenes/Cloud.png"));
        mesg = new JLabel("");
        etiqueta1 = new JLabel("Usuario");
        etiqueta2 = new JLabel("Password");
        user = new JTextField(15);
        user.setToolTipText("Escribe tu Usuario ejem: 11235");
        pass = new JPasswordField(15);
        pass.setToolTipText("Escribe tu Constraseña asignada por tu Administrador");
        init = new JButton("Iniciar");

        add(title);
        add(mesg);
        add(etiqueta1);
        add(user);
        add(etiqueta2);
        add(pass);
        add(init);

        setOpaque(false);
        setSize(300,350);
        setBackground(null);
        setVisible(true);
    }

    private void hashPass(){
        char[] a = pass.getPassword();

    }

    private void initSession(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == init) {

        }else{

        }

    }

}
