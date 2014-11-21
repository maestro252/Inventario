/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jonathaneidelman
 */
public class CreateDB {
        public static void main(String[] args) {
        try {
            Connection c = DBOps.getInstance().ConnectDB();
            
            try (Statement stm = c.createStatement()) {
                String sql = "CREATE TABLE PRODUCTO ("
                        + "ID INTEGER PRIMARY KEY NOT NULL,"
                        + "NOMBRE TEXT NOT NULL,"
                        + "VENCIMIENTO TEXT NOT NULL,"
                        + "DESCRIPCION TEXT,"
                        + "CANTIDAD INTEGER"
                        + ")";
                
                
                stm.execute(sql);
                
                System.out.println("Tablas con esquema creadas exitosamente");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
