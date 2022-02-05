package br.com.sandrovilasboas.database_example.model;

import android.util.Log;

import br.com.sandrovilasboas.database_example.api.AppUtil;
import br.com.sandrovilasboas.database_example.controller.ICrud;

public class Cliente {
    private int id;
    private String nome;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
