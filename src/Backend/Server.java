package Backend;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    private int puerto;
    private ServerSocket server;
    private Socket cliente;
    private DataBasesManager DB;
    private boolean escuchando;

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
            this.escuchando = true;
            while (escuchando){
                System.out.println("servidor escuchando");
                cliente = this.server.accept();
                new Thread(new RequestManager(cliente,DB)).start();
            }
        }catch (IOException e){
            System.out.println(e + "No se pudo iniciar el servidor");
        }
    }

    public void stop(){
        try {
            this.escuchando = false;
            this.server.close();
        }catch (IOException e){
            System.out.println("fallo el apagado");
        }
        System.out.println("Servidor Apagado");
    }

    public static void main(String[] args)
    {
        String comando = "";
        Server init = new Server();
        init.startServer();
        System.out.println("escriba 'apagar' para detener el servidor");
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        try{
            comando = buffer.readLine();
        }catch (IOException e){
        }
        if (comando.equals("apagar"))
        {
            init.stop();
        }
    }


}
