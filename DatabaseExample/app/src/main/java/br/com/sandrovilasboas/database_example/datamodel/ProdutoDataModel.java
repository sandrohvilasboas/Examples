package br.com.sandrovilasboas.database_example.datamodel;

public class ProdutoDataModel {

    // 1 - nome da tabela
    public static final String TABELA = "produto";

    // 2 - campos da tabela
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FORNECEDOR = "fornecedor";

    // 3 - criar query
    public static String queryCriarTabela = "";

    // 4 - criar metodo para criar a tabela

    public static String criarTabela(){
        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += NOME+" TEXT, ";
        queryCriarTabela += FORNECEDOR+" TEXT ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    };
}
