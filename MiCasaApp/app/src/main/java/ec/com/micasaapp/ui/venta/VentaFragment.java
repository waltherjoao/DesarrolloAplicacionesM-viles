package ec.com.micasaapp.ui.venta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ec.com.micasaapp.R;
import ec.com.micasaapp.adapter.ListadoAdapter;
import ec.com.micasaapp.entity.ViviendaEntity;

public class VentaFragment extends Fragment {

    RecyclerView rvVentas;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_venta, container, false);
        rvVentas = root.findViewById(R.id.rv_venta);
        List<ViviendaEntity> listVivienda = new ArrayList<>();
        ViviendaEntity viviendaEntity = new ViviendaEntity(1, "Centro de Guayaquil", "Apt en el 2do piso", "imgen", 60000);
        ViviendaEntity viviendaEntity2 = new ViviendaEntity(2, "Suburbio de Guayaquil", "Edificio", "imgen", 85000);
        listVivienda.add(viviendaEntity);
        listVivienda.add(viviendaEntity2);

        ListadoAdapter adapter = new ListadoAdapter(listVivienda, getActivity());
        rvVentas.setHasFixedSize(true);
        rvVentas.setLayoutManager(new LinearLayoutManager(getContext()));
        rvVentas.setAdapter(adapter);
        return root;
    }
}