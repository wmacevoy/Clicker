package edu.coloradomesa.cs.clicker;

import android.content.Context;

//import static edu.coloradomesa.cs.firstapp.State.Local.MSG_FILE;

/**
 * Created by wmacevoy on 9/6/16.
 */

public class State {
    Context context;
    PreferencesState preferences;
    LocalState local;
    FirebaseState db;


    State(Context _context) {
        context=_context;
        preferences = new PreferencesState(context);
        local = new LocalState(context);
        db = new FirebaseState(context);
    }




//    class DB extends SQLiteOpenHelper {
//        // If you change the database schema, you must increment the database version.
//        public static final int VERSION = 1;
//        public static final String NAME = "state.db";
//
//
//        MessagesTable messages = new MessagesTable();
//        private SQLiteDatabase _db = null;
//        private Object dbIsReady = new Object();
//        public SQLiteDatabase db() {
//                while (_db == null) {
//                    synchronized (dbIsReady) {
//                        if (_db == null) {
//                            try {
//                                dbIsReady.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            return _db;
//        }
//
//
//        DB(Context context) {
//            super(context, NAME, null, VERSION);
//            new Thread(new Runnable() {
//                @Override public void run() {
//                    synchronized (dbIsReady) {
//                        _db = getWritableDatabase();
//                        dbIsReady.notifyAll();
//                    }
//                }
//            }).start();
//        }
//
//            public void onCreate(SQLiteDatabase db) {
//                messages.onCreate(db);
//            }
//            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//                // This database is only a cache for online data, so its upgrade policy is
//                // to simply to discard the data and start over
//                messages.onDrop(db);
//                onCreate(db);
//            }
//            public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//                onUpgrade(db, oldVersion, newVersion);
//            }
//
//        public static final String MESSAGE_SUBJECT = "MOTD";
//        void getMessage() {
//            messages.getMessageBySubject(db(),MESSAGE_SUBJECT);
//        }
//        void setMessage(String value) {
//            messages.setMessageBySubject(db(),MESSAGE_SUBJECT);
//        }
//
//    }


}

