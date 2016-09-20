package edu.coloradomesa.cs.clicker;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by wmacevoy on 9/8/16.
 */

public class LocalState {
    Context context;

    LocalState(Context _context) {
        context = _context;
    }

    public static final String MSG_FILE = "msg.txt";
    public static final String MSG_DEFAULT = "hello!";

    String getMessage() {

        try {
            try (FileInputStream fis
                         = context.openFileInput(MSG_FILE)) {
                byte[] data = new byte[1024];
                int length = fis.read(data);
                data = java.util.Arrays.copyOf(data, length);
                return new String(data, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            return MSG_DEFAULT;
        }
    }

    public void setMessage(String value) {
        try {
            try (FileOutputStream fos
                         = context.openFileOutput(MSG_FILE, Context.MODE_PRIVATE)) {
                fos.write(value.getBytes(Charset.forName("UTF-8")));
            }
        } catch (IOException e) {
        }
    }
}
