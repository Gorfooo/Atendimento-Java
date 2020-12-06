package br.com.gorfo.mvnfxmlpadrao.dao;

import br.com.gorfo.mvnfxmlpadrao.beans.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
        public boolean inserir(Cliente cliente){
        String sql = "insert into tb_cliente (nome,cpf,rg,endereco,fone,email,data_nascimento,observacao,revenda)values(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getCpf());        
            stmt.setString(3,cliente.getRg()); 
            stmt.setString(4,cliente.getEndereco()); 
            stmt.setString(5,cliente.getFone()); 
            stmt.setString(6,cliente.getEmail()); 
            stmt.setDate(7,Date.valueOf(cliente.getDataNascimento()));
            stmt.setString(8,cliente.getObservacao());
            stmt.setString(9,cliente.getRevenda()); 
            stmt.execute();
            System.out.println("Cliente inserido com sucesso!\n");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao inserir cliente: "+ e +"\n");
            return false;
        }
    }
    
    public List<Cliente> listar(){
        String sql = "select * from tb_cliente";
        List<Cliente> listaCliente = new ArrayList();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                Cliente cliente = new Cliente(sql, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
                cliente.setId(resultado.getInt("id_atendente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setFone(resultado.getString("fone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                cliente.setObservacao(resultado.getString("observacao"));
                cliente.setRevenda(resultado.getString("revenda"));
                listaCliente.add(cliente);
                System.out.println("Clientes listados com sucesso!\n");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar cliente: "+ e +"\n");
        }
        return listaCliente;
    }
    
    public boolean remover(Cliente cliente){
        String sql = "delete from tb_cliente where id_cliente = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            System.out.println("Cliente removido com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao remover cliente: "+ e +"\n");
            return false;
        }
    }
    
    public boolean atualizar(Cliente cliente){
        String sql = "update tb_cliente set id_cliente=?, nome=?, cpf=?, rg=?, endereco=?, fone=?, email=?, data_nascimento=?, observacao=?, revenda=? where id_cliente=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getFone());
            stmt.setString(7, cliente.getEmail());
            stmt.setDate(8, Date.valueOf(cliente.getDataNascimento()));
            stmt.setString(9, cliente.getObservacao());
            stmt.setString(10, cliente.getRevenda());
            stmt.execute();
            System.out.println("Cliente atualizado com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar cliente: "+ e +"\n");
            return false;
        }
    }
    
    public Cliente buscar(Cliente cliente){
        String sql = "select * from tb_cliente where id_cliente=?";
        Cliente retorno = new Cliente(sql, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                cliente.setNome(resultado.getString("nome"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setFone(resultado.getString("fone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                cliente.setObservacao(resultado.getString("observacao"));
                cliente.setRevenda(resultado.getString("revenda"));
                retorno = cliente;
                System.out.println("Cliente localizado com sucesso!\n");
        }catch (SQLException e){
            System.out.println("Erro ao buscar cliente: "+ e +"\n");
        }
        return retorno;
    }
}
