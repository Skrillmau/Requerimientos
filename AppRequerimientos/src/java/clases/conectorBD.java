/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author luill
 */
public class conectorBD {

    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url="jdbc:sqlserver://localhost:1433;databaseName=Requisitos";
    private String user ="PineappleXpress";
    private String password="54321";
    
    public conectorBD() {
        
    }
    
    public Connection conectar(){
        try{
            Class.forName(driver);
            return (DriverManager.getConnection(url,user,password));
        }
        catch (Exception e) {
            
        }
        return null;
    }
    public void desconectar(Connection cn){
        try{
            cn.close();
        }
        catch (Exception e) {
            
        }
    }
    
}
