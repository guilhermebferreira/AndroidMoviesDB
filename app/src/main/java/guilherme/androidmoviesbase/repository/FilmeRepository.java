package guilherme.androidmoviesbase.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import guilherme.androidmoviesbase.model.Filme;
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

    public String Salvar(Filme filme){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put(banco.getTITULO(), filme.getTitulo());
        valores.put(DataBaseUtil.getDIRETOR(), filme.getDiretor());
        valores.put(DataBaseUtil.getANO(), filme.getAnoLancamento());
        valores.put(DataBaseUtil.getGENERO(), filme.getGenero());

        resultado = db.insert(DataBaseUtil.getTABELA(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }


    public void Atualizar(Filme filme){

        ContentValues valores =  new ContentValues();


        valores.put(DataBaseUtil.getTITULO(), filme.getTitulo());
        valores.put(DataBaseUtil.getDIRETOR(), filme.getDiretor());
        valores.put(DataBaseUtil.getANO(), filme.getAnoLancamento());
        valores.put(DataBaseUtil.getGENERO(), filme.getGenero());


        db = banco.getWritableDatabase();
        db.update(DataBaseUtil.getTABELA(), valores, DataBaseUtil.getID()+" = ?", new String[]{Integer.toString(filme.getCodigo())});
        db.close();
    }

    public Integer Excluir(int codigo){

        Integer resultado;

        db = banco.getWritableDatabase();
        resultado = db.delete(DataBaseUtil.getTABELA(), DataBaseUtil.getID()+" = ?", new String[]{Integer.toString(codigo)});
        db.close();

        return resultado;

    }

    public Filme GetFilme(int codigo){

        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DataBaseUtil.getTABELA()+" WHERE "+DataBaseUtil.getID()+"="+ codigo,null);

        cursor.moveToFirst();

        Filme filme =  new Filme();

        filme.setCodigo(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getID())));
        filme.setTitulo(cursor.getString(cursor.getColumnIndex(DataBaseUtil.getTITULO())));
        filme.setDiretor(cursor.getString(cursor.getColumnIndex(DataBaseUtil.getDIRETOR())));
        filme.setAnoLancamento(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getANO())));
        filme.setGenero(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getGENERO())));

        return filme;

    }


    public List<Filme> SelecionarTodos(){

        List<Filme> filmes = new ArrayList<Filme>();


        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT "+DataBaseUtil.getID()+",      ");
        stringBuilderQuery.append("        "+DataBaseUtil.getTITULO()+",        ");
        stringBuilderQuery.append("        "+DataBaseUtil.getDIRETOR()+",    ");
        stringBuilderQuery.append("        "+DataBaseUtil.getANO()+",        ");
        stringBuilderQuery.append("        "+DataBaseUtil.getGENERO()+"  ");
        stringBuilderQuery.append("  FROM  "+DataBaseUtil.getTABELA()+"       ");
        stringBuilderQuery.append(" ORDER BY "+DataBaseUtil.getTITULO()+"       ");

        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(stringBuilderQuery.toString(), null);

        cursor.moveToFirst();

        Filme filme;

        while (!cursor.isAfterLast()){

            filme =  new Filme();

            filme.setCodigo(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getID())));
            filme.setTitulo(cursor.getString(cursor.getColumnIndex(DataBaseUtil.getTITULO())));
            filme.setDiretor(cursor.getString(cursor.getColumnIndex(DataBaseUtil.getDIRETOR())));
            filme.setAnoLancamento(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getANO())));
            filme.setGenero(cursor.getInt(cursor.getColumnIndex(DataBaseUtil.getGENERO())));

            filmes.add(filme);

            cursor.moveToNext();
        }

        return filmes;

    }

}
