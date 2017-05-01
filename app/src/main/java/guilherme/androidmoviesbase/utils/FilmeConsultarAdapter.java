package guilherme.androidmoviesbase.utils;

/**
 * Created by guilherme on 30/04/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import guilherme.androidmoviesbase.MainActivity;
import guilherme.androidmoviesbase.R;
import guilherme.androidmoviesbase.model.Filme;
import guilherme.androidmoviesbase.repository.FilmeRepository;

public class FilmeConsultarAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;

    //CRIANDO UMA LISTA DE PESSOAS
    List<Filme> filme =  new ArrayList<Filme>();

    //CIRANDO UM OBJETO DA NOSSA CLASSE QUE FAZ ACESSO AO BANCO DE DADOS
    FilmeRepository  filmeRepository;

    //CRIANDO UM OBJETO DA NOSSA ATIVIDADE QUE CONTEM A LISTA
    private MainActivity listActivity;

    //CONSTRUTOR QUE VAI RECEBER A NOSSA ATIVIDADE COMO PARAMETRO E A LISTA DE PESSOAS QUE VAI RETORNAR
    //DA NOSSA BASE DE DADOS
    public FilmeConsultarAdapter(MainActivity listActivity, List<Filme> filme ) {

        this.filme       =  filme;
        this.listActivity  =  listActivity;
        this.layoutInflater     = (LayoutInflater) this.listActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.filmeRepository   = new FilmeRepository(listActivity);
    }

    //RETORNA A QUANTIDADE DE REGISTROS DA LISTA
    @Override
    public int getCount(){

        return filme.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

 
        final View viewLinhaLista = layoutInflater.inflate(R.layout.fragment_filme,null);
 
        //TextView textViewCodigo          = (TextView) viewLinhaLista.findViewById(R.id.id);
 
        TextView textViewTitulo           = (TextView) viewLinhaLista.findViewById(R.id.titulo);
 
        TextView textViewDiretor       = (TextView) viewLinhaLista.findViewById(R.id.diretor);
 
        //textViewCodigo.setText(String.valueOf(filme.get(position).getCodigo()));
 
        textViewTitulo.setText(filme.get(position).getTitulo());
 
        textViewDiretor.setText(filme.get(position).getDiretor());
 
        Button buttonExcluir             = (Button)   viewLinhaLista.findViewById(R.id.deleteButton);

 
        Button   buttonEditar            = (Button)   viewLinhaLista.findViewById(R.id.editButton);


 
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

 
                filmeRepository.Excluir(filme.get(position).getCodigo());
 
                Toast.makeText(listActivity, "Registro excluido com sucesso!", Toast.LENGTH_LONG).show();
 
                AtualizarLista();

            }
        });
 
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return viewLinhaLista;
    }
  
    //ATUALIZA A LISTTA DEPOIS DE EXCLUIR UM REGISTRO
    public void AtualizarLista(){

        this.filme.clear();
        this.filme = filmeRepository.SelecionarTodos();
        this.notifyDataSetChanged();
    }

}