package android.streetmusic.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
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

public class ActivityEditarPerfil extends AppCompatActivity {

    private UsuarioViewModel userViewModel;

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
        session = new Session(getApplicationContext());

        setContentView(R.layout.activity_editar_perfil);
        final Button btConfrimaEdicao = findViewById(R.id.btConfirmaEdita);
        btConfrimaEdicao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Usuario userEdit = extractUser();
                    String validation = validateEdit(userEdit);
                    if (validation == null) {
                        userEdit.setUid(session.getUserUid());
                        userViewModel.update(userEdit);
                        Intent it = new Intent(ActivityEditarPerfil.this, ActivityConfirmaEdicaoCad.class);
                        startActivity(it);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), validation, Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Usuario extractUser(){
        Usuario usuario = new Usuario();
        EditText nameField = findViewById(R.id.campoNomeEdita);
        EditText emailField = findViewById(R.id.campoEmailEdita);
        EditText passwField = findViewById(R.id.campoSenhaEdita);

        usuario.setNome(nameField.getText().toString());
        usuario.setEmail(emailField.getText().toString());
        usuario.setSenha(passwField.getText().toString());

        return usuario;
    }

    private String validateEdit(Usuario usuario) throws ExecutionException, InterruptedException {
        if (userViewModel.getUserByEmail(usuario.getEmail()) != null)
            return "Email já cadastrado";

        return null;
    }

}
