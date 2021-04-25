package br.com.gorfo.mvnfxmlpadrao.dao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDao {
    
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }  
    
    public boolean inserir(Atendente Atendente){
        String sql = "insert into tb_atendente (id_atendente,nome,cpf,rg,endereco,fone,email,data_nascimento,observacao,ramal,pis,pasep,setor)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,Atendente.getId());
            stmt.setString(2,Atendente.getNome());
            stmt.setString(3,Atendente.getCpf());        
            stmt.setString(4,Atendente.getRg()); 
            stmt.setString(5,Atendente.getEndereco()); 
            stmt.setString(6,Atendente.getFone()); 
            stmt.setString(7,Atendente.getEmail());
            stmt.setDate(8,Date.valueOf(Atendente.getDataNascimento()));
            stmt.setString(9,Atendente.getObservacao());
            stmt.setInt(10,Atendente.getRamal()); 
            stmt.setString(11,Atendente.getPis()); 
            stmt.setString(12,Atendente.getPasep()); 
            stmt.setString(13,Atendente.getSetor()); 
            stmt.execute();
            System.out.println("Atendente inserido com sucesso!");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao inserir atendente: "+ e);
            return false;
        }
    }
    
    public List<Atendente> listar(){
        String sql = "select * from tb_atendente";
        List<Atendente> listaAtendente = new ArrayList();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                Atendente atendente = new Atendente(Integer.SIZE, sql, sql, sql, Integer.SIZE, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
                atendente.setId(resultado.getInt("id_atendente"));
                atendente.setCpf(resultado.getString("cpf"));
                atendente.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                atendente.setEmail(resultado.getString("email"));
                atendente.setEndereco(resultado.getString("endereco"));
                atendente.setFone(resultado.getString("fone"));
                atendente.setSetor(resultado.getString("Setor"));
                atendente.setNome(resultado.getString("nome"));
                atendente.setRamal(resultado.getInt("ramal"));
                atendente.setRg(resultado.getString("rg"));
                atendente.setObservacao(resultado.getString("observacao"));
                atendente.setPasep(resultado.getString("pasep"));
                atendente.setPis(resultado.getString("pis"));
                listaAtendente.add(atendente);
            }
            System.out.println("Atendentes listados com sucesso!");
        }catch(SQLException e){
            System.out.println("Erro ao listar atendentes: "+ e);
        }
        return listaAtendente;
    }
    
    public boolean remover(Integer id){
        String sql = "delete from tb_atendente where id_atendente = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Atendente removido com sucesso!");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao remover atendente: "+ e);
            return false;
        }
    }
    
    public boolean atualizar(Atendente atendente){
        String sql = "update tb_atendente set id_atendente=?, nome=?, cpf=?, rg=?, endereco=?, fone=?, email=?, data_nascimento=?, observacao=?, ramal=?, pis=?, pasep=?, setor=? where id_atendente=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendente.getId());
            stmt.setString(2, atendente.getNome());
            stmt.setString(3, atendente.getCpf());
            stmt.setString(4, atendente.getRg());
            stmt.setString(5, atendente.getEndereco());
            stmt.setString(6, atendente.getFone());
            stmt.setString(7, atendente.getEmail());
            stmt.setDate(8, Date.valueOf(atendente.getDataNascimento()));
            stmt.setString(9, atendente.getObservacao());
            stmt.setInt(10, atendente.getRamal());
            stmt.setString(11, atendente.getPis());
            stmt.setString(12, atendente.getPasep());
            stmt.setString(13, atendente.getSetor());
            stmt.setInt(14, atendente.getId());
            stmt.execute();
            System.out.println("Atendente atualizado com sucesso!");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar atendente: "+ e);
            return false;
        }
    }
    
    public Atendente buscar(Integer id) throws SQLException{
        String sql = "select * from tb_atendente where id_atendente=?";
        Atendente retorno = new Atendente(id, sql, sql, sql, id, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                retorno.setCpf(resultado.getString("cpf"));
                retorno.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                retorno.setEmail(resultado.getString("email"));
                retorno.setEndereco(resultado.getString("endereco"));
                retorno.setFone(resultado.getString("fone"));
                retorno.setSetor(resultado.getString("setor"));
                retorno.setNome(resultado.getString("nome"));
                retorno.setObservacao(resultado.getString("observacao"));
                retorno.setPasep(resultado.getString("pasep"));
                retorno.setPis(resultado.getString("pis"));
                retorno.setRamal(resultado.getInt("ramal"));
                retorno.setRg(resultado.getString("rg"));
                System.out.println("Atendente localizado com sucesso!");
        return retorno;
    }
}