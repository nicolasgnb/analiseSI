package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCadCliente extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);
        final Button btConfrimaCadastro = findViewById(R.id.botaoConfirmaCadastro);
        btConfrimaCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityCadCliente.this,ActivityConfirmaCadastro.class);
                startActivity(it);
            }
        });
    }

}
