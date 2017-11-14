package amsi.dei.estg.ipleiria.pt.ficha4.adaptadores;

import android.content.Context;
import android.text.Layout;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;
import amsi.dei.estg.ipleiria.pt.ficha4.R;

/**
 * Created by 2160475 on 31/10/2017.
 */

public class ListaLivroAdaper extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Livro> livros;

//temos que criar um constutor e temos que passar o context e a lista<livros>
    //tem que ter o mesmo nome da class!!!
    public ListaLivroAdaper (Context context, ArrayList<Livro> livros)
    {
        this.context = context;
        this.livros = livros;
    }

    //livros.size
    @Override
    public int getCount() {
        return livros.size();
    }

    //get.position
    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    //get.position
    @Override
    public long getItemId(int position) {
        return position;
    }

    //metedo mais importante da vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //colocar o que está na lista dentro das text com "find by id..."
        //Livro livro = ListaLivro.get()

        if (inflater == null)
        {
           inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_lista_livro, null);
        }

        TextView titulo = (TextView) convertView.findViewById(R.id.txtTitulo);
        TextView serie = (TextView) convertView.findViewById(R.id.txtSerie);
        TextView autor = (TextView) convertView.findViewById(R.id.txtAutor);
        TextView ano = (TextView) convertView.findViewById(R.id.txtAno);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView5);

        //ir ao livro para ir buscar cada livro naquela posição
        Livro livro = livros.get(position);

        titulo.setText(livro.getTitulo());
        serie.setText(livro.getSerie());
        autor.setText(livro.getAutor());
        ano.setText(livro.getAno());
        image.setImageResource(livro.getCapa());

        return convertView;

    }
}
