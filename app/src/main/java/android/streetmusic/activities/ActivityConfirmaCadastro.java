package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.MainActivity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityConfirmaCadastro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_cadastro);
        final Button btBack = findViewById(R.id.button_home_page);
        btBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ActivityConfirmaCadastro.this,MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

}
