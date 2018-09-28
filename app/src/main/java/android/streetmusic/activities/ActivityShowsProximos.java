package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityShowsProximos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_proximos);

        final Button btCheckIn = findViewById(R.id.btCkeckIn);
        btCheckIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityShowsProximos.this,ActivityConfirmaCheckIn.class);
                startActivity(it);
            }
        });

        final Button btMensagem = findViewById(R.id.btMensagem);
        btMensagem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityShowsProximos.this,ActivityMensagem.class);
                startActivity(it);
            }
        });
    }

}
