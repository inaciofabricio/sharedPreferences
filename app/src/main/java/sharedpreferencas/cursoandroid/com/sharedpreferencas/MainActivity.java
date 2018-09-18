package sharedpreferencas.cursoandroid.com.sharedpreferencas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoNome;
    private Button botaoSalvar;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA = "arquivo preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textoNome = (EditText) findViewById(R.id.textoNomeId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvar);
        textoExibicao = (TextView) findViewById(R.id.textoExibicaoId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences  sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(textoNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor o nome.", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("nome",textoNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Olá, " + textoNome.getText().toString());
                }
            }
        });

        SharedPreferences sp = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sp.contains("nome")){
            String nomeUsuario = sp.getString("nome","usuário");
            textoExibicao.setText("Olá, " + nomeUsuario);
        }else{
            textoExibicao.setText("Olá, usuário não definido");
        }


    }
}
