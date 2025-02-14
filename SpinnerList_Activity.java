package ph.edu.usc.boquecosa_project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpinnerList_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spincourses;
    ListView listView;

    private  Integer[] imgid = {
            R.drawable.bronze_atgeir,
            R.drawable.carapace_spear,
            R.drawable.draugr_fang,
            R.drawable.black_metal_sword
    };

    private  String[] courses = {
            "android",
            "Java Programming",
            "Python",
            "C programing"
    };

    private  String[] topics = {
            "andrioid",
            "Java Programming",
            "Python",
            "C programing"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_list);

            spincourses = findViewById(R.id.spinner);
            listView = findViewById(R.id.list);
            spincourses.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrCourses = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                courses
        );
        spincourses.setAdapter(arrCourses);

        ArrayAdapter<String> arrTopics = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                topics
        );

        listView.setAdapter(arrTopics);

        MylistAdaptor adopter = new MylistAdaptor(this, this, courses, topics, imgid);
        listView.setAdapter(adopter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),courses[position],
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}