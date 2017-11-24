package amsi.dei.estg.ipleiria.pt.ficha4.Modelo;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;

import amsi.dei.estg.ipleiria.pt.ficha4.R;

/**
 * Created by Jessica on 14/11/2017.
 */

public class SingletonLivros {
    private static SingletonLivros INSTANCE = null;
    private ArrayList<Livro> livros; //atributo lista livros

    public static synchronized SingletonLivros getInstance() {
        if( INSTANCE == null ){
            INSTANCE = new SingletonLivros();
        }
        return INSTANCE;
    }

    private SingletonLivros() {
        livros = new ArrayList<>();
       gerarFakeData();

    }

    private void gerarFakeData(){//metodo
        livros.add(new Livro( "Programar android dinamico", "1ºtemporada", "AMSI TEAM" ,"2019", R.drawable.programarandroid2));
        livros.add(new Livro( "Programar android ", "2ºtemporada", "AMSI TEAM" ,"2018", R.drawable.programarandroid1));
        livros.add(new Livro( "Programar  dinamico", "3ºtemporada", "AMSI TEAM" ,"2017", R.drawable.programarandroid2));
        livros.add(new Livro( "Programar", "4ºtemporada", "AMSI TEAM" ,"2016", R.drawable.programarandroid1));

        livros.add(new Livro( "exemplo", "4ºtemporada", "AMSI TEAM" ,"2016", R.drawable.programarandroid1));


    }
    public ArrayList<Livro> getLivros(){

       return livros;
    }

    public boolean adicionarLivro(Livro livro)
    {
        return livros.add(livro);
    }

    public boolean removerLivro(Integer id)
    {
        return livros.remove(id);
    }

    public boolean editarLivro(Livro livro)
    {
        Livro livrito = livros.set(livro.getIdlivro(), livro); //vai pegar a posicao do livro e substitui-lo

        if (livros.contains(livrito))
        {
            return true;
        }

           else{
                 return false;
                }
    }

    public Livro pesquisarLivroID(Integer id)
    {
        return livros.get(id);
    }

}
