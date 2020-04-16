/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoSQL;
import Dados.Agenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 277700
 */
public class AgendaDAO
{
    private ConexaoSQL conn;
    
    public AgendaDAO()
    {
        try
        {
            this.conn = new ConexaoSQL();
        }
        
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(AgendaDAO.class.getName()).log
                (Level.SEVERE, null, ex);
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(AgendaDAO.class.getName()).log
                (Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserir(Agenda age)
    {
        try
        {
            String sql = "INSERT INTO agenda(Cod_Agenda, Data_Agenda, Hora_Agenda, Local_Servico, Descricao_Servico) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ps.setInt(1, age.getCod_Agenda());
            ps.setString(2, age.getData_Agenda());
            ps.setString(3, age.getHora_Agenda());
            ps.setString(4, age.getLocal_Servico());
            ps.setString(5, age.getDescricao_Servico());
            
            
            ps.execute();
            
            this.conn.confirmar();
            
            return true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Agenda age)
    {
        try
        {
            String sql = "UPDATE agenda set Data_Agenda=?, Hora_Agenda=?, Local_Servico=?, Descricao_Servico=? WHERE Cod_Agenda=?";
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            
            ps.setString(1, age.getData_Agenda());
            ps.setString(2, age.getHora_Agenda());
            ps.setString(3, age.getLocal_Servico());
            ps.setString(4, age.getDescricao_Servico());
            ps.setInt(5, age.getCod_Agenda());
            
            ps.executeUpdate();
            
            this.conn.confirmar();
            
            return true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public Agenda buscarPorCod(Integer Cod_Agenda)
    {
        try
        {
            String sql = "SELECT*FROM agenda WHERE Cod_Agenda="+Cod_Agenda;
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Agenda a = new Agenda();
            
            while(rs.next())
            {
                a.setCod_Agenda(rs.getInt("Cod_Agenda"));
                a.setData_Agenda(rs.getString("Data_Agenda"));
                a.setHora_Agenda(rs.getString("Hora_Agenda"));
                a.setLocal_Servico(rs.getString("Local_Servico"));
                a.setDescricao_Servico(rs.getString("Descricao_Servico"));
            }
            
        return a;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Agenda> buscarTodos()
    {
        try
        {
            String sql = "SELECT*FROM agenda";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Agenda>arrayAgenda = new ArrayList<>();
            
            while(rs.next())
            {
                Agenda a = new Agenda();
                
                a.setCod_Agenda(rs.getInt("Cod_Agenda"));
                a.setData_Agenda(rs.getString("Data_Agenda"));
                a.setHora_Agenda(rs.getString("Hora_Agenda"));
                a.setLocal_Servico(rs.getString("Local_Servico"));
                a.setDescricao_Servico(rs.getString("Descricao_Servico"));;
  
                arrayAgenda.add(a);           
            }
            return arrayAgenda;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public boolean excluir(int Cod_Agenda_Excluir)
    {
        try
        {
            String sql = "DELETE FROM agenda WHERE Cod_Agenda='"+Cod_Agenda_Excluir+"'";
            
            System.out.println(sql);
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ps.executeUpdate();
            this.conn.confirmar();
            
            return true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return false;
        }
    }
}
