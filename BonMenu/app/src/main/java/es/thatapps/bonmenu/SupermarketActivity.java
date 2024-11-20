package es.thatapps.bonmenu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supermarket);

        // Referencia al RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Configura el LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de supermercados
        List<Supermercado> supermercados = new ArrayList<>();
        supermercados.add(new Supermercado("Mercadona", "https://drive.google.com/uc?export=download&id=1lZBOyaL9YP4_2OX77ss3E4qDOuT6hHJB"));
        supermercados.add(new Supermercado("Ese", "https://drive.google.com/uc?export=download&id=1lZBOyaL9YP4_2OX77ss3E4qDOuT6hHJB"));
        supermercados.add(new Supermercado("Puto", "https://drive.google.com/uc?export=download&id=1lZBOyaL9YP4_2OX77ss3E4qDOuT6hHJB"));
        supermercados.add(new Supermercado("Tito", "https://drive.google.com/uc?export=download&id=1lZBOyaL9YP4_2OX77ss3E4qDOuT6hHJB"));
        supermercados.add(new Supermercado("Berto", "https://drive.google.com/uc?export=download&id=1lZBOyaL9YP4_2OX77ss3E4qDOuT6hHJB"));

        // Crea el adaptador y pasa la lista de supermercados al adaptador
        SupermarketAdapter adapter = new SupermarketAdapter(supermercados, this);
        recyclerView.setAdapter(adapter);
    }
}
