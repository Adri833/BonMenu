package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menus);

        // Boton de retroceso
        ImageButton backButton = findViewById(R.id.backButton); // Boton para ir hacia atras
        backButton.setOnClickListener(v -> finish());

        // Imagenes de los menus
        ImageButton proteinButton = findViewById(R.id.proteinButton);
        ImageButton lowCaloriesButton = findViewById(R.id.lowCaloriesButton);
        ImageButton fibreButton = findViewById(R.id.fibreButton);

        // URL de las imagenes
        String imageProtein = "https://drive.google.com/uc?export=download&id=1Kg4Rp6x18ibNcR1VgYpd4GtVha7Arer1";
        String imageLowCalories = "https://drive.google.com/uc?export=download&id=1xeijs6YV1Dqf8n6KN_7h0O4atfwS8iyo";
        String imageFibre = "https://drive.google.com/uc?export=download&id=1EDh-qy0VPnuifbw4sBm0OgGdHob4Qdjp";

        // Carga imagenes con Glide
        Glide.with(this)
                .load(imageProtein)
                .placeholder(R.drawable.placeholder)
                .into(proteinButton);

        Glide.with(this)
                .load(imageLowCalories)
                .placeholder(R.drawable.placeholder)
                .into(lowCaloriesButton);

        Glide.with(this)
                .load(imageFibre)
                .placeholder(R.drawable.placeholder)
                .into(fibreButton);

        // Botones de platos
        proteinButton.setOnClickListener(v -> openProteinaActivity());
        lowCaloriesButton.setOnClickListener(v -> Toast.makeText(this, R.string.next_update, Toast.LENGTH_SHORT).show());
        fibreButton.setOnClickListener(v -> Toast.makeText(this, R.string.next_update, Toast.LENGTH_SHORT).show());

        // Navegacion inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                openHomeActivity();
                return true;
            }
            if (id == R.id.nav_settings) {
                openSettingsActivity();
                return true;
            }
            return false;
        });
    }

    // Navegacion
    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class); // Navegacion hacia home
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class); // Navegacion hacia settings
        startActivity(intent);
    }

    public void openProteinaActivity() {
        Intent intent = new Intent(this, ProteinaActivity.class); // Navegacion hacia proteina
        startActivity(intent);
    }
}