package guilherme.androidmoviesbase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import guilherme.androidmoviesbase.FilmeFragment.OnListFragmentInteractionListener;

import guilherme.androidmoviesbase.model.Filme;
import guilherme.androidmoviesbase.repository.FilmeRepository;
import guilherme.androidmoviesbase.utils.FilmeConsultarAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Filme} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFilmeRecyclerViewAdapter extends RecyclerView.Adapter<MyFilmeRecyclerViewAdapter.ViewHolder> {

    private final List<Filme> mValues;
    private final OnListFragmentInteractionListener mListener;

    FilmeRepository  filmeRepository;

    private FilmeConsultarAdapter consultarActivity;

    public MyFilmeRecyclerViewAdapter(List<Filme> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_filme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).getCodigo());
        holder.mTituloView.setText(mValues.get(position).getTitulo());
        holder.mDiretorView.setText(mValues.get(position).getDiretor());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        public final TextView mTituloView;
        public final TextView mDiretorView;
        public Filme mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            mTituloView = (TextView) view.findViewById(R.id.titulo);
            mDiretorView = (TextView) view.findViewById(R.id.diretor);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTituloView.getText() + "'" + " '" + mDiretorView.getText() + "'";
        }
    }
}
