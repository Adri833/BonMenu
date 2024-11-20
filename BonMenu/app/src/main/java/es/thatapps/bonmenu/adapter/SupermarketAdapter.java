package es.thatapps.bonmenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import es.thatapps.bonmenu.R;
import es.thatapps.bonmenu.model.Supermercado;

// Clase adaptador para que RecyclerView pueda mostrar los supermercados
public class SupermarketAdapter extends RecyclerView.Adapter<SupermarketAdapter.ViewHolder> {
    private List<Supermercado> supermercados;
    private Context context;

    // Constructor
    public SupermarketAdapter(List<Supermercado> supermercados, Context context) {
        this.supermercados = supermercados;
        this.context = context;
    }

    // Crea nuevos elementos de la lista
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_supermarket, parent, false); // Infla el diseño xml del item
        return new ViewHolder(view); // Devuelve el ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Supermercado supermercado = supermercados.get(position);

        holder.nombre.setText(supermercado.getNombre());
        Glide.with(context).load(supermercado.getImagenUrl()).into(holder.imagen); // Carga las imagenes con Glide
    }

    // Devuelve el tamaño de la lista
    @Override
    public int getItemCount() {
        return supermercados.size();
    }

    // Clase interna para representar un elemento de la lista
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
