package amsi.dei.estg.ipleiria.pt.ficha4;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.SearchView; //nova versão

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.GestorLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;
import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.SingletonLivros;
import amsi.dei.estg.ipleiria.pt.ficha4.adaptadores.ListaLivroAdaper;

public class listadelivros extends AppCompatActivity {
public static final String NOVO_LIVRO ="NOVO_LIVRO";
    public static final String ID = "ID";
    public static final String TITULO = "TITULO";
    public static final String SERIE = "SERIE";
    public static final String AUTOR = "AUTOR";
    public static final String ANO = "ANO";
    public static final String IMAGEM = "IMAGEM";
    public static final Integer ADICIONAR = 1;
    public static final Integer ALTERAR = 2;


    //criar uma instancia da classe gestor de livros, para termos acesso ao livros
    private ListView listViewlivros;
   private ArrayList<Livro> listadelivros;

    //criar um adaptador
    private ListaLivroAdaper adaptador;
    private List<Livro> livros;


    /************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadelivros);
        setTitle("Lista de livros");


        listadelivros = SingletonLivros.getInstance().getLivros();
        listViewlivros = (ListView) findViewById(R.id.listView);

          //temos que carregar a list atraves do adaptador
          adaptador = new ListaLivroAdaper(this, listadelivros);
          listViewlivros.setAdapter(adaptador);


/************************************************************/
          listViewlivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                  Livro livrito = SingletonLivros.getInstance().pesquisarLivroID(i);

                  int livroid = livrito.getIdlivro();
                  String livrotitulo = livrito.getTitulo();
                  String livroserie = livrito.getSerie();
                  String livroautor = livrito.getAutor();
                  String livroano = livrito.getAno();
                  Integer livroimagem = livrito.getCapa();

                  Intent myitent = new Intent(getApplicationContext(),DetalhesLivro.class);


                  myitent.putExtra(ID, livroid);
                  myitent.putExtra(TITULO, livrotitulo);
                  myitent.putExtra(SERIE, livroserie);
                  myitent.putExtra(AUTOR, livroautor);
                  myitent.putExtra(IMAGEM, livroimagem);
                  myitent.putExtra(ANO, livroano);

                  startActivity(myitent);


              }
          });
/************************************************************/
/************************************************************/

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adaptador.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
/************************************************************/
    }

    public void onClickAdicionarLivro(View view) {
/*****************************************  *******************/
        Intent intent = new Intent(getApplicationContext(), DetalhesLivro.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_livros, menu);

        MenuItem itemPesquisa = menu.findItem(R.id.itemPesquisa);
        SearchView searchView= (SearchView) MenuItemCompat.getActionView(itemPesquisa);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }


            /*********************************************************************************************************************/

            @Override
            public boolean onQueryTextChange(String s) {
                // é o pesquisa por letra a letra

                final ArrayList<Livro> tempListaLivro = new ArrayList<>();

                for (Livro temp : listadelivros) {

                    if (temp.getTitulo().toLowerCase().contains(s.toLowerCase())) {
                        tempListaLivro.add(temp);
                    }
                }

                adaptador = new ListaLivroAdaper(getApplicationContext(), tempListaLivro);
                listViewlivros.setAdapter(adaptador);

                listViewlivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Livro livrito = tempListaLivro.get(i);

                        String livrotitulo = livrito.getTitulo();
                        String livroserie = livrito.getSerie();
                        String livroautor = livrito.getAutor();
                        String livroano = livrito.getAno();
                        Integer livroimagem = livrito.getCapa();

                        Intent myitent = new Intent(getApplicationContext(), DetalhesLivro.class);


                        myitent.putExtra("TITULO", livrotitulo);
                        myitent.putExtra("SERIE", livroserie);
                        myitent.putExtra("AUTOR", livroautor);
                        myitent.putExtra("IMAGEM", livroimagem);
                        myitent.putExtra("ANO", livroano);

                        startActivity(myitent);


                    }
                });

                return true;
            }
  /*********************************************************************************************************************/
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //verificar em qual botao que vamos clicar

        switch (item.getItemId())
        {
            case R.id.itemGrelha:
                Intent intentG = new Intent(getApplicationContext(), GrelhaLivros.class);
                startActivity(intentG);

                finish();
                return true;

            case R.id.itemEmail:


                return  true;



        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //PROCURAR POR ACTIVITY RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!! SNACKBAR!!!!
    }
}
