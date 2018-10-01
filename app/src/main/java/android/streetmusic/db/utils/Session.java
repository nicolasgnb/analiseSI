package android.streetmusic.db.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.streetmusic.db.entities.Usuario;

public class Session {

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    public static final String LOGGED_IN = "logged_in_status";

    public static  final String UID = "uid";

    public Session(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setLoggedIn(int uid) {
        editor = preferences.edit();
        editor.putBoolean(LOGGED_IN, true);
        editor.putInt(UID, uid);

        editor.apply();
    }

    public int getUserUid() {
        return preferences.getInt(UID, -1);
    }

    public void setLoggedOut() {
        editor = preferences.edit();
        editor.putBoolean(LOGGED_IN, false);
        editor.remove(UID);

        editor.apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(LOGGED_IN, false);
    }
 }