package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Variables de los elementos
        ImageView logo = findViewById(R.id.logo);
        ImageView letras = findViewById(R.id.letras);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);


        // URL de la imagenes
        String imageLogo = "https://drive.google.com/uc?export=download&id=1UZWSSZk2axQthSsT6Pm9u3d5g4FhFmau";
        String imageLetras = "https://drive.google.com/uc?export=download&id=1EUtYu-83KLfTggwUfvjezLZCSva1DQio";

        // Carga imagenes con Glide
        Glide.with(this)
                .load(imageLogo)
                //.placeholder(R.drawable.ic_launcher_background)
                .into(logo);

        Glide.with(this)
                .load(imageLetras)
                //.placeholder(R.drawable.ic_launcher_background)
                .into(letras);

        loginButton.setOnClickListener(v -> {
            openLoginActivity();
        });

        registerButton.setOnClickListener(v -> {
            openRegisterActivity();
        });
    }

    // Navegaciones
    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    // Navegaciones
    private void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}