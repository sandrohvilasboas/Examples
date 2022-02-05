package br.com.sandrovilasboas.database_example.datamodel;

public class ClienteDataModel {

    // 1 - nome da tabela
    public static final String TABELA = "cliente";

    // 2 - campos da tabela
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";

    // 3 - criar query
    public static String queryCriarTabela = "";

    // 4 - criar metodo para criar a tabela
    public static String criarTabela(){
        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += NOME+" TEXT, ";
        queryCriarTabela += EMAIL+" TEXT ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    };
}
