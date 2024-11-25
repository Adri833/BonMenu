package es.thatapps.bonmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // Aqui recogemos los correos del intent
        String userEmail = getIntent().getStringExtra("USER_EMAIL");
        String userEmail2 = getIntent().getStringExtra("USER_EMAIL2");

        // Aqui configuramos la vista de los elementos
        TextView emailTextView = findViewById(R.id.emailTextView);
        EditText newPasswordEditText = findViewById(R.id.newPasswordEditText);
        EditText confirmNewPasswordEditText = findViewById(R.id.confirmNewPasswordEditText);
        Button saveButton = findViewById(R.id.saveButton);


        if (userEmail != null && !userEmail.isEmpty()) {
            emailTextView.setText(userEmail);
        } else if (userEmail2 != null && !userEmail2.isEmpty()) {
            emailTextView.setText(userEmail2);
        } else {
            emailTextView.setText("Correo no disponible");
        }

        // Listener para guardar la nueva contraseña
        saveButton.setOnClickListener(v -> {
            String newPassword = newPasswordEditText.getText().toString().trim();
            String confirmPassword = confirmNewPasswordEditText.getText().toString().trim();

            if (validatePasswords(newPassword, confirmPassword)) {
                // Aquí puedes guardar la nueva contraseña
                Toast.makeText(this, "Contraseña actualizada correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para validar las contraseñas
    private boolean validatePasswords(String password, String confirmPassword) {
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
