package com.exemplo.model;

public class Casa extends Imovel {

    private static final long serialVersionUID = 1L;

    private int numeroAndares;

    public Casa(String id, String endereco, double preco, Cliente proprietario, int numeroAndares) {
        super(id, endereco, preco, proprietario);
        this.numeroAndares = numeroAndares;
    }

    public int getNumeroAndares() {
        return numeroAndares;
    }

    public void setNumeroAndares(int numeroAndares) {
        this.numeroAndares = numeroAndares;
    }

    @Override
    public String toString() {
        return super.toString() + ", Casa{" +
                "numeroAndares=" + numeroAndares +
                '}';
    }
}

