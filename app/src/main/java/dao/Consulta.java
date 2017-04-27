package dao;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import guilherme.androidmoviesbase.R;

/**
 * Created by guilherme on 27/04/17.
 */

public class Consulta extends Activity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filme_list);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{FilmeDAO.ID, FilmeDAO.TITULO};
        int[] idViews = new int[]{R.id.id, R.id.titulo};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.filme_list_content, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.filme_list);
        lista.setAdapter(adaptador);
    }
}