package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityPerfilUsuario extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_perfil_usuario);
        final Button btEditarPerfil = findViewById(R.id.btEditarPerfil);
        btEditarPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityPerfilUsuario.this,ActivityEditarPerfil.class);
                startActivity(it);
            }
        });
    }

}
