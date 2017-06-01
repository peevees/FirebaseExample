package com.mikecoding.firebaselesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    DatabaseReference valueRef;
    Item item;
    EditText textView;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (EditText) findViewById(R.id.editText);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference();
        DatabaseReference valueRef = ref.child("items");


//        ref.child("items").child("majs").setValue(false);
//        ref.child("items").child("ärtor").setValue(false);
//        ref.child("items").child("morötter").setValue(false);


        //ref.child("items").child("majs").setValue(new Item("Majs", false));
        //valueRef = ref.child("items").child("majs");

        valueRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // item = dataSnapshot.getValue(Item.class);
                //boolean bol = dataSnapshot.getValue(boolean.class);
                // Log.d(TAG, "onDataChange: " + item.name);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
    public void save(View view) {

        String itemName = textView.getText().toString();
        Item item = new Item(itemName, false);
        ref.child("items").child(itemName.toLowerCase()).setValue(item);

        // item.switchDone();
        // valueRef.setValue(item);

    }

}
