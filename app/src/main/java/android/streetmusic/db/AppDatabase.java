package android.streetmusic.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.streetmusic.db.dao.UsuarioDao;
import android.streetmusic.db.entities.Usuario;
import android.streetmusic.db.utils.DatabaseInitializer;
import android.support.annotation.NonNull;

@Database(entities = {Usuario.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UsuarioDao usuarioDao();

    private static final String DB_NAME = "street-music-db";


    public static synchronized AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            buildDatabase(context);
        }
        return INSTANCE;
    }

    private static void buildDatabase(Context context) {
        INSTANCE = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build();
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            DatabaseInitializer.populateAsync(INSTANCE);
        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
