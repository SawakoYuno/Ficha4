package amsi.dei.estg.ipleiria.pt.ficha4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.GestorLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.SingletonLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.adaptadores.GrelhaLivroAdapter;
import amsi.dei.estg.ipleiria.pt.ficha4.adaptadores.ListaLivroAdaper;

public class GrelhaLivros extends AppCompatActivity {

    public static final String TITULO = "TITULO";
    public static final String SERIE = "SERIE";
    public static final String AUTOR = "AUTOR";
    public static final String ANO = "ANO";
    public static final String IMAGEM = "IMAGEM";

    private GrelhaLivroAdapter adaptador;
    //private List<Livro> capas;
    private GridView Grelha;

    private ArrayList<Livro> listadelivros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grelha_livros);

        listadelivros = SingletonLivros.getInstance().getLivros();
        Grelha = (GridView) findViewById(R.id.Grelha);

        adaptador = new GrelhaLivroAdapter(this, SingletonLivros.getInstance().getLivros());

        Grelha.setAdapter(adaptador);

        Grelha.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro livrito = SingletonLivros.getInstance().pesquisarLivroID(i);
                String livrotitulo = livrito.getTitulo();
                String livroserie = livrito.getSerie();
                String livroautor = livrito.getAutor();
                String livroano = livrito.getAno();
                Integer livroimagem = livrito.getCapa();

                Intent myitent = new Intent(getApplicationContext(),DetalhesLivro.class);


                myitent.putExtra("TITULO", livrotitulo);
                myitent.putExtra("SERIE", livroserie);
                myitent.putExtra("AUTOR", livroautor);
                myitent.putExtra("IMAGEM", livroimagem);
                myitent.putExtra("ANO", livroano);

                startActivity(myitent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_grelha_livros, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //verificar em qual botao que vamos clicar

        switch (item.getItemId())
        {
            case R.id.itemVistaLista:
                Intent intentG = new Intent(getApplicationContext(), listadelivros.class);
                startActivity(intentG);

                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAdicionarLivro(View view) {
    }
}
