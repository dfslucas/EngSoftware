/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author eldi
 */
public class ClienteDao {
    public void create(Cliente c){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Clientes (nome, cpf, endereco)VALUES(?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getCpf());
            stmt.setString(3,c.getEndereco());
             
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: ");
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public List<Cliente> select(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Clientes");
            rs = stmt.executeQuery();
            while (rs.next()){
                Cliente c = new Cliente(rs.getString("nome"),rs.getString("cpf"),rs.getString("endereco"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CervejaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           Conexao.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    
    public void update(Cliente c){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Clientes SET nome = ?, Endereco = ? WHERE cpf = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEndereco());
            stmt.setString(3,c.getCpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
    }
    
}
