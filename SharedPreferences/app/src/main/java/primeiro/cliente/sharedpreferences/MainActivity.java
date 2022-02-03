 package primeiro.cliente.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

 public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AULA_SHARED_PREFERENCES";
    private static final String PREF_NAME = "SharedPreferences";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: Rodando");

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        Log.i(TAG, "onCreate: Pasta Shared Criada!!!");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.90f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);
        dados.apply();


        //dados.clear + dados.apply para limpar o shared;
        //dados.remove(campo) + dados.apply para remover um unico elemento do shared;

        Log.i(TAG, "onCreate: Dados para serem Salvos");
        Log.i(TAG, "onCreate: Nome "+ sharedPreferences.getString("nomeProduto", "fora de estoque"));
        Log.i(TAG, "onCreate: Codigo "+ sharedPreferences.getInt("codigoProduto", -1));
        Log.i(TAG, "onCreate: Preco "+ sharedPreferences.getFloat("precoProduto", 0.0f));
        Log.i(TAG, "onCreate: Estoque "+ sharedPreferences.getBoolean("estoque", false));



    }
}