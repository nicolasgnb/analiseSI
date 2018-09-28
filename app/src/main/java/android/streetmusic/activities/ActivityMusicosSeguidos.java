package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityMusicosSeguidos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicos_seguidos);

        final Button btDoacao = findViewById(R.id.btDoacao);
        btDoacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityMusicosSeguidos.this,ActivityDoacao.class);
                startActivity(it);
            }
        });
    }

}
