package br.com.gorfo.mvnfxmlpadrao.beans;

public class Empresa {
    private Integer id;
    private String serial;
    private String cnpj;
    private String razao_social;
    private String fone;
    private String endereco;
    private String inscricao_estadual;
    private Integer id_tipo_sistema;

    public Empresa(String serial, String cnpj, String razao_social, String fone, String endereco, String inscricao_estadual, Integer id_tipo_sistema) {
        this.serial = serial;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.fone = fone;
        this.endereco = endereco;
        this.inscricao_estadual = inscricao_estadual;
        this.id_tipo_sistema = id_tipo_sistema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public Integer getId_tipo_sistema() {
        return id_tipo_sistema;
    }

    public void setId_tipo_sistema(Integer id_tipo_sistema) {
        this.id_tipo_sistema = id_tipo_sistema;
    }
    
}
