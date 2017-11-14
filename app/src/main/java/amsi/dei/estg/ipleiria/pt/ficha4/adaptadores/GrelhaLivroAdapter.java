package amsi.dei.estg.ipleiria.pt.ficha4.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;

import amsi.dei.estg.ipleiria.pt.ficha4.Modelo.Livro;
import amsi.dei.estg.ipleiria.pt.ficha4.R;

/**
 * Created by Jessica on 07/11/2017.
 */

public class GrelhaLivroAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Livro> capas;

    public GrelhaLivroAdapter (Context context, ArrayList<Livro> capas)
    {
        this.context = context;
        this.capas = capas;
    }

    @Override
    public int getCount() {
        return capas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_item_grelha_livro, null);
        }

        ImageView imagem = (ImageView) convertView.findViewById(R.id.imageViewCapaLivro);

        Livro capa = capas.get(position);

        imagem.setImageResource(capa.getCapa());

        return convertView;
    }

}
