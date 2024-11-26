package es.thatapps.bonmenu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import es.thatapps.bonmenu.MercadonaActivity;
import es.thatapps.bonmenu.R;
import es.thatapps.bonmenu.model.Supermercado;

public class SupermarketAdapter extends RecyclerView.Adapter<SupermarketAdapter.ViewHolder> {

    private List<Supermercado> supermercados;
    private Context context;

    // Constructor
    public SupermarketAdapter(List<Supermercado> supermercados, Context context) {
        this.supermercados = supermercados;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_supermarket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Supermercado supermercado = supermercados.get(position);
        holder.nombre.setText(supermercado.getNombre());

        // Usar Glide para cargar imágenes
        Glide.with(context)
                .load(supermercado.getImagenUrl())
                .placeholder(R.drawable.placeholder)
                .into(holder.imagen);

        // Configurar clic en el elemento
        holder.itemView.setOnClickListener(v -> {
            if (supermercado.getNombre().equals("Mercadona")) {
                Intent intent = new Intent(context, MercadonaActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return supermercados.size();
    }

    // Clase ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.supermarketName);
            imagen = itemView.findViewById(R.id.supermarketImage);
        }
    }
}
