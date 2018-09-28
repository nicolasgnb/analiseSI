package android.streetmusic;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class ActivityCartaoCredito extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_credito);
        final Button btConfirma = findViewById(R.id.btConfirma);
        btConfirma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityCartaoCredito.this,ActivityConfirmaCartaoCredito.class);
                startActivity(it);
                finish();
            }
        });
    }

}
