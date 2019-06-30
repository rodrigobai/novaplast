
package ventaNP;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Rodrigo Contreras
 */
public class VentaNP {
    
    Connection conexion =  null;
    Statement sentencia = null;
    PreparedStatement pst = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC";
    String NOMBREBD = "novaplast.sqlite";
    String URL = "jdbc:sqlite:"+NOMBREBD;
    
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
    
//    public void insertarDatos(int id, String nombre, int precio, String descripcion){
//        
//       try{
//            Class.forName(DRIVER);
//            conexion = DriverManager.getConnection(URL);
//            sentencia = conexion.createStatement();
//            String SQL = "INSERT INTO PRODUCTOS " +
//                    "(ID, NOMBRE, PRECIO, DESCRIPCION) VALUES " +
//                    "('"+id+"','"+nombre+"','"+precio+"','"+descripcion+"')";
//            sentencia.executeUpdate(SQL);
//            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS!!",
//                    "EXITO!!", JOptionPane.INFORMATION_MESSAGE);
//            sentencia.close();
//            conexion.close();
//            
//        }catch(ClassNotFoundException | SQLException e){
//            
//            JOptionPane.showMessageDialog(null, "Error: " + e,
//                    "Error!!", JOptionPane.ERROR_MESSAGE);
//        } 
//        
//        
//    }
    
    
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

