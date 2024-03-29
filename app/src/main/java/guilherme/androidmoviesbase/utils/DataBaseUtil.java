package guilherme.androidmoviesbase.utils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by guilherme on 30/04/17.
 */

public class DataBaseUtil extends SQLiteOpenHelper {
    protected static final String NOME_BANCO = "filmes.db";
    protected static final String TABELA = "filme";
    protected static final String ID = "codigo";
    protected static final String TITULO = "titulo";
    protected static final String DIRETOR = "diretor";

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getID() {
        return ID;
    }

    public static String getTITULO() {
        return TITULO;
    }

    public static String getDIRETOR() {
        return DIRETOR;
    }

    public static String getANO() {
        return ANO;
    }

    public static String getGENERO() {
        return GENERO;
    }

    public static String getTabelaGenero() {
        return TABELA_GENERO;
    }

    public static String getIdGenero() {
        return ID_GENERO;
    }

    public static String getNOME() {
        return NOME;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    protected static final String ANO = "anoLancamento";
    protected static final String GENERO = "genero";

    protected static final String TABELA_GENERO = "genero";
    protected static final String ID_GENERO = "codigo";
    protected static final String NOME = "nome";
    protected static final int VERSAO = 1;

    public DataBaseUtil(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableFilme(db);
        createTableGenero(db);
    }

    public void createTableFilme(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + " ("
                + ID + " integer primary key autoincrement, "
                + TITULO + " text, "
                + DIRETOR + " text, "
                + ANO + " integer, "
                + GENERO + " integer"
                + ")";
        db.execSQL(sql);


        String insert_filme_birds = "INSERT INTO " + TABELA + " VALUES (1, 'Os Pássaros', 'Alfred Hitchcock', 1963, 2)";
        String insert_filme_psycho = "INSERT INTO " + TABELA + " VALUES (2, 'Psicose ', 'Alfred Hitchcock', 1960, 2)";
        String insert_filme_jaws = "INSERT INTO " + TABELA + " VALUES (3, 'Tubarão ', 'Steven Spielberg', 1975, 1)";
        String insert_filme_jurassic = "INSERT INTO " + TABELA + " VALUES (4, 'Jurassic Park ', 'Steven Spielberg', 1993, 5)";
        String insert_filme_interstellar = "INSERT INTO " + TABELA + " VALUES (5, 'Interstellar ', 'Christopher Nolan', 2014, 5)";

        db.execSQL(insert_filme_birds);
        db.execSQL(insert_filme_psycho);
        db.execSQL(insert_filme_jaws);
        db.execSQL(insert_filme_jurassic);
        db.execSQL(insert_filme_interstellar);
    }

    public void createTableGenero(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA_GENERO + "("
                + ID_GENERO + " integer primary key autoincrement,"
                + NOME + " text"
                + ")";


        db.execSQL(sql);

        String insert_acao = "INSERT INTO " + TABELA_GENERO + " VALUES (1, 'Ação')";
        String insert_suspense = "INSERT INTO " + TABELA_GENERO + " VALUES (2, 'Suspense')";
        String insert_romance = "INSERT INTO " + TABELA_GENERO + " VALUES (3, 'Romance')";
        String insert_terror = "INSERT INTO " + TABELA_GENERO + " VALUES (4, 'Terror')";
        String insert_ficcao = "INSERT INTO " + TABELA_GENERO + " VALUES (5, 'Ficção Científica')";

        db.execSQL(insert_acao);
        db.execSQL(insert_suspense);
        db.execSQL(insert_romance);
        db.execSQL(insert_terror);
        db.execSQL(insert_ficcao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_GENERO);
        onCreate(db);
    }
}
