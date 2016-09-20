package edu.coloradomesa.cs.clicker;

import android.content.Context;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

/**
 * Created by wmacevoy on 9/15/16.
 */
public class FirebaseState {
    Context context;
    Firebase firebase;
    FirebaseState(Context _context) {
        context=_context;
        Firebase.setAndroidContext(context);
        firebase = new Firebase("https://clicker-a2eae.firebaseio.com/");
    }

    String getMessage() {

        Query query = firebase.orderByChild("message");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                DinosaurFacts facts = snapshot.getValue(DinosaurFacts.class);
                System.out.println(snapshot.getKey() + " was " + facts.getHeight() + " meters tall");
            }
            // ....
        });

        return firebase.child("message").get
    }
    void setMessage(String value) {
        firebase.child("message").setValue(value);
    }
}
