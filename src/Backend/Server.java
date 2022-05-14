package Backend;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{

    private ServerSocket conexion;
    private DataBasesManager DB;
    private String[] consultas;

    public Server(){
        try{
            this.conexion = new ServerSocket(9572);
        }catch (IOException ex){
            System.out.println(ex + " No se pudo definir el puerto del Servidor");
        }
        DB = new DataBasesManager();
    }

    public static void main(String[] args){
        Server init = new Server();
    }


    @Override
    public void run() {

    }
}
