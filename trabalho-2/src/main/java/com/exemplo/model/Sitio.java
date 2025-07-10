package com.exemplo.model;

public class Sitio extends Imovel {

    private static final long serialVersionUID = 1L;

    private double areaTotal;

    public Sitio(String id, String endereco, double preco, Cliente proprietario, double areaTotal) {
        super(id, endereco, preco, proprietario);
        this.areaTotal = areaTotal;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sitio{" +
                "areaTotal=" + areaTotal +
                '}';
    }
}
