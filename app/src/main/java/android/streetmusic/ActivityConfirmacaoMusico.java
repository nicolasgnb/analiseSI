package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityConfirmacaoMusico extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiry_confirmacao_musico);

        final Button btConfirmaMusico = findViewById(R.id.btVoltaPerfilMusico);
        btConfirmaMusico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityConfirmacaoMusico.this,ActivityPerfilUsuario.class);
                startActivity(it);
            }
        });
    }

}
