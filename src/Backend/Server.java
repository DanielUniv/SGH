package Backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    private int puerto;
    private ServerSocket server;
    private Socket cliente;
    private DataBasesManager DB;

    public Server(){
        puerto = 9572;
        try{
            this.server = new ServerSocket(puerto);
        }catch (IOException ex){
            System.out.println(ex + " No se pudo definir el puerto del Servidor");
        }
        DB = new DataBasesManager();
    }

    public void startServer(){
        try{
            while (true){
                cliente = this.server.accept();
                new Thread(new RequestManager(cliente,DB)).start();
            }
        }catch (IOException e){
            System.out.println(e + "No se pudo iniciar el servidor");
        }

    }

    public static void main(String[] args)
    {
        Server init = new Server();
        init.startServer();
    }


}
