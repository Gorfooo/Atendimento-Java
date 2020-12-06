package br.com.gorfo.mvnfxmlpadrao.beans;

import java.time.LocalDate;

public class Atendente extends Pessoa{
    private Integer ramal;
    private String pis;
    private String pasep;
    private String setor;

    public Atendente(Integer ramal, String pis, String pasep, String setor, String nome, String cpf, String rg, String endereco, String fone, String email, LocalDate dataNascimento, String observacao) {
        super(nome, cpf, rg, endereco, fone, email, dataNascimento, observacao);
        this.ramal = ramal;
        this.pis = pis;
        this.pasep = pasep;
        this.setor = setor;
    }
    
    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getPasep() {
        return pasep;
    }

    public void setPasep(String pasep) {
        this.pasep = pasep;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
}
