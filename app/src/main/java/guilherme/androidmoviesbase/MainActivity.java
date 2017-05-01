package guilherme.androidmoviesbase;

import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import guilherme.androidmoviesbase.model.Filme;
import guilherme.androidmoviesbase.repository.FilmeRepository;
import guilherme.androidmoviesbase.utils.FilmeConsultarAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listViewFilmes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //VINCULANDO O LISTVIEW DA TELA AO OBJETO CRIADO
        listViewFilmes = (ListView)this.findViewById(R.id.listViewFilmes);



        //CHAMA O MÉTODO QUE CARREGA AS PESSOAS CADASTRADAS NA BASE DE DADOS
        this.CarregarCadastros();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    //MÉTODO QUE CONSULTA AS PESSOAS CADASTRADAS
    protected  void CarregarCadastros(){

        FilmeRepository filmeRepository =  new FilmeRepository(this);

        //BUSCA AS PESSOAS CADASTRADAS
        List<Filme> pessoas = filmeRepository.SelecionarTodos();

        //SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
        listViewFilmes.setAdapter(new FilmeConsultarAdapter(this, pessoas));
    }
}
