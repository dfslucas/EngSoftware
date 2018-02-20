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
public class ReservaDao {
    public void create(Reserva r){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Clientes (Clientes_cpf, Carros_placa)VALUES(?,?)");
            stmt.setString(1,r.getCarPLACA());
            stmt.setString(2,r.getClienteCPF());
             
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: ");
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public List<Reserva> select(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List <Reserva> reservas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Reservas");
            rs = stmt.executeQuery();
            while (rs.next()){
                Reserva r = new Reserva(rs.getString("Clientes_cpf"),rs.getString("Carros_placa"));
                reservas.add(r);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CervejaDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           Conexao.closeConnection(con, stmt, rs);
        }
        
        return reservas;
    }
    
}
