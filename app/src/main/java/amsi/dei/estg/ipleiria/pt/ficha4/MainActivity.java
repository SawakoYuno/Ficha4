package amsi.dei.estg.ipleiria.pt.ficha4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mEmail;
    private TextView txtViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = getIntent().getStringExtra(LoginActivity.DADOS_EMAIL);
        //Toast.makeText(this, "" + mEmail, Toast.LENGTH_LONG);
        txtViewEmail = (TextView) findViewById(R.id.txtViewEmail);
        txtViewEmail.setText(mEmail);

    }

    public void onclickEst(View view) {
        Intent intent = new Intent(this, DetalhesEstatico.class);
        startActivity(intent);
    }

    public void onClickDin(View view) {
        Intent intent = new Intent(this, DetalhesDinamicos.class);
        startActivity(intent);
    }

    public void OnClickEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"+ mEmail));
        //intent.putExtra(Intent.EXTRA_EMAIL , new String[]{"sawako.yuno@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Ficha 04");
        intent.putExtra(Intent.EXTRA_TEXT , "Holla! caros amigos!");

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onclicklista(View view) {
        Intent intent = new Intent(this, listadelivros.class);
        startActivity(intent);
    }

    public void onClickGrelha(View view) {
        Intent intent = new Intent(this, GrelhaLivros.class);
        startActivity(intent);
    }
}
