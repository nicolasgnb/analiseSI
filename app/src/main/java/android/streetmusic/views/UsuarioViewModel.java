package android.streetmusic.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.streetmusic.db.entities.Usuario;
import android.streetmusic.db.repositories.UsuarioRepository;
import android.support.annotation.NonNull;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UsuarioViewModel extends AndroidViewModel {

    private UsuarioRepository repository;

    private LiveData<List<Usuario>> allUsers;

    public UsuarioViewModel(@NonNull Application application) {
        super(application);
        repository = new UsuarioRepository(application);
        allUsers = repository.getAllUsers();
    }

    public LiveData<List<Usuario>> getAllUsers() {
        return allUsers;
    }

    public void insert(Usuario usuario) {
        repository.insert(usuario);
    }

    public Usuario getUserByEmail(String email) throws ExecutionException, InterruptedException {
        return repository.getUserByEmail(email);
    }

    public Usuario getUserByCredentials(String email, String senha) throws ExecutionException, InterruptedException {
        return repository.getUserByCredentials(email, senha);
    }

    public Usuario getUser(int uid) throws ExecutionException, InterruptedException {
        return repository.getUser(uid);
    }

    public void update(Usuario userEdit) throws ExecutionException, InterruptedException {
        Usuario usuario = this.getUser(userEdit.getUid());
        if(userEdit.getEmail() != null && !(userEdit.getEmail().isEmpty()))
            usuario.setEmail(userEdit.getEmail());
        if(userEdit.getSenha() != null && !(userEdit.getSenha().isEmpty()))
            usuario.setSenha(userEdit.getSenha());
        if(userEdit.getNome() != null && !(userEdit.getNome().isEmpty()))
            usuario.setNome(userEdit.getNome());
        usuario.setHoraModificacao(new Date());

        repository.update(usuario);
    }
}
