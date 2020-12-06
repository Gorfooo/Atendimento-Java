package br.com.gorfo.mvnfxmlpadrao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
        public boolean inserir(Atendente Atendente){
        String sql = "insert into tb_atendente (nome,cpf,rg,endereco,fone,email,data_nascimento,observacao,ramal,pis,pasep,id_setor)values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Atendente.getNome());
            stmt.setString(2,Atendente.getCpf());        
            stmt.setString(3,Atendente.getRg()); 
            stmt.setString(4,Atendente.getEndereco()); 
            stmt.setString(5,Atendente.getFone()); 
            stmt.setString(6,Atendente.getEmail()); 
            stmt.setDate(7,Date.valueOf(Atendente.getDataNascimento()));
            stmt.setString(8,Atendente.getObservacao());
            stmt.setInt(9,Atendente.getRamal()); 
            stmt.setString(10,Atendente.getPis()); 
            stmt.setString(11,Atendente.getPasep()); 
            stmt.setInt(12,Atendente.getId_setor()); 
            stmt.execute();
            System.out.println("Atendente inserido com sucesso!\n");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao inserir atendente: "+ e +"\n");
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
                Atendente atendente = new Atendente(Integer.SIZE, sql, sql, Integer.MIN_VALUE, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
                atendente.setId(resultado.getInt("id_atendente"));
                atendente.setCpf(resultado.getString("cpf_atendente"));
                atendente.setDataNascimento((LocalDate) resultado.getObject("DataNascimento"));//medico.setDataNascimento((resultado.getDate("dataNascimento_medico")).toLocalDate());
                atendente.setEmail(resultado.getString("email"));
                atendente.setEndereco(resultado.getString("endereco"));
                atendente.setFone(resultado.getString("fone"));
                atendente.setId_setor(resultado.getInt("id_setor"));
                atendente.setNome(resultado.getString("nome"));
                atendente.setRamal(resultado.getInt("ramal"));
                atendente.setRg(resultado.getString("rg"));
                atendente.setObservacao(resultado.getString("observacao"));
                atendente.setPasep(resultado.getString("pasep"));
                atendente.setPis(resultado.getString("nome"));
                listaAtendente.add(atendente);
                System.out.println("Atendentes listados com sucesso!\n");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar atendente: "+ e +"\n");
        }
        return listaAtendente;
    }
    
    public boolean remover(Atendente Atendente){
        String sql = "delete from tb_atendente where id_atendente = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, Atendente.getId());
            stmt.execute();
            System.out.println("Atendente removido com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao remover atendente: "+ e +"\n");
            return false;
        }
    }
    
    public boolean atualizar(Atendente atendente){
        String sql = "update tb_atendente set id_atendente=?, nome=?, cpf=?, rg=?, endereco=?, fone=?, email=?, data_nascimento=?, observacao=?, ramal=?, pis=?, pasep=?, id_setor=? where id_atendente=?";
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
            stmt.setInt(13, atendente.getId_setor());
            stmt.execute();
            System.out.println("Atendente atualizado com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar atendente: "+ e +"\n");
            return false;
        }
    }
    
    public Atendente buscar(Atendente atendente){
        String sql = "select * from tb_atendente where id_atendente=?";
        Atendente retorno = new Atendente(Integer.SIZE, sql, sql, Integer.MIN_VALUE, sql, sql, sql, sql, sql, sql, LocalDate.MIN, sql);
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, atendente.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                atendente.setCpf(resultado.getString("cpf"));
                atendente.setDataNascimento(resultado.getDate("DataNascimento").toLocalDate());
                atendente.setEmail(resultado.getString("email"));
                atendente.setEndereco(resultado.getString("endereco"));
                atendente.setFone(resultado.getString("fone"));
                atendente.setId_setor(resultado.getInt("id_setor"));
                atendente.setNome(resultado.getString("nome"));
                atendente.setObservacao(resultado.getString("observacao"));
                atendente.setPasep(resultado.getString("pasep"));
                atendente.setPis(resultado.getString("pis"));
                atendente.setRamal(resultado.getInt("ramal"));
                atendente.setRg(resultado.getString("rg"));
                retorno = atendente;
                System.out.println("Atendente localizado com sucesso!\n");
        }catch (SQLException e){
            System.out.println("Erro ao buscar cliente: "+ e +"\n");
        }
        return atendente;
    }
}
