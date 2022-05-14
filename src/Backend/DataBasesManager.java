package Backend;

import javax.management.Query;
import javax.swing.*;
import java.sql.*;

public class DataBasesManager {

    private String ruta;
    private String usuario;
    private String pass;
    private Connection net;
    private PreparedStatement orden;

    public  DataBasesManager(){
        ruta = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        pass = "basededatosprueba";

        try{
            net = DriverManager.getConnection(ruta,usuario,pass);
            System.out.println("Base de De datos Conectada");
        }catch (Exception ex){
            System.out.println("Error al conectar: "+ ex.getMessage());
        }

    }

    public void consultaQuery(String consulta,String[] datos){
        try {
            orden = net.prepareStatement(consulta);
            for(int i = 0; i < datos.length;i++){
                orden.setString((i + 1),datos[i]);
            }
            orden.executeQuery();
        }catch (Exception e){

        }
    }

    public String consultaEspecial(String query) throws SQLException {
        orden = net.prepareStatement(query);
        return query;
    }

}
