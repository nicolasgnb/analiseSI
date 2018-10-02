package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.MainActivity;
import android.streetmusic.R;
import android.streetmusic.db.utils.Session;
import android.view.View;
import android.widget.Button;

public class ActivityPerfilUsuario extends Activity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new Session(getApplicationContext());
        setContentView(R.layout.activity_perfil_usuario);

        final Button btEditarPerfil = findViewById(R.id.btEditarPerfil);
        btEditarPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityEditarPerfil.class);
                startActivity(it);
            }
        });

        final Button btViraMusico = findViewById(R.id.btTornaMusico);
        btViraMusico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityConfirmaMusico.class);
                startActivity(it);
            }
        });

        final Button btContaFinanceira = findViewById(R.id.btContaFinanceira);
        btContaFinanceira.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityContaFinanceira.class);
                startActivity(it);
            }
        });

        final Button btSeguidos = findViewById(R.id.btSeguidos);
        btSeguidos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityMusicosSeguidos.class);
                startActivity(it);
            }
        });

        final Button btShows = findViewById(R.id.btShowsProximos);
        btShows.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityShowsProximos.class);
                startActivity(it);
            }
        });

        final Button btBuscarMusicos = findViewById(R.id.btPesquisaMusicos);
        btBuscarMusicos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityPesquisaMusicos.class);
                startActivity(it);
            }
        });

        final Button btSair = findViewById(R.id.btSair);
        btSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                session.setLoggedOut();
                Intent it = new Intent(ActivityPerfilUsuario.this,MainActivity.class);
                startActivity(it);
            }
        });
    }

}
