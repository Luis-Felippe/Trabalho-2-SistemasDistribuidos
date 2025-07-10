package com.exemplo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import com.exemplo.interfaces.Vendas;
import com.exemplo.model.Cliente;
import com.exemplo.model.Imovel;
import com.exemplo.model.Casa;
import com.exemplo.model.Apartamento;
import com.exemplo.model.Sitio;

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Vendas vendaResidencial = (Vendas) registry.lookup("VendaResidencial");
            Vendas vendaRural = (Vendas) registry.lookup("VendaRural");

            Cliente comprador = new Cliente("Maria Silva", "123.456.789-00");

            System.out.println("\n== Testando Venda Residencial ==");

            Imovel casa = new Casa("C001", "Rua das Flores, 123", 300000.0, comprador, 2);
            Imovel ap = new Apartamento("A001", "Av. Central, 456", 200000.0, comprador, 5);

            vendaResidencial.cadastrarImovel(casa);
            vendaResidencial.cadastrarImovel(ap);

            System.out.println("Imóveis Residenciais (JSON):");
            System.out.println(vendaResidencial.listarImoveisJson());

            vendaResidencial.venderImovel("C001", comprador);

            System.out.println("Vendas Residenciais (JSON):");
            System.out.println(vendaResidencial.listarVendasJson());

            System.out.println("\n== Testando Venda Rural ==");

            Imovel sitio = new Sitio("S001", "Zona Rural, KM 10", 500000.0, comprador, 150.5);
            vendaRural.cadastrarImovel(sitio);

            System.out.println("Imóveis Rurais (JSON):");
            System.out.println(vendaRural.listarImoveisJson());

            vendaRural.venderImovel("S001", comprador);

            System.out.println("Vendas Rurais (JSON):");
            System.out.println(vendaRural.listarVendasJson());

        } catch (Exception e) {
            System.err.println("Erro no ClienteRMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

