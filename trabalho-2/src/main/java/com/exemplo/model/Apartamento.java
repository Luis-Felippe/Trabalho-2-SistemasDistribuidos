package com.exemplo.model;

public class Apartamento extends Imovel {

    private static final long serialVersionUID = 1L;

    private int andar;

    public Apartamento(String id, String endereco, double preco, Cliente proprietario, int andar) {
        super(id, endereco, preco, proprietario);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Apartamento{" +
                "andar=" + andar +
                '}';
    }
}
