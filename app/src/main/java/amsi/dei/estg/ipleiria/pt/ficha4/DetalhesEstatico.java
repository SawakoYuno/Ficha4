package amsi.dei.estg.ipleiria.pt.ficha4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalhesEstatico extends AppCompatActivity {

    private TextView txttitulo;
    private TextView txtserie;
    private TextView txtautor;
    private TextView txtano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_estatico);
        setTitle("Detalhes estaticos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txttitulo = (TextView) findViewById(R.id.txttitulo);
        txtserie =(TextView) findViewById(R.id.txtserieE);
        txtautor =(TextView) findViewById(R.id.txtautorE);
        txtano =(TextView) findViewById(R.id.txtanoE);

        txttitulo.setText("Programar Android em AMSI");
        txtserie.setText("Android Saga");
        txtautor.setText("Equipa de ASI");
        txtano.setText("2017!");

    }
}
