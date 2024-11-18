package es.thatapps.bonmenu;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Variables de los elementos
        ImageView logo = findViewById(R.id.logo);

        // URL de la imagenes
        String imageLogo = "https://drive.google.com/uc?export=download&id=1UZWSSZk2axQthSsT6Pm9u3d5g4FhFmau";

        // Carga imagenes con Glide
        Glide.with(this)
                .load(imageLogo)
                //.placeholder(R.drawable.ic_launcher_background)
                .into(logo);
    }
}