package android.streetmusic.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.streetmusic.db.entities.Usuario;

import java.util.Date;
import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    LiveData<List<Usuario>> getAllUsers();

    @Query("SELECT * FROM usuarios WHERE uid LIKE :uid LIMIT 1")
    Usuario getUser(int uid);

    @Query("SELECT * FROM usuarios WHERE nome LIKE :nome")
    List<Usuario> getUserByName(String nome);

    @Query("SELECT * FROM usuarios WHERE email LIKE :email LIMIT 1")
    Usuario getUserByEmail(String email);

    @Query("SELECT * FROM usuarios WHERE email LIKE :email AND senha LIKE :senha LIMIT 1 ")
    Usuario getUserByCredentials(String email, String senha);

    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Query("DELETE FROM usuarios")
    void deleteAll();

    @Delete
    void deleteUsuario(Usuario usuario);
}
