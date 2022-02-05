package br.com.sandrovilasboas.database_example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import br.com.sandrovilasboas.database_example.R;
import br.com.sandrovilasboas.database_example.api.AppUtil;
import br.com.sandrovilasboas.database_example.controller.ClienteController;
import br.com.sandrovilasboas.database_example.controller.ProdutoController;
import br.com.sandrovilasboas.database_example.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());
        obj = new Cliente();
        obj.setNome("Sandro Vilas Boas");
        obj.setEmail("sandrinhovilasboas@gmail.com");

        if(clienteController.incluir(obj)){
            Toast.makeText(
                    MainActivity.this,
                    "Cliente "+obj.getNome()+" incluido com sucesso!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(
                    MainActivity.this,
                    "Houve um erro ao incluir o cliente "+obj.getNome(),
                    Toast.LENGTH_LONG).show();
        }

        for(Cliente obj: clienteController.listar()){
            Log.i(AppUtil.TAG, "Listar: "+ obj.getId());
        }

    }

}