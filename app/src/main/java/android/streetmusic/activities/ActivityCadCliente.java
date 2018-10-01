package android.streetmusic.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
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

public class ActivityCadCliente extends AppCompatActivity {

    private UsuarioViewModel userViewModel;

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel.class);
        session = new Session(getApplicationContext());

        if (session.isLoggedIn()) {
            Intent it = new Intent(ActivityCadCliente.this, ActivityPerfilUsuario.class);
            startActivity(it);
            finish();
        }

        setContentView(R.layout.activity_cad_cliente);
        final Button btConfrimaCadastro = findViewById(R.id.botaoConfirmaCadastro);
        btConfrimaCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Usuario newUser = extractUser();
                    String validation = validateUser(newUser);
                    if (validation == null) {
                        userViewModel.insert(newUser);
                        Intent it = new Intent(ActivityCadCliente.this, ActivityConfirmaCadastro.class);
                        startActivity(it);
                    } else {
                        Toast.makeText(getApplicationContext(), validation, Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Usuario extractUser() {
        Usuario usuario = new Usuario();
        EditText nameField = findViewById(R.id.campoNomeCadastro);
        EditText emailField = findViewById(R.id.campoEmailCadastro);
        EditText passwField = findViewById(R.id.campoSenhaCadastro);

        usuario.setNome(nameField.getText().toString());
        usuario.setEmail(emailField.getText().toString());
        usuario.setSenha(passwField.getText().toString());

        return usuario;
    }

    private String validateUser(Usuario usuario) throws ExecutionException, InterruptedException {
        if (usuario.getNome() == null || usuario.getNome().isEmpty())
            return "Nome é obrigatório.";
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty())
            return "Senha é obrigatório";
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty())
            return "Email é obrigatório";
        else if (userViewModel.getUserByEmail(usuario.getEmail()) != null)
            return "Email já cadastrado";

        return null;
    }

}

