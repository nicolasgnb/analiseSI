package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityContaFinanceira extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_financeira);

        final Button btCartaoDeCredito = findViewById(R.id.btCartaoDeCredito);
        btCartaoDeCredito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityContaFinanceira.this,ActivityCartaoCredito.class);
                startActivity(it);
                finish();
            }
        });

        final Button btContaBancaria = findViewById(R.id.btContaBancaria);
        btContaBancaria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityContaFinanceira.this,ActivityContaBancaria.class);
                startActivity(it);
                finish();
            }
        });
    }

}
