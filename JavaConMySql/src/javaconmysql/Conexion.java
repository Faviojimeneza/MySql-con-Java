/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconmysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Conexion {
//Constante para las conexciones

    private Connection conexion;
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "clase";
    private String pass = "pascual";
    private String url = "jdbc:mysql://localhost:3306/ejemplo";

    public void Conectar() 
    {
        conexion = null;

        try
        {
            Class.forName (driver);
            conexion = (Connection) DriverManager.getConnection(url,user,pass);
            if (conexion != null) 
            
            {
                System.out.println("Conectado!!");

            }
        } 
        
        catch (Exception e) 
        
        {

            System.out.println("Error en la conexión" + e);
        }
    }

    public Connection getConextion(){
    return conexion;
    }
    
    public void desconectar (){
        conexion = null;
        System.out.println("Conexion terminada!");
    }

    public void consultarPersonas(){
    Statement instruccion;
    try {
    
        instruccion= conexion.createStatement();
    ResultSet resultados = instruccion.executeQuery("SELECT*FROM persona");
    ResultSetMetaData metadatos = resultados.getMetaData ();
    int columnas = metadatos.getColumnCount();
    
    for ( int i =1; i<=columnas;i++) {
        System.out.print("--"+metadatos.getColumnName(i));
    }
          System.out.println("");
          
          while (resultados.next()){
          
          for (int i =1; i<=columnas; i++)
              System.out.println("--"+resultados.getObject(i));
          }
          System.out.println("");
          }
    
     catch (SQLException ex){
            
    }


    }
}




