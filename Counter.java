package ph.edu.usc.boquecosa_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Counter extends AppCompatActivity {

    Button add, subtract, back;
    TextView name, course, year, countDisplay;
    ImageView pfpImg;
    int counter = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);

        name = (TextView)findViewById(R.id.counterNameDisplay);
        course = (TextView)findViewById(R.id.counterCourseDisplay);
        year = (TextView)findViewById(R.id.counterYearDisplay);
        add = findViewById(R.id.btnadd);
        countDisplay = findViewById(R.id.displayCount);
        subtract = findViewById(R.id.btnminus);
        back = findViewById(R.id.btnback);
        pfpImg = findViewById(R.id.imageView);


        name.setText(getIntent().getStringExtra("nName"));
        course.setText(getIntent().getStringExtra("nCourse"));
        year.setText(getIntent().getStringExtra("nYear"));
        int imageProfile = getIntent().getIntExtra("imageID",0);
        if(imageProfile != 0){
            pfpImg.setImageResource(imageProfile);
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Counter.this, MainActivity.class);
                startActivity(intentLogin);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               counter++;
               countDisplay.setText(String.valueOf(counter));
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter > 0) {
                    counter--;
                    countDisplay.setText(String.valueOf(counter));
                }
            }
        });



    }
}