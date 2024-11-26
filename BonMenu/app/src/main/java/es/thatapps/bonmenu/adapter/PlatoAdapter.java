package es.thatapps.bonmenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import es.thatapps.bonmenu.R;
import es.thatapps.bonmenu.model.Plato;

public class PlatoAdapter extends RecyclerView.Adapter<PlatoAdapter.ViewHolder> {
    private List<Plato> platos;
    private Context context;

    public PlatoAdapter(List<Plato> platos, Context context) {
        this.platos = platos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plato, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plato plato = platos.get(position);

        holder.nombre.setText(plato.getNombre());
        holder.descripcion.setText(plato.getDescripcion());
        holder.imagen.setImageResource(plato.getImagenResource());
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, descripcion;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.platoName);
            descripcion = itemView.findViewById(R.id.platoDescription);
            imagen = itemView.findViewById(R.id.platoImage);
        }
    }
}
