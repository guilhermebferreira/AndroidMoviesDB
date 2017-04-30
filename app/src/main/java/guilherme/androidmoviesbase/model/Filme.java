package guilherme.androidmoviesbase.model;

/**
 * Created by guilherme on 26/04/17.
 */

public class Filme {
    private int codigo;
    private String titulo;
    private String diretor;
    private Integer anoLancamento;
    private int genero;

    public Filme() {
        super();
    }

    public Filme(int codigo, String titulo, String diretor, Integer anoLancamento, int genero) {
        super();
        this.codigo = codigo;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

}
