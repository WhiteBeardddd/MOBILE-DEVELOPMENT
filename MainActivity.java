package ph.edu.usc.boquecosa_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView Name;
    TextView Course;
    TextView Year;
    ImageView Image;
    Button Btn;
    Button Btn2;
    Button logout;
    Button toCounter;
    EditText editName;
    EditText editCourse;
    EditText editYear;
    LinearLayout profileContent;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        String nameStr = "Name: Charles Benedict G. Boquecosa";
        String courseStr = "Course: BS IT";
        String yearStr = "Year: 2nd";

        Name = (TextView) findViewById(R.id.name);
        Course = (TextView) findViewById(R.id.course);
        Year = (TextView) findViewById(R.id.year);
        Image = findViewById(R.id.studpic);
        editName = (EditText) findViewById(R.id.editName);
        editCourse = (EditText) findViewById(R.id.editCourse);
        profileContent = (LinearLayout) findViewById(R.id.profile_wrapper);
        editYear = (EditText) findViewById(R.id.editYear);
        Btn = findViewById(R.id.clickmebutton);
        Btn2 = findViewById(R.id.edittextbutton);
        logout = findViewById(R.id.logout);
        toCounter = findViewById(R.id.nextBtn);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText(nameStr);
                Course.setText(courseStr);
                Year.setText(yearStr);

                if (profileContent.getVisibility() == View.GONE) {
                    profileContent.setVisibility(View.VISIBLE);
                } else {
                    profileContent.setVisibility(View.GONE);
                }
                Image.setImageResource(R.drawable.hello);
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newName = editName.getText().toString();
                String newCourse = editCourse.getText().toString();
                String newYear = editYear.getText().toString();


                Name.setText(newName);
                Course.setText(newCourse);
                Year.setText(newYear);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(MainActivity.this, Login.class);
                startActivity(intentLogin);
            }
        });

        toCounter.setOnClickListener(new View.OnClickListener() {
            String tName, tCourse, tYear;

            @Override
            public void onClick(View v) {
                tName = Name.getText().toString();
                tCourse = Course.getText().toString();
                tYear = Year.getText().toString();
                Intent contentToCounter = new Intent(MainActivity.this, Counter.class);
                contentToCounter.putExtra("nName",tName);
                contentToCounter.putExtra("nCourse",tCourse);
                contentToCounter.putExtra("nYear",tYear);;
                contentToCounter.putExtra("imageID",R.drawable.hello);
                startActivity(contentToCounter);
            }
        });



    }



}