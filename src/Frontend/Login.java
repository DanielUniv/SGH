package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setLayout(null);//

        title = new JLabel("Hotel El Descanso");
        ImageIcon icono = new ImageIcon("Imagenes/Cloud.png");
        icono.setImage(icono.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH));
        title.setIcon(icono);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);

        mesg = new JLabel("");
        etiqueta1 = new JLabel("Usuario");
        etiqueta2 = new JLabel("Contraseña");

        user = new JTextField(15);
        user.setToolTipText("Escribe tu Usuario/Codigo de Empleado");

        pass = new JPasswordField(15);
        pass.setToolTipText("Escribe tu Constraseña asignada por tu Administrador");

        init = new JButton("Iniciar");
        init.addActionListener(this);

        title.setBounds(99,25,102,100 );
        etiqueta1.setBounds(55,145,50,20);
        etiqueta2.setBounds(55,180,66,20);
        user.setBounds(125,145,120,20);
        pass.setBounds(125,180,120,20);
        init.setBounds(110,215,80,30);
        mesg.setBounds(50,260,200,20);



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

            }
        }
    }

}
