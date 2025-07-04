package com.exemplo.model;

import java.io.Serializable;

public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String endereco;
    private double preco;
    private Cliente proprietario; 

    public Imovel(String id, String endereco, double preco, Cliente proprietario) {
        this.id = id;
        this.endereco = endereco;
        this.preco = preco;
        this.proprietario = proprietario;
    }

    public String getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPreco() {
        return preco;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id='" + id + '\'' +
                ", endereco='" + endereco + '\'' +
                ", preco=" + preco +
                ", proprietario=" + (proprietario != null ? proprietario.getNome() : "Nenhum") +
                '}';
    }
}

