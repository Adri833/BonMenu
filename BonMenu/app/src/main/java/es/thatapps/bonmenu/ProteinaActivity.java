package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import es.thatapps.bonmenu.adapter.PlatoAdapter;
import es.thatapps.bonmenu.model.Plato;

public class ProteinaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteina);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Plato> platos = new ArrayList<>();
        platos.add(new Plato("Pollo a la parrilla con quinoa y espárragos", "Receta saludable rica en proteínas", R.drawable.pollo));
        platos.add(new Plato("Salmón al horno con ensalada de garbanzos", "Perfecta para una dieta balanceada", R.drawable.ensalada));
        platos.add(new Plato("Huevos revueltos con espinacas", "Rápido y nutritivo", R.drawable.revuelto));
        platos.add(new Plato("Tofu salteado con vegetales", "Opción vegana con mucho sabor", R.drawable.salteado));
        platos.add(new Plato("Bistec de res con puré de camote", "Clásico y completo", R.drawable.menu_proteico));

        PlatoAdapter adapter = new PlatoAdapter(platos, this);
        recyclerView.setAdapter(adapter);
        // Navegacion inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_settings) {
                openSettingsActivity();
                return true;
            }
            if (id == R.id.nav_home) {
                openHomeActivity();
                return true;
            }
            return false;
        });

    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class); // Navegacion hacia settings
        startActivity(intent);
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class); // Navegacion hacia home
        startActivity(intent);
    }
}


