package es.thatapps.bonmenu;

import android.content.Intent;
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
        String userEmail2 = getIntent().getStringExtra("USER_EMAIL2");

        // Boton de perfil
        ImageButton profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            if (userEmail != null) {
                Toast.makeText(this, userEmail, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, userEmail2, Toast.LENGTH_SHORT).show();
            }
        });

        // Botones de los elementos
        ImageButton supermarketButton = findViewById(R.id.supermarketButton);
        supermarketButton.setOnClickListener(v -> openSupermarketActivity());
        // Botón de configuraciones



    }

    // Navegaciones
    public void openSupermarketActivity() {
        Intent intent = new Intent(this, SupermarketActivity.class); // Navegacion hacia supermarket
        startActivity(intent);
    }

}