package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JPanel implements ActionListener, KeyListener {

    private JLabel mesg;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTextField user;
    private JPasswordField pass;
    private JButton init;
    private String outPass;

    public Login()
    {
        mesg = new JLabel("");
        etiqueta1 = new JLabel("Usuario");
        etiqueta2 = new JLabel("Password");
        user = new JTextField(30);
        pass = new JPasswordField(30);
        init = new JButton("Iniciar");
        add(etiqueta1);
        add(user);
        add(etiqueta2);
        add(pass);
        add(init);
        setSize(500,400);
        setVisible(true);
    }

    private void hashPass(){
        char[] a = pass.getPassword();

    }

    private void initSession(){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand() == init.getActionCommand()) {

        }else{

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
