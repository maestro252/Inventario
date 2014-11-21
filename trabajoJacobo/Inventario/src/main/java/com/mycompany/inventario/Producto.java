/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario;

import java.util.Date;
import database.DBOps;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author jonathaneidelman
 */
public class Producto {
    private String nombre;
    private Date vencimiento; //formato dd,mm,yyyy
    private String descripcion;
    private int cantidad;

    public Producto() {
    }

    
    
    public Producto(String nombre, Date vencimiento, String descripcion, int cantidad) {
        this.nombre = nombre;
        this.vencimiento = vencimiento;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(String nombre, Date vencimiento, String descripcion) {
        this.nombre = nombre;
        this.vencimiento = vencimiento;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, Date vencimiento) {
        this.nombre = nombre;
        this.vencimiento = vencimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void crearProducto(String nombre, String vencimiento, String descripcion, int cantidad) throws SQLException{
        Connection c = DBOps.getInstance().ConnectDB();
        Statement stm = c.createStatement();
            String sql = "insert into PRODUCTO (NOMBRE, VENCIMIENTO, DESCRIPCION, CANTIDAD)" +
                    " VALUES(" + "'" + nombre + "'" + ", " + "'" + vencimiento + "'" + ", " + "'" +
                    descripcion + "'" + ", " + cantidad + ");";
            stm.execute(sql);
            stm.close();
        
    }
    
}
