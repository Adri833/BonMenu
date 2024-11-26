package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Variables de los elementos
        ImageView logo = findViewById(R.id.logo);

        // Boton de retroceso
        ImageButton backButton = findViewById(R.id.backButton); // Boton para ir hacia atras
        backButton.setOnClickListener(v -> openMainActivity());

        // Email y contrasña introducidos
        EditText input_email = findViewById(R.id.input_email);
        EditText input_password = findViewById(R.id.input_password);

        // Boton de login
        Button registerButton = findViewById(R.id.loginButton);
        registerButton.setOnClickListener(v -> {
            // Recoge el email y la contraseña introducidos
            String email = input_email.getText().toString().trim();
            String password = input_password.getText().toString().trim();

            if (validateInputs(email, password)) {
                loginUser(email, password); // Pasa el email al siguiente activity
            }
        });


        // URL de la imagenes
        String imageLogo = "https://drive.google.com/uc?export=download&id=1UZWSSZk2axQthSsT6Pm9u3d5g4FhFmau";

        // Carga imagenes con Glide
        Glide.with(this)
                .load(imageLogo)
                //.placeholder(R.drawable.ic_launcher_background)
                .into(logo);
    }

    // Metodo para iniciar sesion con la BBDD
    private void loginUser(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login exitoso
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            Toast.makeText(this, R.string.toast_login, Toast.LENGTH_SHORT).show();
                            openHomeActivity(user.getEmail());
                        }
                    } else {
                        // Error en el login
                        Toast.makeText(this, R.string.toast_error + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    // Navegaciones
    private void openHomeActivity(String email) {
        Intent intent = new Intent(this, HomeActivity.class); // Navegacion hacia home
        startActivity(intent);
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class); // Navegacion hacia login
        startActivity(intent);
    }

    // Metodo que valida los datos introducidos
    private boolean validateInputs(String email, String password) {
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, introduce un correo electrónico", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, introduce un correo válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor, introduce una contraseña", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}