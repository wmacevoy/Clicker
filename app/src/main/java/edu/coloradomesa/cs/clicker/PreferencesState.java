package edu.coloradomesa.cs.clicker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wmacevoy on 9/8/16.
 */

public class PreferencesState {
    Context context;
    SharedPreferences preferences;

    PreferencesState(Context _context) {
        context = _context;
        preferences = context.getSharedPreferences("PREFRENCES", 0);
    }

    public static final String MESSAGE_KEY = "message";
    public static final String MESSAGE_DEFAULT = "hello";

    String getMessage() {
        return preferences.getString(MESSAGE_KEY, MESSAGE_DEFAULT);
    }

    void setMessage(String value) {
        preferences.edit().putString(MESSAGE_KEY,value).commit();
    }

}


