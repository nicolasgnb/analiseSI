package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityEditarPerfil extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        final Button btConfrimaEdicao = findViewById(R.id.btConfirmaEdita);
        btConfrimaEdicao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityEditarPerfil.this,ActivityConfirmaEdicaoCad.class);
                startActivity(it);
                finish();
            }
        });
    }

}
