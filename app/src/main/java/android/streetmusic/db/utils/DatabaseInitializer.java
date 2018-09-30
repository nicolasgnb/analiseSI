package android.streetmusic.db.utils;

import android.os.AsyncTask;
import android.streetmusic.db.AppDatabase;
import android.streetmusic.db.entities.Usuario;

public class DatabaseInitializer {

    public static void populateAsync(final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static void populateWithTestData(AppDatabase db) {
        db.usuarioDao().deleteAll();

        addUser(db, "Tainah", "s2", "teste", "12");
        addUser(db, "Nicolas", "s2", "teste", "123");
    }

    private static Usuario addUser(final AppDatabase db, final String nome,
                                   final String senha, final String email, final String cpf) {
        Usuario user = new Usuario(nome, senha, email, cpf);
        db.usuarioDao().insert(user);
        return user;
    }


    public static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        private PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
