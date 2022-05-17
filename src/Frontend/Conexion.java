package Frontend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conexion{

    private int puerto;
    private String ip;
    private Socket servidor;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private String peticion,resultado;

    public Conexion(){
        ip = "localhost";
        puerto = 9572;
        try {
            servidor = new Socket(ip,puerto);
            salida = new DataOutputStream(this.servidor.getOutputStream());
            entrada = new DataInputStream(this.servidor.getInputStream());
        }catch (IOException e){
            System.out.println(e + "- comunicacion fallida");
        }
    }

    public  String pedir(String orden,String[] datos){
        this.peticion = orden;
        for(int i = 0;i < datos.length;i++){
            this.peticion = peticion + ","+datos[i];
        }

        try{
            this.salida.writeUTF(this.peticion);
            this.resultado = this.entrada.readUTF();
        }catch (IOException lee){
            System.out.println(lee + " - Error enviando o recibiendo mensaje");
        }

        return resultado;
    }

    public void setIp(String nuevo){
        this.ip = nuevo;
    }

}
