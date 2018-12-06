package darylle.baldove.com.eatsadeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class ResultPage extends AppCompatActivity {

    SharedPreferences prefs;
    FirebaseDatabase db;
    DatabaseReference myRef;

    TextView restoname;

    Button gen2;

    String place;
    String type;
    String budget;

    ArrayList<Resto> restos;
    ArrayList<Resto> filterRestos;

    Resto resto;

    Boolean startStatus = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        db = FirebaseDatabase.getInstance();
        myRef = db.getReference("Restaurants");

        gen2 = (Button) findViewById(R.id.gen2);
        restoname = (TextView) findViewById(R.id.restoname);

        prefs = getSharedPreferences("Eatsadeal", MODE_PRIVATE);

        restos = new ArrayList<>();
        filterRestos = new ArrayList<>();

        place = prefs.getString("place", "PNOVAL");
        type = prefs.getString("type", "FILIPINO");
        budget = prefs.getString("budget", "Below 150");

        gen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("EAD", "ON CHANGE");
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    resto = ds.getValue(Resto.class);
                    restos.add(resto);
                }

                if(startStatus) {
                    startStatus = false;
                    generate();
                }
                Log.d("EAD", restos.size() + "");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void generate() {
        filter();

        if(filterRestos.size() > 0) {
            Random rand = new Random();
            Resto rr = filterRestos.get(rand.nextInt(filterRestos.size()));
            restoname.setText(rr.getName());

        } else {

            restoname.setText("NO RESULTS FOUND");
        }

    }

    public void filter() {
        for(int a = 0; a < restos.size(); a++) {
            Resto resto = restos.get(a);

            if(resto.getType().equalsIgnoreCase(type) &&
                    resto.getPlace().equalsIgnoreCase(place) &&
                    resto.getBudget().equalsIgnoreCase(budget)) {
                filterRestos.add(resto);
            }
        }
    }

    public void back(View v) {
        Intent i = new Intent(this, HomePage.class);
        startActivity(i);
    }
}
