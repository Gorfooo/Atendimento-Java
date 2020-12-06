package br.com.gorfo.mvnfxmlpadrao.dao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendimento;
import java.sql.Connection;
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
                atendimento.setId(resultado.getInt("id_atendente"));
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
        
    public Atendimento buscar(Atendimento atendimento) {
        String sql = "SELECT * FROM enfermeiro WHERE id_enfermeiro=?";
        Atendimento atendimento = new Atendimento(sql, LocalDate.MAX, Integer.MIN_VALUE, sql, Integer.MIN_VALUE, Integer.MIN_VALUE);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, enfermeiro.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                atendimento.setId(resultado.getInt("id_enfermeiro"));
                atendimento.setNome(resultado.getString("nome_enfermeiro"));
                atendimento.setRg(resultado.getInt("rg_enfermeiro"));
                atendimento.setCpf(resultado.getInt("cpf_enfermeiro"));
                atendimento.setSexo("sexo_enfermeiro");
                atendimento.setDataNascimento((resultado.getDate("dataNascimento_enfermeiro").toLocalDate()));
                atendimento.setTelefone(resultado.getInt("telefone_enfermeiro"));
                atendimento.setDataAdmissao((resultado.getDate("dataAdmissao").toLocalDate()));
                retorno = atendimento;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar atendimento: "+ e +"\n");
        }
        return atendimento;
    }
    
    public boolean atualizar(Atendimento atendimento){
        String sql = "update tb_atendimento set ";
        try{
            
        }catch(SQLException e){
            System.out.println("Erro ao atualizar atendimento: "+ e +"\n");
        }
    }
}
