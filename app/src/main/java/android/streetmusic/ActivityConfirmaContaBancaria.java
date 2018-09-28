package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityConfirmaContaBancaria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_conta_bancaria);

        final Button btConfirma = findViewById(R.id.btConfirma);
        btConfirma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityConfirmaContaBancaria.this,ActivityPerfilUsuario.class);
                startActivity(it);
            }
        });
    }

}
