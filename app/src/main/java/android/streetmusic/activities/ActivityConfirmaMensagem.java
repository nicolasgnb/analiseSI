package android.streetmusic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.R;
import android.view.View;
import android.widget.Button;

public class ActivityConfirmaMensagem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_mensagem);

        final Button btConfrimaMensagem = findViewById(R.id.btConfirmaMensagem);
        btConfrimaMensagem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}
