package android.streetmusic;

import android.content.Intent;
import android.streetmusic.activities.ActivityCadCliente;
import android.streetmusic.activities.ActivityLogin;
import android.streetmusic.db.AppDatabase;
import android.streetmusic.db.dao.UsuarioDao;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btCadastro = findViewById(R.id.botaoCadastroMain);
        btCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ActivityCadCliente.class);
                startActivity(it);
            }
        });
        final Button btLogin = findViewById(R.id.botaoLoginMain);
        btLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ActivityLogin.class);
                startActivity(it);
            }
        });
    }
}
