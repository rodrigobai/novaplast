// * Cryptographic API.
// *
// * AES Cipher Algorithm.
// *
// * Based on Brian Gladman's code.
// *
// * Linux developers:
// *  Alexander Kjeldaas <astor@fast.no>
// *  Herbert Valerio Riedel <hvr@hvrlab.org>
// *  Kyle McMartin <kyle@debian.org>
// *  Adam J. Richter <adam@yggdrasil.com> (conversion to 2.5 API).
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * ---------------------------------------------------------------------------
// * Copyright (c) 2002, Dr Brian Gladman <brg@gladman.me.uk>, Worcester, UK.
// * All rights reserved.
// *
// * LICENSE TERMS
// *
// * The free distribution and use of this software in both source and binary
// * form is allowed (with or without changes) provided that:
// *
// *   1. distributions of this source code include the above copyright
// *      notice, this list of conditions and the following disclaimer;
// *
// *   2. distributions in binary form include the above copyright
// *      notice, this list of conditions and the following disclaimer
// *      in the documentation and/or other associated materials;
// *
// *   3. the copyright holder's name is not used to endorse products
// *      built using this software without specific written permission.
// *
// * ALTERNATIVELY, provided that this notice is retained in full, this product
// * may be distributed under the terms of the GNU General Public License (GPL),
// * in which case the provisions of the GPL apply INSTEAD OF those given above.
// *
// * DISCLAIMER
// *
// * This software is provided 'as is' with no explicit or implied warranties
// * in respect of its properties, including, but not limited to, correctness
// * and/or fitness for purpose.
// * ---------------------------------------------------------------------------
// */
// * @author Rodrigo Contreras
// */

package ventaNP;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import principal.Principal;

///**
// */*
// * Cryptographic API.
// *
// * AES Cipher Algorithm.
// *
// * Based on Brian Gladman's code.
// *
// * Linux developers:
// *  Alexander Kjeldaas <astor@fast.no>
// *  Herbert Valerio Riedel <hvr@hvrlab.org>
// *  Kyle McMartin <kyle@debian.org>
// *  Adam J. Richter <adam@yggdrasil.com> (conversion to 2.5 API).
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * ---------------------------------------------------------------------------
// * Copyright (c) 2002, Dr Brian Gladman <brg@gladman.me.uk>, Worcester, UK.
// * All rights reserved.
// *
// * LICENSE TERMS
// *
// * The free distribution and use of this software in both source and binary
// * form is allowed (with or without changes) provided that:
// *
// *   1. distributions of this source code include the above copyright
// *      notice, this list of conditions and the following disclaimer;
// *
// *   2. distributions in binary form include the above copyright
// *      notice, this list of conditions and the following disclaimer
// *      in the documentation and/or other associated materials;
// *
// *   3. the copyright holder's name is not used to endorse products
// *      built using this software without specific written permission.
// *
// * ALTERNATIVELY, provided that this notice is retained in full, this product
// * may be distributed under the terms of the GNU General Public License (GPL),
// * in which case the provisions of the GPL apply INSTEAD OF those given above.
// *
// * DISCLAIMER
// *
// * This software is provided 'as is' with no explicit or implied warranties
// * in respect of its properties, including, but not limited to, correctness
// * and/or fitness for purpose.
// * ---------------------------------------------------------------------------
// */
// * @author Rodrigo Contreras
// */
public class VentaNP {
    
    Connection conexion =  null;
    Statement sentencia = null;
    PreparedStatement pst = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC";
    String NOMBREBD = "novaplast.sqlite";
    String URL = "jdbc:sqlite:"+NOMBREBD;
    private Object tablaProdcto;
    
    public void crearBD(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        
    }//fin método.
    
    public void crearTablaUsuario(){
        
          try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE USUARIO " +
                    "(ID        INT     PRIMARY KEY NOT NULL, " +
                    "NOMBRE     TEXT    NOT NULL, " +
                    "PASSWORD   TEXT     NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA CREADA!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void crearTablaCliente(){
        
          try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE CLIENTE " +
                    "(RUT        INT     PRIMARY KEY NOT NULL, " +
                    "NOMBRE     TEXT    NOT NULL, " +
                    "TELEFONO   INT     NOT NULL, " +
                    "MAIL TEXT NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA CREADA!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
    }
         public void crearTablaProducto(){
        
          try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE PRODUCTOS " +
                    "(ID        INT     PRIMARY KEY NOT NULL, " +
                    "NOMBRE     TEXT    NOT NULL, " +
                    "PRECIO     INT    NOT NULL)"+
                    "DESCRIPCION   TEXT    NOT NULL)"
                    ;
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA CREADA!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
          
    }//crear tablas
    
