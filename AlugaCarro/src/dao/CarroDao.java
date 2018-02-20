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
    public void create(Carro a){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Avaliacao (nome, minimo, maximo, )VALUES(?,?,?)");
            stmt.setString(1,a.getNome());
            stmt.setInt(2,a.getMinimo());
            stmt.setInt(3,a.getMaximo());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: ");
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public List<Avaliacao> select(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Avaliacao> avaliacoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Avaliacao");
            rs = stmt.executeQuery();
            while (rs.next()){
                Avaliacao av = new Avaliacao(rs.getString("nome"),rs.getInt("minimo"),rs.getInt("maximo"));
                avaliacoes.add(av);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CervejaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           Conexao.closeConnection(con, stmt, rs);
        }
        
        return avaliacoes;
    }
    
    
    public void update(Avaliacao av){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Avaliacao SET minimo = ?, maximo = ? WHERE Nome = ?");
            stmt.setInt(1,av.getMinimo());
            stmt.setInt(2,av.getMaximo());
            stmt.setString(3,av.getNome());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
    }
    
    
    public void delete(Carro carro){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM Avaliacao WHERE Nome = ?");
            stmt.setString(1, carro.getPlaca());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
        
    }
}
