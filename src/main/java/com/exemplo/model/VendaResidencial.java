package com.exemplo.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.exemplo.interfaces.Vendas;
import com.google.gson.Gson;

public class VendaResidencial extends UnicastRemoteObject implements Vendas {

    private static final long serialVersionUID = 1L;

    private List<Imovel> imoveisResidenciais;
    private List<String> vendasResidenciais;

    public VendaResidencial() throws RemoteException {
        imoveisResidenciais = new ArrayList<>();
        vendasResidenciais = new ArrayList<>();
    }

    @Override
    public void cadastrarImovel(Imovel imovel) throws RemoteException {
        // Só aceita Casa ou Apartamento
        if (imovel instanceof Casa || imovel instanceof Apartamento) {
            imoveisResidenciais.add(imovel);
        } else {
            System.out.println("Tipo de imóvel inválido para Venda Residencial.");
        }
    }

    @Override
    public String listarImoveisJson() throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(imoveisResidenciais);
    }

    @Override
    public String listarVendasJson() throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(vendasResidenciais);
    }
    

    @Override
    public boolean venderImovel(String idImovel, Cliente comprador) throws RemoteException {
        Iterator<Imovel> it = imoveisResidenciais.iterator();
        while (it.hasNext()) {
            Imovel imovel = it.next();
            if (imovel.getId().equals(idImovel)) {
                vendasResidenciais.add("Imóvel " + idImovel + " vendido para " + comprador.getNome());
                it.remove();
                return true;
            }
        }
        return false;
    }

}
