package br.com.sandrovilasboas.database_example.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import br.com.sandrovilasboas.database_example.api.AppUtil;
import br.com.sandrovilasboas.database_example.datamodel.ClienteDataModel;
import br.com.sandrovilasboas.database_example.datamodel.ProdutoDataModel;
import br.com.sandrovilasboas.database_example.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "DatabaseExample.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.i(AppUtil.TAG, "AppDataBase: Criando Banco de dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());
        Log.i(AppUtil.TAG, "onCreate: " + ClienteDataModel.criarTabela());
        Log.i(AppUtil.TAG, "onCreate: " + ProdutoDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "insert: " + e.getMessage());
        }

        return retorno;
    }

    public boolean deleteById(String tabela, int id) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "delete: " + e.getMessage());
        }

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados) {
        db = getWritableDatabase();

        boolean retorno = false;
        try {
            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "update: " + e.getMessage());
        }
        return retorno;
    }

    public List<Cliente> getAllClientes(){
        List<Cliente> clientes = new ArrayList<>();

        db = getReadableDatabase();
        String sql = "SELECT * FROM CLIENTE";
        Cursor cursor;
        cursor = db.rawQuery(sql, null);
        Cliente cliente;

        if(cursor.moveToFirst()){

            do {
                cliente = new Cliente();

                cliente.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID) + 0));
                cliente.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME) + 0));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL) + 0));

                clientes.add(cliente);
            } while (cursor.moveToNext());
        }
        return clientes;
    };
}
