package amsi.dei.estg.ipleiria.pt.ficha4.Modelo;

/**
 * Created by sawak on 24/10/2017.
 */

public class Livro {
    private int idlivro;
    private String titulo;// tem 5 atributos
    private String serie;
    private String autor;
    private String ano;
    private Integer capa;
    private static int autoincrementId = 1;

    public String getTitulo() {
        return titulo;
    }// metodos acessores

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(String idlivro) {
        this.autor = idlivro;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getCapa() {
        return capa;
    }

    public void setCapa(Integer capa) {
        this.capa = capa;
    }

    public Livro(String titulo, String serie, String autor, String ano, Integer capa) { //construtor
        this.idlivro = autoincrementId++;
        this.titulo = titulo;
        this.serie = serie;
        this.autor = autor;
        this.ano = ano;
        this.capa = capa;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", serie='" + serie + '\'' +
                ", autor='" + autor + '\'' +
                ", ano='" + ano + '\'' +
                ", capa=" + capa +
                '}';
    }
}
