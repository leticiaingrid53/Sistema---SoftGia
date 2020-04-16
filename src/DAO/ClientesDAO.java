/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoSQL;
import Dados.Clientes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 277700
 */
public class ClientesDAO
{
    private ConexaoSQL conn;
    
    public ClientesDAO()
    {
        try
        {
            this.conn = new ConexaoSQL();
        }
        
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ClientesDAO.class.getName()).log
                (Level.SEVERE, null, ex);
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(ClientesDAO.class.getName()).log
                (Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserir(Clientes cli)
    {
        try
        {
            String sql = "INSERT INTO cliente(Cod_Cliente, Nome_Cliente, Cpf_Cliente, Endereco_Cliente, Complemento_Cliente, Telefone_Cliente, Rg_Cliente, Email_Cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ps.setInt(1, cli.getCodigo_Cliente());
            ps.setString(2, cli.getNome_Cliente());
            ps.setInt(3, cli.getCpf_Cliente());
            ps.setString(4, cli.getEndereco_Cliente());
            ps.setString(5, cli.getComplemento_Cliente());
            ps.setInt(6, cli.getTelefone_Cliente());
            ps.setString(7, cli.getRg_Cliente());
            ps.setString(8, cli.getEmail_Cliente());
            
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
    
    public boolean alterar(Clientes cli)
    {
        try
        {
            String sql = "UPDATE cliente set Nome_Cliente=?, Cpf_Cliente=?, Endereco_Cliente=?, Complemento_Cliente=?, Telefone_Cliente=?, Rg_Cliente=?, Email_Cliente=? WHERE Cod_Cliente=?";
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            
            ps.setString(1, cli.getNome_Cliente());
            ps.setInt(2, cli.getCpf_Cliente());
            ps.setString(3, cli.getEndereco_Cliente());
            ps.setString(4, cli.getComplemento_Cliente());
            ps.setInt(5, cli.getTelefone_Cliente());
            ps.setString(6, cli.getRg_Cliente());
            ps.setString(7, cli.getEmail_Cliente());
            ps.setInt(8, cli.getCodigo_Cliente());
            
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
    
    public Clientes buscarPorCod(Integer Cod_Cliente)
    {
        try
        {
            String sql = "SELECT*FROM cliente WHERE Cod_Cliente="+Cod_Cliente;
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Clientes c = new Clientes();
            
            while(rs.next())
            {
                c.setCodigo_Cliente(rs.getInt("Codigo_Cliente"));
                c.setNome_Cliente(rs.getString("Nome_Cliente"));
                c.setCpf_Cliente(Integer.parseInt(rs.getString("Cpf_Cliente")));
                c.setEndereco_Cliente(rs.getString("Endereco_Cliente"));
                c.setComplemento_Cliente(rs.getString("Complemento_Cliente"));
                c.setTelefone_Cliente(rs.getInt("Telefone_Cliente"));
                c.setRg_Cliente(rs.getString("Rg_Cliente"));
                c.setEmail_Cliente(rs.getString("Email_Cliente"));
            }
            
        return c;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public ArrayList<Clientes> buscarTodos()
    {
        try
        {
            String sql = "SELECT*FROM cliente";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Clientes>arrayClientes = new ArrayList<>();
            
            while(rs.next())
            {
                Clientes c = new Clientes();
                
                c.setCodigo_Cliente(rs.getInt("Codigo_Cliente"));
                c.setNome_Cliente(rs.getString("Nome_Cliente"));
                c.setCpf_Cliente(Integer.parseInt(rs.getString("Cpf_Cliente")));
                c.setEndereco_Cliente(rs.getString("Endereco_Cliente"));
                c.setComplemento_Cliente(rs.getString("Complemento_Cliente"));
                c.setTelefone_Cliente(rs.getInt("Telefone_Cliente"));
                c.setRg_Cliente(rs.getString("Rg_Cliente"));
                c.setEmail_Cliente(rs.getString("Email_Cliente"));
                
                arrayClientes.add(c);           
            }
            return arrayClientes;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public boolean excluir(int Codigo_Cliente_Excluir)
    {
        try
        {
            String sql = "DELETE FROM cliente WHERE Cod_Cliente='"+Codigo_Cliente_Excluir+"'";
            
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