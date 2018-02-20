/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/aluguelcarro?autoReconnect=true&useSSL=false";
    private static String USER = "aluguel";
    private static final String PASS = "1234";
    
public static Connection getConnection(){
    try {   
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao conectar: ");
        throw new RuntimeException("Erro na conexao: ",ex);
    }
}

public static void closeConnection(Connection con){
    try {
        if(con!=null){
            con.close();
        }
    } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void closeConnection(Connection con, PreparedStatement stmt){
    closeConnection(con);
    try {
        if(stmt!=null){
            stmt.close();
        }
    } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
    closeConnection(con,stmt);
    try {
        if(rs!=null){
            rs.close();
        }
    } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}