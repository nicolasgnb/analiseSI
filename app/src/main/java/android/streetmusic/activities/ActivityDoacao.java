package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityDoacao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacao);

        final Button btConfirmaDoacao = findViewById(R.id.btConfirma);
        btConfirmaDoacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityDoacao.this,ActivityConfirmaDoacao.class);
                startActivity(it);
                finish();
            }
        });
    }

}
