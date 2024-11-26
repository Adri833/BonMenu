package es.thatapps.bonmenu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import es.thatapps.bonmenu.R;
import es.thatapps.bonmenu.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());

        // Usar Glide para cargar las imágenes dinámicamente
        Glide.with(holder.itemView.getContext())
                .load(product.getImageUrl()) // URL de la imagen
                .into(holder.productImage);

        // Botón "Añadir al carrito"
        holder.addToCartButton.setOnClickListener(v -> {
            // Aquí puedes manejar la lógica para añadir al carrito
            // Ejemplo: mostrar un mensaje
            // Toast.makeText(holder.itemView.getContext(), product.getName() + " añadido al carrito", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        Button addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}
