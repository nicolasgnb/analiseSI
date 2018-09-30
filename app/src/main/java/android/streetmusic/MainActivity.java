package android.streetmusic;

import android.content.Intent;
import android.streetmusic.activities.ActivityCadCliente;
import android.streetmusic.activities.ActivityLogin;
import android.streetmusic.views.UsuarioViewModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private UsuarioViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//        final UsuarioAdapter usuarioAdapter = new UsuarioAdapter();
//        recyclerView.setAdapter(usuarioAdapter);
//
//
//        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
//        userViewModel.getAllUsers().observe(this, new Observer<List<Usuario>>() {
//            @Override
//            public void onChanged(@Nullable List<Usuario> usuarios) {
//                usuarioAdapter.setUsuarios(usuarios);
//            }
//        });

        final Button btCadastro = findViewById(R.id.botaoCadastroMain);
        btCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ActivityCadCliente.class);
                startActivity(it);
            }
        });
        final Button btLogin = findViewById(R.id.botaoLoginMain);
        btLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,ActivityLogin.class);
                startActivity(it);
            }
        });
    }
}
