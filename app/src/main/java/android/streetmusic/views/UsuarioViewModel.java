package android.streetmusic.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.streetmusic.db.entities.Usuario;
import android.streetmusic.db.repositories.UsuarioRepository;
import android.support.annotation.NonNull;

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
}
