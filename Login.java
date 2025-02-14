package ph.edu.usc.boquecosa_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button Btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.loginUser);
        password = (EditText) findViewById(R.id.loginPass);
        Btn = findViewById(R.id.button);

                Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentLogin = new Intent(Login.this, MainActivity.class);
                        startActivity(intentLogin);
                    }
                }
        );
    }
}