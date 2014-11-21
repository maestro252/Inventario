/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author jonathaneidelman
 */
public class DBOps {
   private static DBOps INSTANCE;
    
    private final String nombreDB = "inventario";
    
    private Connection c;
    
    private DBOps(){
    }
    
    public static DBOps getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DBOps();
        }
        return INSTANCE;
    }
    
    /**
     * Se crea una conexion con la base de datos que se tiene por defecto.
     * @return El objeto connection.
     */
    public Connection ConnectDB(){
        if(c == null){
            c=ConnectDB(nombreDB);
        }
        
        return c;
    }
    
    /**
     * Metodo para establecer coneccion con una Base de datos 
     * en especifico con sqlite.
     * Si no existe la Base de datos, esta se crea con el nombre dado.
     * @param DB_name Nombre de la base de datos.
     * @return Un objeto connection.
     */
    public Connection ConnectDB(String DB_name){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"
                    + DB_name + ".db");


        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println(e);
            System.exit(0);
        }


        return c;
    } 
}
