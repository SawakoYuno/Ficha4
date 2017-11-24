package amsi.dei.estg.ipleiria.pt.ficha4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

                        AlertDialog.Builder builder;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
                        } else {
                            builder = new AlertDialog.Builder(this);
                        }
                        builder.setTitle("Delete entry")
                                .setMessage("Tem a certeza que quer eliminar o livro?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with delete
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();


                        return true;


                }

                return super.onOptionsItemSelected(item);
            }
}
