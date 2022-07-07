package ec.com.micasaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ec.com.micasaapp.R;
import ec.com.micasaapp.activities.DetalleActivity;
import ec.com.micasaapp.entity.ViviendaEntity;
import ec.com.micasaapp.utils.Utils;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ViewHolder> {

    private List<ViviendaEntity> lstViviedas;
    private Context _ctx;

    public ListadoAdapter(List<ViviendaEntity> lstViviedas, Context ctx) {
        this.lstViviedas = lstViviedas;
        this._ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViviendaEntity objVivienda = lstViviedas.get(position);
        Utils.loadImage(objVivienda.getImagen(), holder.imgApartamento);
        holder.tvNombre.setText(objVivienda.getNombreApartamento());
        holder.tvPrecio.setText(objVivienda.getPrecio()+"");
        holder.cvItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_ctx.getApplicationContext(), DetalleActivity.class);
                intent.putExtra("imagen", objVivienda.getImagen());
                intent.putExtra("nombreDpto", objVivienda.getNombreApartamento());
                intent.putExtra("precioDpto", objVivienda.getPrecio());
                intent.putExtra("detalleDpto", objVivienda.getDescripcionApartamento());
                _ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstViviedas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgApartamento;
        private TextView tvNombre;
        private TextView tvPrecio;
        private CardView cvItems;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgApartamento = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.tvNombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            this.tvPrecio = (TextView) itemView.findViewById(R.id.tv_precio);
            this.cvItems = (CardView) itemView.findViewById(R.id.cv_items);
        }
    }
}
