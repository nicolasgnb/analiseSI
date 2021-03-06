package android.streetmusic.db.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.streetmusic.db.AppDatabase;
import android.streetmusic.db.dao.UsuarioDao;
import android.streetmusic.db.entities.Usuario;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UsuarioRepository {

    private UsuarioDao usuarioDao;
    private LiveData<List<Usuario>> allUsers;

    public UsuarioRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        usuarioDao = db.usuarioDao();
        allUsers = usuarioDao.getAllUsers();
    }

    public void insert(Usuario usuario) {
        new insertAsyncTask(usuarioDao).execute(usuario);
    }

    public void delete(Usuario usuario) {
        new deleteAsyncTask(usuarioDao).execute(usuario);
    }

    public void deleteAll() {
        new deleteAsyncTask(usuarioDao).execute();
    }

    public LiveData<List<Usuario>> getAllUsers() {
        return allUsers;
    }

    public Usuario getUser(Integer uid) throws ExecutionException, InterruptedException {
        return new getUserAsyncTask(usuarioDao).execute("uid", uid.toString()).get();
    }

    public Usuario getUserByEmail(String email) throws ExecutionException, InterruptedException {
        return new getUserAsyncTask(usuarioDao).execute("email", email).get();
    }

    public Usuario getUserByCredentials(String email, String senha) throws ExecutionException, InterruptedException {
        return new getUserAsyncTask(usuarioDao).execute("password", email, senha).get();
    }

    public void update(Usuario usuario) {
        new updateUserAsyncTask(usuarioDao).execute(usuario);
    }

    private static class updateUserAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        updateUserAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.update(usuarios[0]);
            return null;
        }
    }

    private static class getUserAsyncTask extends AsyncTask<String, Void, Usuario> {
        private UsuarioDao usuarioDao;

        getUserAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Usuario doInBackground(String... strings) {
            switch (strings[0]) {
                case "email":
                    return usuarioDao.getUserByEmail(strings[1]);
                case "password":
                    return usuarioDao.getUserByCredentials(strings[1], strings[2]);
                case "uid":
                    return usuarioDao.getUser(Integer.parseInt(strings[1]));
                default:
                    return null;
            }
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        private deleteAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            if(usuarios.length == 0) {
                usuarioDao.deleteAll();
            } else {
                for (Usuario usuario : usuarios) {
                    usuarioDao.deleteUsuario(usuario);
                }
                usuarioDao.deleteAll();
            }
            return null;
        }
    }

    private static class insertAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        private insertAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.insert(usuarios[0]);
            return null;
        }
    }
}
