package ec.com.ventaslemas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApartamentoAdapter extends RecyclerView.Adapter<ApartamentoAdapter.ViewHolder> {

    private List<Apartamento> lstApartamentos;
    private Context _ctx;

    public ApartamentoAdapter(List<Apartamento> lstApartamentos, Context ctx) {
        this.lstApartamentos = lstApartamentos;
        this._ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.modelo_apartamento, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Apartamento objApartamento = lstApartamentos.get(position);
        holder.imgApartamento.setImageResource(objApartamento.getImgId());
        holder.txtNombreApartamento.setText(objApartamento.getNombreApartamento());
        holder.txtPrecio.setText(objApartamento.getCostoApartamento());
        holder.lytApartamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_ctx.getApplicationContext(), DetalleApartamento.class);
                intent.putExtra("imagen", objApartamento.getImgId());
                intent.putExtra("nombreDpto", objApartamento.getNombreApartamento());
                intent.putExtra("precioDpto", objApartamento.getCostoApartamento());
                _ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstApartamentos.size();
    }

    
    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgApartamento;
        private TextView txtNombreApartamento;
        private TextView txtPrecio;
        private LinearLayout lytApartamento;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imgApartamento = (ImageView) itemView.findViewById(R.id.imgApartamento);
            this.txtNombreApartamento = (TextView) itemView.findViewById(R.id.txtNombreApartamento);
            this.txtPrecio = (TextView) itemView.findViewById(R.id.txtValor);
            this.lytApartamento = (LinearLayout) itemView.findViewById(R.id.lytItemApt);
        }
    }
}
