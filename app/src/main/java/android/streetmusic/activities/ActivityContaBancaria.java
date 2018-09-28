package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityContaBancaria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_bancaria);

        final Button btContaBancaria = findViewById(R.id.btConfirma);
        btContaBancaria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityContaBancaria.this,ActivityConfirmaContaBancaria.class);
                startActivity(it);
                finish();
            }
        });
    }

}
