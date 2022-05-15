package Backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestManager implements Runnable{

    private Socket rfCliente;
    private DataBasesManager rfDBM;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private boolean conected;
    private String mensaje,respuesta;
    private StringTokenizer separador;
    private String[] datos;

    public RequestManager(Socket rfCliente,DataBasesManager rfDBM){

        this.rfCliente = rfCliente;
        mensaje = "";
        respuesta = "conectado";
        try {
            entrada = new DataInputStream(this.rfCliente.getInputStream());
            salida = new DataOutputStream(this.rfCliente.getOutputStream());
        }catch (Exception ex){
            System.out.println(ex + " - comunicacion fallida");
        }
    }

    private void leerOrden() throws IOException{
        this.mensaje = this.entrada.readUTF();
        if(mensaje.equals("exit")){
            this.conected = false;
        }else{
            procesar();
        }
    }

    private void responder() throws IOException{
        salida.writeUTF(respuesta);
    }

    public void procesar() throws IOException{
        this.separador = new StringTokenizer(mensaje,",");
        mensaje = separador.nextToken();

        respuesta = separador.nextToken();
        responder();
    }

    public void generateSalt(){

    }



    @Override
    public void run() {
        conected = true;
        while(conected){
            try{
                leerOrden();
            }catch (IOException e){
                e.getStackTrace();
            }
        }

    }
}
