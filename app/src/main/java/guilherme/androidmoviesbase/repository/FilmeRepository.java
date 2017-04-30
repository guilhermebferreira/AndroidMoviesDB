package guilherme.androidmoviesbase.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import guilherme.androidmoviesbase.utils.DataBaseUtil;

/**
 * Created by guilherme on 30/04/17.
 */

public class FilmeRepository {

    private SQLiteDatabase db;
    private DataBaseUtil banco;

    public FilmeRepository(Context context){
        banco = new DataBaseUtil(context);
    }

    public String insereDado(String titulo, String diretor, Integer anoLancamento, Integer genero){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataBaseUtil.getTITULO(), titulo);
        valores.put(DataBaseUtil.getDIRETOR(), diretor);
        valores.put(DataBaseUtil.getANO(), anoLancamento);
        valores.put(DataBaseUtil.getGENERO(), genero);



        resultado = db.insert(DataBaseUtil.getTABELA(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.getID(),banco.getTITULO(),banco.getDIRETOR(),banco.getANO(),banco.getGENERO()};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.getTABELA(), campos, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
