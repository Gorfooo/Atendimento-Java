package br.com.gorfo.mvnfxmlpadrao.beans;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String revenda;

    public Cliente(String revenda, Integer id, String nome, String cpf, String rg, String endereco, String fone, String email, LocalDate dataNascimento, String observacao) {
        super(id, nome, cpf, rg, endereco, fone, email, dataNascimento, observacao);
        this.revenda = revenda;
    }

    public String getRevenda() {
        return revenda;
    }

    public void setRevenda(String revenda) {
        this.revenda = revenda;
    }
    
}
