package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityConfirmaEdicaoCad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_edicao_cad);
        final Button btConfrimaEdicao = findViewById(R.id.btConfirmaEdicao);
        btConfrimaEdicao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityConfirmaEdicaoCad.this,ActivityPerfilUsuario.class);
                startActivity(it);
            }
        });
    }

}
