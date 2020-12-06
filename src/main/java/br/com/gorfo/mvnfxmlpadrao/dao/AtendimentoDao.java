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
        String sql = "Insert into tb_atendimento (abandonada,data,id_atendente_transferido,observacao,id_cliente,id_atendente) values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,atendimento.getAbandonada());
            stmt.setDate(2,Date.valueOf(atendimento.getData()));
            stmt.setInt(3,atendimento.getId_atendente_transferido());        
            stmt.setString(4,atendimento.getObservacao()); 
            stmt.setInt(5,atendimento.getId_cliente()); 
            stmt.setInt(6,atendimento.getId_atendente());  
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
                Atendimento atendimento = new Atendimento(sql, LocalDate.MAX, Integer.MIN_VALUE, sql, Integer.MIN_VALUE, Integer.MIN_VALUE);
                atendimento.setId(resultado.getInt("id_atendimento"));
                atendimento.setAbandonada(resultado.getString("abandonada"));
                atendimento.setData(resultado.getDate("Data").toLocalDate());
                atendimento.setId_atendente_transferido(resultado.getInt("id_atendente_transferido"));
                atendimento.setObservacao(resultado.getString("observacao"));
                atendimento.setId_cliente(resultado.getInt("id_cliente"));
                atendimento.setId_atendente(resultado.getInt("id_atendente"));
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
        String sql = "update tb_atendimento set id_atendimento=?, abandonada=?, Data=?, id_atendente_transferido=?, observacao=?, id_cliente=?, id_atendente=? where id_atendimento=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendimento.getId());
            stmt.setString(2, atendimento.getAbandonada());
            stmt.setDate(3, Date.valueOf(atendimento.getData()));
            stmt.setInt(4, atendimento.getId_atendente_transferido());
            stmt.setString(5, atendimento.getObservacao());
            stmt.setInt(6, atendimento.getId_cliente());
            stmt.setInt(7, atendimento.getId_atendente());
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
        Atendimento retorno = new Atendimento(sql, LocalDate.MAX, Integer.MIN_VALUE, sql, Integer.MIN_VALUE, Integer.MIN_VALUE);
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendimento.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                atendimento.setAbandonada(resultado.getString("abandonada"));
                atendimento.setData(resultado.getDate("Data").toLocalDate());
                atendimento.setId_atendente_transferido(resultado.getInt("id_atendente_transferido"));
                atendimento.setObservacao(resultado.getString("observacao"));
                atendimento.setId_cliente(resultado.getInt("id_cliente"));
                atendimento.setId_atendente(resultado.getInt("id_atendente"));
                retorno = atendimento;
                System.out.println("Atendimento localizado com sucesso!\n");
        }catch(SQLException e){
            System.out.println("Erro ao buscar atendimento: "+ e +"\n");
        }
        return retorno;
    }
}
