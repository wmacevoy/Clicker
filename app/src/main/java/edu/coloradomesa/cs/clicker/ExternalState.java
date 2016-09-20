package edu.coloradomesa.cs.clicker;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by wmacevoy on 9/8/16.
 */

public class ExternalState {
    class External {

        /* Checks if external storage is available for read and write */
        public boolean isExternalStorageWritable() {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                return true;
            }
            return false;
        }

        /* Checks if external storage is available to at least read */
        public boolean isExternalStorageReadable() {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state) ||
                    Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                return true;
            }
            return false;
        }

        public static final String MSG_DIR = "Messages";

        File getDirectory() {
            File file = new File(Environment.getExternalStorageDirectory(), MSG_DIR);
            if (!file.mkdirs()) {
                Log.e("first", "Directory not created");
            }
            return file;
        }

        public static final String MSG_FILE = "message.txt";
        public static final String MSG_DEFAULT = "hello!";

        String getMessage() {
            File messageFile = new File(getDirectory().toString() + "/" + MSG_FILE);

            try {
                try (FileInputStream fis
                             = new FileInputStream(messageFile)) {
                    byte[] data = new byte[1024];
                    int length = fis.read(data);
                    data = java.util.Arrays.copyOf(data, length);
                    return new String(data, Charset.forName("UTF-8"));
                }
            } catch (IOException e) {
                return MSG_DEFAULT;
            }
        }
    }

}
