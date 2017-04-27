package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dao.FilmeDAO;

/**
 * Created by guilherme on 26/04/17.
 */

public class BancoController {
    private SQLiteDatabase db;
    private FilmeDAO banco;

    public BancoController(Context context){
        banco = new FilmeDAO(context);
    }

    public String insereDado(String titulo, String diretor, Integer anoLancamento, Integer genero){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(FilmeDAO.TITULO, titulo);
        valores.put(FilmeDAO.DIRETOR, diretor);
        valores.put(FilmeDAO.ANO, anoLancamento);
        valores.put(FilmeDAO.GENERO, genero);



        resultado = db.insert(FilmeDAO.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO,banco.DIRETOR,banco.ANO,banco.GENERO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
