package amsi.dei.estg.ipleiria.pt.ficha4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.GestorLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;
import amsi.dei.estg.ipleiria.pt.ficha4.adaptadores.ListaLivroAdaper;

public class DetalhesLivro extends AppCompatActivity {

    private TextView Dtitulo;
    private TextView Dserie;
    private TextView Dautor;
    private TextView Dano;
    private ImageView imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Dtitulo = (TextView) findViewById(R.id.detalhesTitulo);
        Dserie = (TextView) findViewById(R.id.detalhesSerie);
        Dautor = (TextView) findViewById(R.id.detalhesAutor);
        Dano = (TextView) findViewById(R.id.detalhesAno);
        imagem = (ImageView) findViewById(R.id.imagemDetalhes);

        Intent myintent= getIntent();

        Dtitulo.setText(myintent.getStringExtra(listadelivros.TITULO));
        Dserie.setText(myintent.getStringExtra(listadelivros.SERIE));
        Dautor.setText(myintent.getStringExtra(listadelivros.AUTOR));
        Dano.setText(myintent.getStringExtra(listadelivros.ANO));
        imagem.setImageResource(myintent.getIntExtra(listadelivros.IMAGEM.toString(), R.drawable.programarandroid1));

    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_detalhe_livros, menu);
                return super.onCreateOptionsMenu(menu);
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                //verificar em qual botao que vamos clicar

                switch (item.getItemId())
                {
                    case R.id.itemRemover:

                        //codigo

                        finish();
                        return true;

                }

                return super.onOptionsItemSelected(item);
            }
}
