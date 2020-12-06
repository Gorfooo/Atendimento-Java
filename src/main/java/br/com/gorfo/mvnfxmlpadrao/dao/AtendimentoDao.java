package br.com.gorfo.mvnfxmlpadrao.dao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendimento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDao {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Atendimento atendimento){
        String sql = "Insert into tb_atendimento (abandonada,data,atendente_transferido,observacao,cliente,atendente) values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,atendimento.getAbandonada());
            stmt.setDate(2,Date.valueOf(atendimento.getData()));
            stmt.setString(3,atendimento.getAtendente_transferido());        
            stmt.setString(4,atendimento.getObservacao()); 
            stmt.setString(5,atendimento.getCliente()); 
            stmt.setString(6,atendimento.getAtendente());  
            stmt.execute();
            System.out.println("Atendimento inserido com sucesso!\n");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao inserir atendimento: "+ e + "\n");
            return false;
        }
    }
    public List<Atendimento> listar(Atendimento Atendimento){
        String sql = "select * from tb_atendimento where id_atendimento = ?";
        List<Atendimento> listaAtendimento = new ArrayList();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                Atendimento atendimento = new Atendimento(Integer.SIZE, sql, LocalDate.MAX, sql, sql, sql, sql);
                atendimento.setId(resultado.getInt("id_atendimento"));
                atendimento.setAbandonada(resultado.getString("abandonada"));
                atendimento.setData(resultado.getDate("Data").toLocalDate());
                atendimento.setAtendente_transferido(resultado.getString("atendente_transferido"));
                atendimento.setObservacao(resultado.getString("observacao"));
                atendimento.setCliente(resultado.getString("cliente"));
                atendimento.setAtendente(resultado.getString("atendente"));
                listaAtendimento.add(atendimento);
                System.out.println("Atendimento localizado com sucesso!\n");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar atendimento: "+ e + "\n");
        }
        return listaAtendimento;
    }
    
        public boolean remover(Atendimento atendimento){
        String sql = "delete from tb_atendimento where id_atendimento = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendimento.getId());
            stmt.execute();
            System.out.println("Atendimento removido com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao remover atendimento: "+ e + "\n");
            return false;
        }
    }
        public boolean atualizar(Atendimento atendimento){
        String sql = "update tb_atendimento set id_atendimento=?, abandonada=?, Data=?, atendente_transferido=?, observacao=?, cliente=?, atendente=? where id_atendimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendimento.getId());
            stmt.setString(2, atendimento.getAbandonada());
            stmt.setDate(3, Date.valueOf(atendimento.getData()));
            stmt.setString(4, atendimento.getAtendente_transferido());
            stmt.setString(5, atendimento.getObservacao());
            stmt.setString(6, atendimento.getCliente());
            stmt.setString(7, atendimento.getAtendente());
            stmt.execute();
            System.out.println("Atendimento atualizado com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar atendimento: "+ e +"\n");
            return false;
        }
    }
    
    public Atendimento buscar(Atendimento atendimento){
        String sql = "select * from tb_atendimento where id_atendimento=?";
        Atendimento retorno = new Atendimento(Integer.SIZE, sql, LocalDate.MAX, sql, sql, sql, sql);
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendimento.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                atendimento.setAbandonada(resultado.getString("abandonada"));
                atendimento.setData(resultado.getDate("Data").toLocalDate());
                atendimento.setAtendente_transferido(resultado.getString("atendente_transferido"));
                atendimento.setObservacao(resultado.getString("observacao"));
                atendimento.setCliente(resultado.getString("cliente"));
                atendimento.setAtendente(resultado.getString("atendente"));
                retorno = atendimento;
                System.out.println("Atendimento localizado com sucesso!\n");
        }catch(SQLException e){
            System.out.println("Erro ao buscar atendimento: "+ e +"\n");
        }
        return retorno;
    }
}
