package com.exemplo.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.exemplo.model.Cliente;
import com.exemplo.model.Imovel;

public interface Vendas extends Remote {

    void cadastrarImovel(Imovel imovel) throws RemoteException;

    boolean venderImovel(String idImovel, Cliente comprador) throws RemoteException;

    String listarImoveisJson() throws RemoteException;

    String listarVendasJson() throws RemoteException;

}

