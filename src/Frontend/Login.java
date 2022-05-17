package Frontend;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class Login extends JPanel implements ActionListener {

    private int sizeX;
    private int sizeY;
    private Cliente referencia;
    private JLabel title;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTextField user;
    private JPasswordField pass;
    private JButton init;
    private JTextArea mesg;
    private String outLog;

    public Login(int sizex,int sizey,Cliente referencia)
    {
        setLayout(null);
        sizeX = (int) (sizex * 0.22);
        sizeY = (int) (sizey * 0.457);
        setSize(sizeX,sizeY);

        this.referencia = referencia;

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
        pass.setText("");
        pass.setToolTipText("Escribe tu Constraseña asignada por tu Administrador");

        init = new JButton("Iniciar");
        init.addActionListener(this);

        mesg = new JTextArea();
        mesg.setEditable(false);
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
        setBorder(new LineBorder(Color.RED));
    }

    private void hashPass(){
        String entrada = String.valueOf(pass.getPassword());
        try {
            MessageDigest sumador = MessageDigest.getInstance("SHA-512");
            sumador.update(entrada.getBytes());
            byte[] sumado = sumador.digest();
            BigInteger conv = new BigInteger(1,sumado);
            outLog = conv.toString(16);
            System.out.println(outLog);
            System.out.println(outLog.length());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("Error sacando sha5");
        }
    }

    public void error(String er){
        this.mesg.setVisible(false);
        this.mesg.setText(er);
        this.mesg.setForeground(Color.RED);
        this.mesg.setVisible(true);
    }

    private void initSession(){
        hashPass();
        referencia.iniciarSesion(this.user.getText(),this.outLog);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == init) {
            if (user.getText().equals("")){
                error("Ingrese el Usuario");
            }else if(String.valueOf(pass.getPassword()).equals("")){
                error("Ingrese la Contraseña");
            }else{
                initSession();
            }
        }
    }

}
