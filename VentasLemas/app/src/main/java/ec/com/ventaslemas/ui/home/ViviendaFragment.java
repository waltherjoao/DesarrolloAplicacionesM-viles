package ec.com.ventaslemas.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ec.com.ventaslemas.Apartamento;
import ec.com.ventaslemas.ApartamentoAdapter;
import ec.com.ventaslemas.Home;
import ec.com.ventaslemas.R;

public class ViviendaFragment extends Fragment {

    RecyclerView rvListado;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_home, container, false);
        rvListado = root.findViewById(R.id.rvListadoApartamento);
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
        ApartamentoAdapter adapter = new ApartamentoAdapter(listAapartamento, getActivity());
        rvListado.setHasFixedSize(true);
        rvListado.setLayoutManager(new LinearLayoutManager(getContext()));
        rvListado.setAdapter(adapter);
        return root;
    }
}