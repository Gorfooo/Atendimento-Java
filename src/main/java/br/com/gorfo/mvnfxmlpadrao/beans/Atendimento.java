package br.com.gorfo.mvnfxmlpadrao.beans;

import java.time.LocalDate;

public class Atendimento {
    private Integer id;
    private String abandonada;
    private LocalDate data;
    private String atendente_transferido;
    private String observacao;
    private String cliente;
    private String atendente;

    public Atendimento(Integer id, String abandonada, LocalDate data, String atendente_transferido, String observacao, String cliente, String atendente) {
        this.id = id;
        this.abandonada = abandonada;
        this.data = data;
        this.atendente_transferido = atendente_transferido;
        this.observacao = observacao;
        this.cliente = cliente;
        this.atendente = atendente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbandonada() {
        return abandonada;
    }

    public void setAbandonada(String abandonada) {
        this.abandonada = abandonada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAtendente_transferido() {
        return atendente_transferido;
    }

    public void setAtendente_transferido(String atendente_transferido) {
        this.atendente_transferido = atendente_transferido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

}
