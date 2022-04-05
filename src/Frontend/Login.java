package Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JPanel implements ActionListener, KeyListener {

    private String title = "Login";
    private JLabel etiqueta;
    private JTextField user;
    private JPasswordField pass;
    private JButton enter;
    private String outPass;

    public Login()
    {
        etiqueta = new JLabel(title);
        user = new JTextField(30);
        pass = new JPasswordField(30);
        enter = new JButton("Iniciar");
        add(user);
        add(pass);
        add(enter);
        setSize(500,400);
    }

    public String getTitle(){
        return title;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
