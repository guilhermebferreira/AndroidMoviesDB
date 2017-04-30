package guilherme.androidmoviesbase.model;

/**
 * Created by guilherme on 26/04/17.
 */

public class Genero {
    private int codigo;
    private String nome;

    public Genero() {
        super();
    }

    public Genero(int codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
