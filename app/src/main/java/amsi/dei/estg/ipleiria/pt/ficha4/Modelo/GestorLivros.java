package amsi.dei.estg.ipleiria.pt.ficha4.Modelo;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import amsi.dei.estg.ipleiria.pt.ficha4.R;

/**
 * Created by sawak on 24/10/2017.
 */

public class GestorLivros {

    private ArrayList<Livro> livros; //atributo lista livros


    public GestorLivros() {
        livros = new ArrayList<>(); //construtos que inicializa a lista
        gerarFakeData(); //temos que chamar aqui porque ele é privado
    }

    private void gerarFakeData(){//metodo
        livros.add(new Livro( "Programar android dinamico", "1ºtemporada", "AMSI TEAM" ,"2019", R.drawable.programarandroid2));
        livros.add(new Livro( "Programar android ", "2ºtemporada", "AMSI TEAM" ,"2018", R.drawable.programarandroid1));
        livros.add(new Livro( "Programar  dinamico", "3ºtemporada", "AMSI TEAM" ,"2017", R.drawable.programarandroid2));
        livros.add(new Livro( "Programar", "4ºtemporada", "AMSI TEAM" ,"2016", R.drawable.programarandroid1));


    }

    public ArrayList<Livro> getlivros(){//tem que ser public para aceder aos dados que vai returnar uma lista de livro
        return livros;
    }

}
