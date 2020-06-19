package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author caigo
 */

public class ClienteDAO {
    private Connection conexao;
    private PreparedStatement st;
    private ResultSet rs;
    
    public int conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dados", "root", "");
            return 1;
        }catch(SQLException ex){
            return 0;
        }catch(ClassNotFoundException x){
            return 0;
        }
    }
    
    public int salvarCliente(Cliente cli){
        try{
            String comando = "INSERT INTO `dados`.`cliente` (`nome`,`telefone`,"
                    + "`idade`,`email`) VALUES (?,?,?,?)";
            st = this.conexao.prepareStatement(comando);
            st.setString(1, cli.getNome());
            st.setString(2, cli.getTelefone());
            st.setInt(3,cli.getIdade());
            st.setString(4, cli.getEmail());
            st.execute();
            return 1;
        }catch(SQLException ex){
            int codErro = ex.getErrorCode();
            String msgErro = ex.getMessage();
            if(ex.getErrorCode() == 1062){
                return 2;
            }else{
                return 0;
            }
        }
    }
    
    public ArrayList consultarClienteNome(String n){
        try{
            String sql = "select * from cliente where nome like ?";
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            st = conexao.prepareStatement(sql);
            st.setString(1, "%"+n+"%");
            rs = st.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setEmail(rs.getString("email"));
                cli.setIdade(rs.getInt("idade"));
            
                lista.add(cli);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
        public ArrayList consultarClienteId(String id){
        try{
            String sql = "select * from cliente where id = ?";
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            st = conexao.prepareStatement(sql);
            st.setString(1,id);
            rs = st.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setEmail(rs.getString("email"));
                cli.setIdade(rs.getInt("idade"));
            
                lista.add(cli);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public ArrayList ConsultarTodosCliente(){
        try{
            String sql = "select * from cliente";
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            st = conexao.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setEmail(rs.getString("email"));
                cli.setIdade(rs.getInt("idade"));
            
                lista.add(cli);
            }
            return lista;
        }catch(SQLException ex){
            return null;
        }
    }
    
    public int apagarCliente(String id){
        try{
            String sql = "DELETE FROM cliente WHERE id=?";
            st = conexao.prepareStatement(sql);
            st.setString(1,id);
            st.executeUpdate();
            return 1;
        }catch(SQLException ex){
            int Erro = ex.getErrorCode();
            String msgErro = ex.getMessage();
            return 2;
        }
    }
    
    public int atualizarCliente(Cliente cli){
        try{
            String sql = "UPDATE `cliente` SET `nome` = ?, `telefone` = ?,"
                    + " `idade` = ?, `email` = ? WHERE `cliente`.`id` = ?";
             st = this.conexao.prepareStatement(sql);
             st.setString(1, cli.getNome());
             st.setString(2, cli.getTelefone());
             st.setInt(3,cli.getIdade());
             st.setString(4, cli.getEmail());
             st.setInt(5,cli.getId());
             st.executeUpdate();
             return 1;
        }catch(SQLException ex){
            int codErro = ex.getErrorCode();
            String msgErro = ex.getMessage();
            return 2;
        }
    }
    
    public void desconectar(){
        try{
            conexao.close();
        }catch (SQLException ex){
            int codErro = ex.getErrorCode();
            String msgErro = ex.getMessage();
        }
    }
}
