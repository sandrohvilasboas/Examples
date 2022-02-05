package br.com.sandrovilasboas.database_example.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.sandrovilasboas.database_example.datamodel.ProdutoDataModel;
import br.com.sandrovilasboas.database_example.datasource.AppDataBase;
import br.com.sandrovilasboas.database_example.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto>{

    ContentValues dadosDoProduto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {

        dadosDoProduto = new ContentValues();

        dadosDoProduto.put(ProdutoDataModel.NOME, obj.getNome());
        dadosDoProduto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return insert(ProdutoDataModel.TABELA, dadosDoProduto);
    }

    @Override
    public boolean alterar(Produto obj) {

        dadosDoProduto = new ContentValues();

        dadosDoProduto.put(ProdutoDataModel.ID, obj.getId());
        dadosDoProduto.put(ProdutoDataModel.NOME, obj.getNome());
        dadosDoProduto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return true;
    }

    @Override
    public boolean deletar(int id) {
        dadosDoProduto = new ContentValues();


        return true;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();
        return lista;
    }
}
