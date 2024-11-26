package es.thatapps.bonmenu;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.thatapps.bonmenu.adapter.SupermarketAdapter;
import es.thatapps.bonmenu.model.Supermercado;

public class SupermarketActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de supermercados
        List<Supermercado> supermercados = new ArrayList<>();
        supermercados.add(new Supermercado("Mercadona", "https://drive.google.com/uc?export=download&id=1vNdzHruoGWO2qqqT3sMoPqIiTmZRR93S"));
        supermercados.add(new Supermercado("Lidl", "https://drive.google.com/uc?export=download&id=1380U_QDiZNi7NkiYJdBaYQI9WqkdGqv_"));
        supermercados.add(new Supermercado("Carrefour", "https://drive.google.com/uc?export=download&id=161sfgzM24yXv9wOcw8rDbIMGjXieUwma"));
        supermercados.add(new Supermercado("Dia", "https://drive.google.com/uc?export=download&id=1M5pf8Sm_S935gaPWZaaAI_IsM7FDrC81"));
        supermercados.add(new Supermercado("Alcampo", "https://drive.google.com/uc?export=download&id=1mWlstkXrQvfUumA5ecQ_MnSM0QxqB8Bb"));

        // Configura el adaptador
        SupermarketAdapter adapter = new SupermarketAdapter(supermercados, this);
        recyclerView.setAdapter(adapter);
    }
}
