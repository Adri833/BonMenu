package es.thatapps.bonmenu;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Recoge el correo del intent
        String userEmail = getIntent().getStringExtra("USER_EMAIL");

        // Variables
        ImageButton profileButton = findViewById(R.id.profileButton);
        profileButton .setOnClickListener(v -> Toast.makeText(this, userEmail, Toast.LENGTH_SHORT).show());
    }
}