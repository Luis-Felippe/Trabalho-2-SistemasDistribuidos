package com.exemplo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.exemplo.interfaces.Vendas;
import com.exemplo.model.VendaResidencial;
import com.exemplo.model.VendaRural;

public class Servidor {

    public static void main(String[] args) {
        try {
            // Cria as implementações dos serviços
            Vendas vendaResidencial = new VendaResidencial();
            Vendas vendaRural = new VendaRural();

            // Cria (ou obtém) o Registry na porta padrão 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registra os serviços no Registry com nomes lógicos
            registry.rebind("VendaResidencial", vendaResidencial);
            registry.rebind("VendaRural", vendaRural);

            System.out.println("Servidor RMI está rodando e aguardando clientes...");
        } catch (Exception e) {
            System.err.println("Erro no Servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
