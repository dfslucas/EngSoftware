/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import iFrame.*;
import dao.*;
import Classes.*;
import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CarroDao {
    public void create(Carro car){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Carros (placa, modelo)VALUES(?,?)");
            stmt.setString(1,car.getPlaca());
            stmt.setString(2,car.getModelo());
             
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: ");
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public List<Carro> select(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Carro> carros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Carros");
            rs = stmt.executeQuery();
            System.out.println(stmt);
            while (rs.next()){
                Carro car = new Carro(rs.getString("placa"),rs.getString("modelo"));
                carros.add(car);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CervejaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           Conexao.closeConnection(con, stmt, rs);
        }
        
        return carros;
    }
    
    
    public void update(Carro car){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Carros SET modelo = ? WHERE placa = ?");
            stmt.setString(1,car.getModelo());
            stmt.setString(2,car.getPlaca());

            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
    }
    
}
