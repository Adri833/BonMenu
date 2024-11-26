package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menus);

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
}