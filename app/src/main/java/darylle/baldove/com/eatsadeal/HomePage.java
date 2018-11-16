package darylle.baldove.com.eatsadeal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class HomePage extends AppCompatActivity {

    Cursor table;
    DatabaseHelper helper;

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



    private void setSupportActionBar(Toolbar toolbar) {
    }

    public class ProgressBarAnimation extends Animation {
        private ProgressBar progressBar;
        private float from;
        private float  to;

        public ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
            super();
            this.progressBar = progressBar;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float value = from + (to - from) * interpolatedTime;
            progressBar.setProgress((int) value);
        }

    }

    public void generate(View v)
    {
         Intent i = new Intent(this, ResultPage.class);
        startActivity(i);
    }
}
