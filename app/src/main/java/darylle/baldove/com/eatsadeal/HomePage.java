package darylle.baldove.com.eatsadeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Spinner s = (Spinner) findViewById(R.id.place);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);

        Spinner sp = (Spinner) findViewById(R.id.type);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);

        Spinner spi = (Spinner) findViewById(R.id.budget);
        ArrayAdapter<CharSequence> ada = ArrayAdapter.createFromResource(this, R.array.budget, android.R.layout.simple_spinner_item);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(ada);

    }
}
