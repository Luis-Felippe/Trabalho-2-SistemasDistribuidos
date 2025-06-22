package com.exemplo.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.exemplo.interfaces.Vendas;
import com.google.gson.Gson;

public class VendaRural extends UnicastRemoteObject implements Vendas {

    private static final long serialVersionUID = 1L;

    private List<Imovel> imoveisRurais;
    private List<String> vendasRurais;

    public VendaRural() throws RemoteException {
        imoveisRurais = new ArrayList<>();
        vendasRurais = new ArrayList<>();
    }

    @Override
    public void cadastrarImovel(Imovel imovel) throws RemoteException {
        // Só aceita Sitio
        if (imovel instanceof Sitio) {
            imoveisRurais.add(imovel);
        } else {
            System.out.println("Tipo de imóvel inválido para Venda Rural.");
        }
    }

    @Override
    public String listarImoveisJson() throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(imoveisRurais);
    }

    @Override
    public String listarVendasJson() throws RemoteException {
        Gson gson = new Gson();
        return gson.toJson(vendasRurais);
    }

    @Override
    public boolean venderImovel(String idImovel, Cliente comprador) throws RemoteException {
        Iterator<Imovel> it = imoveisRurais.iterator();
        while (it.hasNext()) {
            Imovel imovel = it.next();
            if (imovel.getId().equals(idImovel)) {
                vendasRurais.add("Sitio " + idImovel + " vendido para " + comprador.getNome());
                it.remove();
                return true;
            }
        }
        return false;
    }

    
}
