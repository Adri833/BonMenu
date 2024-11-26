package es.thatapps.bonmenu;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import es.thatapps.bonmenu.adapter.ProductAdapter;
import es.thatapps.bonmenu.model.Product;

public class MercadonaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercadona);

        // Imagen del supermercado
        ImageView storeImage = findViewById(R.id.storeImage);
        Glide.with(this)
                .load("https://drive.google.com/uc?export=download&id=1vNdzHruoGWO2qqqT3sMoPqIiTmZRR93S") // Imagen de la tienda
                .placeholder(R.drawable.placeholder)
                .into(storeImage);

        // Configurar RecyclerView
        RecyclerView productList = findViewById(R.id.productList);
        productList.setLayoutManager(new GridLayoutManager(this, 2));

        // Lista de productos
        List<Product> products = new ArrayList<>();
        products.add(new Product("Patatas crujientes", "https://drive.google.com/uc?export=download&id=1DKA0eu1GoBsfUUExjVpc8NYA30UuODVW"));
        products.add(new Product("Patatas fritas clásicas", "https://drive.google.com/uc?export=download&id=1cyq6ZfGJk6xpqLj0w51OX-h6GHS2UeQs"));
        products.add(new Product("Patatas fritas lisas", "https://drive.google.com/uc?export=download&id=1_xyiCX8Xgnw3SJ_BDRntQkoS0qC0ojKf"));
        products.add(new Product("Patatas fritas serrano", "https://drive.google.com/uc?export=download&id=1taTrBBfq-jdml7J8xalyv5T214dICYgh"));

        // Adaptador para productos
        ProductAdapter adapter = new ProductAdapter(products);
        productList.setAdapter(adapter);
    }
}
