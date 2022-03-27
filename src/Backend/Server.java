package Backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

public class Server {
    private ServerSocket host="127.0.0.1";
    private final int puertoDefecto = 3030;
    public DataInputStream entrada = null;
    public DataOutputStream salida = null;
    private boolean service = false;

    public Server(){

    }

    public void start(){
        try{
            while(service){
                host.accept();
            }
        }

    }

    public void stop(){

    }

}
