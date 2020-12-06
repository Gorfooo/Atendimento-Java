package br.com.gorfo.mvnfxmlpadrao.beans;

import java.time.LocalDate;

public class Atendimento {
    private Integer id;
    private String abandonada;
    private LocalDate data;
    private Integer id_atendente_transferido;
    private String observacao;
    private Integer id_cliente;
    private Integer id_atendente;

    public Atendimento(String abandonada, LocalDate data, Integer id_atendente_transferido, String observacao, Integer id_cliente, Integer id_atendente) {
        this.abandonada = abandonada;
        this.data = data;
        this.id_atendente_transferido = id_atendente_transferido;
        this.observacao = observacao;
        this.id_cliente = id_cliente;
        this.id_atendente = id_atendente;
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

    public Integer getId_atendente_transferido() {
        return id_atendente_transferido;
    }

    public void setId_atendente_transferido(Integer id_atendente_transferido) {
        this.id_atendente_transferido = id_atendente_transferido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_atendente() {
        return id_atendente;
    }

    public void setId_atendente(Integer id_atendente) {
        this.id_atendente = id_atendente;
    }
    
}
