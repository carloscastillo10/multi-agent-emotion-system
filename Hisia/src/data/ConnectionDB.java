/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @team HISIA
 * @member Carlos Castillo
 * @member Luis Daniel Erazo
 * @member Ximena Puchaicela
*/
public class ConnectionDB {
    
    public static Connection conecction;
    
        
    /**
     * Establecer la conexión con la base de datos
     * @return [Connection]: Objeto que permite manipular la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Connection openConnection() throws ClassNotFoundException, SQLException{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/emotionsdb";
        Class.forName(driver);
        conecction = DriverManager.getConnection(url,"teacher","teacher");
        
        return conecction;
    }
    
    /**
     * Cerrar la conexión con la base de datos
     * @throws SQLException 
     */
    public void closeConnection() throws SQLException{
        conecction.close();
    }
    
}
