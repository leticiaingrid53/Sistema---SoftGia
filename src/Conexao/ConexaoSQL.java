/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 277700
 */
public class ConexaoSQL
{
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/softgia";
    private final String user = "root";
    private final String pass = "";
    
    private Connection conn;
    
    public ConexaoSQL()throws ClassNotFoundException, SQLException, IllegalAccessException {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, pass);
            conn.setAutoCommit(false);
            System.out.println("Conexão criada com SGBD com sucesso");
        }
        
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
        
            throw new ClassNotFoundException("O Driver não foi localizado e adicionado. "
            + "Talvez a biblioteca JDBC não foi adicionada ao projeto. \n" + e.getMessage());      
        }
        
        catch (SQLException e)
        {
            throw new SQLException("Deu erro na conexão com a fonte de dados. \n" + e.getMessage());
        }
    }
    
    public Connection getConexao()
    {
        return conn;
    }
    
    public void confirmar() throws SQLException
    {
        try
        {
            conn.commit();
        }
        
        catch (SQLException e)
        {
            throw new SQLException("Não foi possível executar o comenado SQL. \n"+e.getMessage());
        }
        
        finally
        {
            conn.close();
        }
    }
}