    public void insertarDatosUsuario(){
        
       try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO USUARIO " +
                    "(ID, NOMBRE, PASSWORD) VALUES " +
                    "('1' , 'admin', '1234')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
        
        
    }//insertar datos a la tabla de usuario
    
    public void insertarDatosProductos(int id, String nombre, int precio, String descripcion){
        
       try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO PRODUCTOS " +
                    "(ID, NOMBRE, PRECIO, DESCRIPCION) VALUES " +
                    "('"+id+"','"+nombre+"','"+precio+"','"+descripcion+"')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
        
      
        
    }
    public void actualizarDatosProductos(int id, String nombre, int precio, String descripcion){
        
       try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "UPDATE PRODUCTOS " +
                    "(ID, NOMBRE, PRECIO, DESCRIPCION) VALUES " +
                    "('"+id+"','"+nombre+"','"+precio+"','"+descripcion+"')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
        
      
        
    }
    
    
    
    public void insertarDatosCliente(int RUT, String NOMBRE, int TELEFONO, String MAIL){
        
       try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO CLIENTE " +
                    "(RUT, NOMBRE, TELEFONO, MAIL) VALUES " +
                    "('"+RUT+"','"+NOMBRE+"','"+TELEFONO+"','"+MAIL+"')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
        
        
    }
    
    public void cargarCMB(JComboBox cmbProd){
        try{
        
        Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT * FROM PRODUCTOS";
            resultados = sentencia.executeQuery(SQL);
            int fila = 1;
            cmbProd.removeAllItems();
            while(resultados.next()){
                
                cmbProd.addItem(resultados.getString("NOMBRE"));
                fila++;
            }
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    
    public void mostrarDatos(JTable tablaProducto){
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT * FROM PRODUCTOS";
            resultados = sentencia.executeQuery(SQL);
            int fila = 0;
            while(resultados.next()){
                
                tablaProducto.setValueAt(resultados.getInt("ID"), fila, 0);
                tablaProducto.setValueAt(resultados.getString("NOMBRE"), fila, 1);
                tablaProducto.setValueAt(resultados.getInt("PRECIO"), fila, 2);
                tablaProducto.setValueAt(resultados.getString("DESCRIPCION"), fila, 3);
                fila++;
            }
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        } 
         
}
    
    public void eliminarDatos(JTable tablaProducto){
        
        int filaSeleccionada = tablaProducto.getSelectedRow();
        
           try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "DELETE FROM PRODUCTOS";
            resultados = sentencia.executeQuery(SQL);
            
            if(filaSeleccionada>=1){
                
            }
            
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Registro Eliminado!!",
                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            resultados.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        
        
//        
//        try{
//            Class.forName(DRIVER);
//            conexion = DriverManager.getConnection(URL);
//            sentencia = conexion.createStatement();
//            String SQL = "DELETE FROM PRODUCTOS ";
//            resultados = sentencia.executeQuery(SQL);
//            
//         
//            if(filaSeleccionada>=0){
//
//                PreparedStatement pst= conexion.prepareStatement("DELETE FROM PRODUCTOS ");
//               int n=pst.executeUpdate();
//               
//            }
//            resultados.close();
//            sentencia.close();
//            conexion.close();
//            
//        }catch(ClassNotFoundException | SQLException e){
//            
//            JOptionPane.showMessageDialog(null, "Error: " + e,
//                    "Error!!", JOptionPane.ERROR_MESSAGE);
//        } 
}
   
//    String usuario = Inicio.txtUsuario.getText();
//    String clave = String.valueOf(Inicio.jpass.getPassword());
//
//    int resultado=0;
//   

//    String SSQL="SELECT * FROM  WHERE USUARIO='"+NOMBRE+"' AND clave='"+PASSWORD+"'";
//
//    Connection conect = null;
//
//    try {
//
//        conect = metodospool.dataSource.getConnection();
//        Statement st = conect.createStatement();
//        ResultSet rs = st.executeQuery(SSQL);
//
//       if(rs.next()){
//
//           resultado=1;
//
//       }
//
//   } catch (SQLException ex) {
//
//        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
//
//    }finally{
//
//
//        try {
//
//            conect.close();
//
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
//
//        }
//
//    }
//
//return resultado;



    public static void main(String[] args) {
        
       VentaNP gbd = new VentaNP();
       gbd.crearTablaCliente();
    }
}

