package amsi.dei.estg.ipleiria.pt.ficha4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.GestorLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;

public class DetalhesDinamicos extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtSerie;
    private TextView txtAutor;
    private TextView txtAno;

    private GestorLivros gestorLivros; // instanciar a class (atributo)

    private List<Livro> livros; // Lista de livros
    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_dinamicos);
        setTitle("Detalhes dinamicos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtSerie = (TextView) findViewById(R.id.txtSerie);
        txtAutor = (TextView) findViewById(R.id.txtAutor);
        txtAno = (TextView) findViewById(R.id.txtAno);

        gestorLivros = new GestorLivros(); // instanciar a class

        livros = gestorLivros.getlivros();

        livro = livros.get(0);

        txtTitulo.setText(livro.getTitulo());
        txtSerie.setText(livro.getSerie());
        txtAutor.setText(livro.getAutor());
        txtAno.setText(livro.getAno());
    }
}
