package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Inicializar Firebase Auth
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // Barra de busqueda
        EditText searchBar = findViewById(R.id.searchBar);

        // Boton de borrar la busqueda
        ImageButton eraseButton = findViewById(R.id.eraseButton);
        eraseButton.setOnClickListener(v -> searchBar.setText(""));

        // Boton de perfil
        ImageButton profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                Toast.makeText(this, currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

        // variables de imagenes
        ImageButton supermarketButton = findViewById(R.id.supermarketButton);
        ImageButton menusButton = findViewById(R.id.menusButton);
        ImageButton salesButton = findViewById(R.id.salesButton);
        ImageButton ordersButton = findViewById(R.id.ordersButton);

        // URL de las imagenes
        String supermarketImage = "https://drive.google.com/uc?export=download&id=1q0Uho2D_vjt9FtH2BGkEJ-debVsBtm7e";
        String salesImage = "https://drive.google.com/uc?export=download&id=1IHytUYZyvXrlS0JEGmZKOr9TTJAIG2hD";
        String menusImage = "https://drive.google.com/uc?export=download&id=11JR4ZTUUWfmsNMDlhRHlBrZ4tEmgV9-F";
        String ordersImage = "https://drive.google.com/uc?export=download&id=1QOuYTLETOMM2rPZokG2JidJYXOBO4gMc";

        // Iamgenes con glide

        Glide.with(this)
                .load(supermarketImage)
                .placeholder(R.drawable.placeholder)
                .into(supermarketButton);

        Glide.with(this)
                .load(salesImage)
                .placeholder(R.drawable.placeholder)
                .into(salesButton);

        Glide.with(this)
                .load(menusImage)
                .placeholder(R.drawable.placeholder)
                .into(menusButton);

        Glide.with(this)
                .load(ordersImage)
                .placeholder(R.drawable.placeholder)
                .into(ordersButton);

        // Navegacion del menu
        supermarketButton.setOnClickListener(v -> openSupermarketActivity());
        menusButton.setOnClickListener(v -> openMenusActivity());
        salesButton.setOnClickListener(v -> Toast.makeText(this, R.string.next_update, Toast.LENGTH_SHORT).show());
        ordersButton.setOnClickListener(v -> Toast.makeText(this, R.string.next_update, Toast.LENGTH_SHORT).show());

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

    public void openMenusActivity() {
        Intent intent = new Intent(this, MenusActivity.class); // Navegacion hacia menus
        startActivity(intent);
    }
}