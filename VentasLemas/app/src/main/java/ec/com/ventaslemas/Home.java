package ec.com.ventaslemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView rvListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvListado = findViewById(R.id.rvListadoApartamento);
        List<Apartamento> listAapartamento = new ArrayList<>();
        Apartamento apartamentoBellavista = new Apartamento(android.R.drawable.ic_dialog_email, "Bellavista", "$600");
        listAapartamento.add(apartamentoBellavista);

        //-----
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_info, "Miraflores", "$550"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_delete, "Guasmo", "$130"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_dialer, "Fertisa", "$160"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_alert, "7 Lagos", "$150"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_map, "9 de Octubre", "$200"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_email, "Santiago Roldos", "$110"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_menu_day, "Recreo", "$180"));

        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_alert, "Sauces", "$150"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_map, "Los Rosales", "$200"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_dialog_email, "Samanes", "$210"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_input_add, "Los Geranios", "$170"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_input_delete, "Urdesa", "$400"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_input_get, "Bastion", "$150"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_media_pause, "Mucho Lote 1", "$180"));
        listAapartamento.add(new Apartamento(android.R.drawable.ic_media_play, "Luz del Guayas", "$170"));

        //-----
        ApartamentoAdapter adapter = new ApartamentoAdapter(listAapartamento, Home.this);
        rvListado.setHasFixedSize(true);
        rvListado.setLayoutManager(new LinearLayoutManager(this));
        rvListado.setAdapter(adapter);
    }
}