package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // Cargar logo con glide
        String imageLogo = "https://drive.google.com/uc?export=download&id=1UZWSSZk2axQthSsT6Pm9u3d5g4FhFmau";
        ImageView logo = findViewById(R.id.logo);

        Glide.with(this)
                .load(imageLogo)
                .placeholder(R.drawable.placeholder)
                .into(logo);

        // Inicializar Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        // Obtener el usuario actual
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        // Variables de los elementos
        TextView emailTextView = findViewById(R.id.emailTextView);
        EditText currentPasswordEditText = findViewById(R.id.currentPasswordEditText);
        EditText newPasswordEditText = findViewById(R.id.newPasswordEditText);
        EditText confirmNewPasswordEditText = findViewById(R.id.confirmNewPasswordEditText);
        Button saveButton = findViewById(R.id.saveButton);

        // Mostrar el correo del usuario autenticado
        if (currentUser != null && currentUser.getEmail() != null) {
            emailTextView.setText(currentUser.getEmail());
        } else {
            emailTextView.setText("Correo no disponible");
        }

        // Listener para cambiar la contraseña
        saveButton.setOnClickListener(v -> {
            String currentPassword = currentPasswordEditText.getText().toString().trim();
            String newPassword = newPasswordEditText.getText().toString().trim();
            String confirmPassword = confirmNewPasswordEditText.getText().toString().trim();

            if (validateInputs(currentPassword, newPassword, confirmPassword)) {
                reauthenticateAndChangePassword(currentPassword, newPassword);
            }
        });

        // Navegacion inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                openHomeActivity();
                return true;
            }
            return false;
        });
    }

    // Navegacion
    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class); // Navegacion hacia home
        startActivity(intent);
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class); // Navegacion hacia home
        startActivity(intent);
    }
    // Metodo para validar las contraseñas
    private boolean validateInputs(String currentPassword, String newPassword, String confirmPassword) {
        if (TextUtils.isEmpty(currentPassword)) {
            Toast.makeText(this, "Por favor, introduce tu contraseña actual", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas nuevas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (newPassword.length() < 6) {
            Toast.makeText(this, "La nueva contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Metodo para reautenticar y cambiar la contraseña
    private void reauthenticateAndChangePassword(String currentPassword, String newPassword) {
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null && currentUser.getEmail() != null) {
            // Crear las credenciales del usuario
            AuthCredential credential = EmailAuthProvider.getCredential(currentUser.getEmail(), currentPassword);

            // Reautenticar al usuario (Metodo que brinda Firebase para comprobar la contraseña asociada al correo)
            currentUser.reauthenticate(credential).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    // Cambiar la contraseña
                    currentUser.updatePassword(newPassword).addOnCompleteListener(updateTask -> {
                        if (updateTask.isSuccessful()) {
                            Toast.makeText(this, R.string.toast_password_updated, Toast.LENGTH_SHORT).show();
                            openLoginActivity();
                        } else {
                            Toast.makeText(this, R.string.toast_error, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(this, R.string.toast_actual_password, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, R.string.auth_error, Toast.LENGTH_SHORT).show();
        }
    }
}