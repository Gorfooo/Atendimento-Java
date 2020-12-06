package br.com.gorfo.mvnfxmlpadrao.dao;

import br.com.gorfo.mvnfxmlpadrao.beans.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
        public boolean inserir(Empresa empresa){
        String sql = "insert into tb_empresa (serial,cnpj,razao_social,fone,endereco,inscricao_estadual,id_tipo_sistema)values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,empresa.getSerial());
            stmt.setString(2,empresa.getCnpj());        
            stmt.setString(3,empresa.getRazao_social()); 
            stmt.setString(4,empresa.getFone()); 
            stmt.setString(5,empresa.getEndereco()); 
            stmt.setString(6,empresa.getInscricao_estadual()); 
            stmt.setInt(7,empresa.getId_tipo_sistema());
            stmt.execute();
            System.out.println("Empresa inserida com sucesso!\n");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao inserir empresa: "+ e +"\n");
            return false;
        }
    }
    
    public List<Empresa> listar(){
        String sql = "select * from tb_empresa";
        List<Empresa> listaEmpresa = new ArrayList();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                Empresa empresa = new Empresa(sql, sql, sql, sql, sql, sql, Integer.MIN_VALUE);
                empresa.setId(resultado.getInt("id_empresa"));
                empresa.setSerial(resultado.getString("serial"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setRazao_social(resultado.getString("razao_social"));
                empresa.setFone(resultado.getString("fone"));
                empresa.setEndereco(resultado.getString("endereco"));
                empresa.setInscricao_estadual(resultado.getString("inscricao_estadual"));
                empresa.setId_tipo_sistema(resultado.getInt("id_tipo_sistema"));
                listaEmpresa.add(empresa);
                System.out.println("Empresas listadas com sucesso!\n");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar empresas: "+ e +"\n");
        }
        return listaEmpresa;
    }
    
    public boolean remover(Empresa empresa){
        String sql = "delete from tb_empresa where id_empresa = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empresa.getId());
            stmt.execute();
            System.out.println("Empresa removida com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao remover empresa: "+ e +"\n");
            return false;
        }
    }
    
    public boolean atualizar(Empresa empresa){
        String sql = "update tb_empresa set id_empresa=?, serial=?, cnpj=?, razao_social=?, fone=?, endereco=?, inscricao_estadual=?, id_tipo_sistema=? where id_empresa=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empresa.getId());
            stmt.setString(2, empresa.getSerial());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getRazao_social());
            stmt.setString(5, empresa.getFone());
            stmt.setString(6, empresa.getEndereco());
            stmt.setString(7, empresa.getInscricao_estadual());
            stmt.setInt(8, empresa.getId_tipo_sistema());
            stmt.execute();
            System.out.println("Empresa atualizada com sucesso!\n");
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar empresa: "+ e +"\n");
            return false;
        }
    }
    
    public Empresa buscar(Empresa empresa){
        String sql = "select * from tb_empresa where id_empresa=?";
        Empresa retorno = new Empresa(sql, sql, sql, sql, sql, sql, Integer.MIN_VALUE);
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empresa.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next());
                empresa.setSerial(resultado.getString("serial"));
                empresa.setCnpj(resultado.getString("cnpj"));
                empresa.setRazao_social(resultado.getString("razao_social"));
                empresa.setFone(resultado.getString("fone"));
                empresa.setEndereco(resultado.getString("endereco"));
                empresa.setInscricao_estadual(resultado.getString("inscricao_estadual"));
                empresa.setId_tipo_sistema(resultado.getInt("id_tipo_sistema"));
                retorno = empresa;
                System.out.println("Empresa localizada com sucesso!\n");
        }catch (SQLException e){
            System.out.println("Erro ao buscar empresa: "+ e +"\n");
        }
        return retorno;
    }
}
