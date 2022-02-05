package br.com.sandrovilasboas.database_example.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.sandrovilasboas.database_example.api.AppUtil;
import br.com.sandrovilasboas.database_example.datamodel.ClienteDataModel;
import br.com.sandrovilasboas.database_example.datasource.AppDataBase;
import br.com.sandrovilasboas.database_example.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadosDoCliente;

    public ClienteController(Context context) {
        super(context);

        Log.i(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadosDoCliente = new ContentValues();

        dadosDoCliente.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoCliente.put(ClienteDataModel.EMAIL, obj.getEmail());

        return insert(ClienteDataModel.TABELA, dadosDoCliente);
    }

    @Override
    public boolean alterar(Cliente obj) {

        dadosDoCliente = new ContentValues();

        dadosDoCliente.put(ClienteDataModel.ID, obj.getId());
        dadosDoCliente.put(ClienteDataModel.NOME, obj.getNome());
        dadosDoCliente.put(ClienteDataModel.EMAIL, obj.getEmail());

        return update(ClienteDataModel.TABELA, dadosDoCliente);

    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes();
    }
}
