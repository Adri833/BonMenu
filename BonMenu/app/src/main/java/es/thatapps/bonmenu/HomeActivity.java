package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Recoge el correo del intent
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        // TODO: Este intent se puede borrar pero Juan nos pide que hagamos paso de datos con intent, asique lo dejamos
        String userEmail = getIntent().getStringExtra("USER_EMAIL");
        String userEmail2 = getIntent().getStringExtra("USER_EMAIL2");

        // Boton de perfil
        ImageButton profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                Toast.makeText(this, currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

        // Botones de los elementos
        ImageButton supermarketButton = findViewById(R.id.supermarketButton);
        supermarketButton.setOnClickListener(v -> openSupermarketActivity());

        // Navegacion inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_settings) {
                openSettingsActivity();
                return true;
            }
            return false;
        });
    }

    // Navegaciones
    public void openSupermarketActivity() {
        Intent intent = new Intent(this, SupermarketActivity.class); // Navegacion hacia supermarket
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class); // Navegacion hacia settings
        startActivity(intent);
    }
}