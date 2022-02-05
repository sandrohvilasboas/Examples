package br.com.sandrovilasboas.database_example.model;

import android.util.Log;

import br.com.sandrovilasboas.database_example.api.AppUtil;
import br.com.sandrovilasboas.database_example.controller.ICrud;

public class Produto {
    private int id;
    private String nome;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}
