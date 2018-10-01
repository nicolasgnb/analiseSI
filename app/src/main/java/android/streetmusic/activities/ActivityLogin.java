package android.streetmusic.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.streetmusic.MainActivity;
import android.streetmusic.R;
import android.streetmusic.db.entities.Usuario;
import android.streetmusic.db.utils.Session;
import android.streetmusic.views.UsuarioViewModel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class ActivityLogin extends AppCompatActivity {

    private UsuarioViewModel userViewModel;

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(getApplicationContext());

        if (session.isLoggedIn()) {
            Intent it = new Intent(ActivityLogin.this, ActivityPerfilUsuario.class);
            startActivity(it);
            finish();
        }

        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);


        final Button btConfirmaLogin = findViewById(R.id.confirmaLogin);


        btConfirmaLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Usuario usuario = extractUser();
                    String isLoginValid = validateLogin(usuario);
                    if (isLoginValid == null) {
                        session.setLoggedIn(userViewModel.getUserByEmail(usuario.getEmail()).getUid());
                        ;
                        Intent it = new Intent(ActivityLogin.this, ActivityPerfilUsuario.class);
                        startActivity(it);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), isLoginValid, Toast.LENGTH_LONG).show();
                    }
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private Usuario extractUser() {
        Usuario usuario = new Usuario();
        EditText emailField = findViewById(R.id.campoEmail);
        EditText passwField = findViewById(R.id.campoSenha);
        usuario.setEmail(emailField.getText().toString());
        usuario.setSenha(passwField.getText().toString());

        return usuario;
    }

    private String validateLogin(Usuario usuario) throws ExecutionException, InterruptedException {
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            return "Email é obrigatório";
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            return "Email é obrigatório";
        }
        if (userViewModel.getUserByCredentials(usuario.getEmail(), usuario.getSenha()) == null) {
            return "Credenciais inválidas";
        }
        return null;
    }

}
