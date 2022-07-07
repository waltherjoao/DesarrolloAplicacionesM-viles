package ec.com.micasaapp.ui.alquiler;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ec.com.micasaapp.MiCasaApplication;
import ec.com.micasaapp.R;
import ec.com.micasaapp.adapter.ListadoAdapter;
import ec.com.micasaapp.entity.ValoresViviendaEntity;
import ec.com.micasaapp.interfaces.IMyCasa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlquierFragment extends Fragment {

    private Call<ValoresViviendaEntity> valoresViviendaEntityCall;
    RecyclerView rvAlquiler;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alquiler, container, false);
        rvAlquiler = root.findViewById(R.id.rvAlquiler);
        callConsumeWs();
        return root;
    }

    private void callConsumeWs() {
        IMyCasa iMyCasa = MiCasaApplication.getmInstance().getRestAdapter().create(IMyCasa.class);
        valoresViviendaEntityCall = iMyCasa.getViviendaWs();

        valoresViviendaEntityCall.enqueue(new Callback<ValoresViviendaEntity>() {
            @Override
            public void onResponse(Call<ValoresViviendaEntity> call, Response<ValoresViviendaEntity> response) {
                if(response.isSuccessful()){
                    ValoresViviendaEntity valoresVivienda = response.body();
                    if(valoresVivienda != null){
                        fillVivienda(valoresVivienda);
                    }
                } else {
                    Toast.makeText(getContext(), "Fallo en el servidor", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ValoresViviendaEntity> call, Throwable t) {
                Log.e(" >>>>>>> ", t.getMessage());
            }
        });
    }

    private void fillVivienda(ValoresViviendaEntity valoresVivienda) {
        ListadoAdapter alquilerAdapter = new ListadoAdapter(valoresVivienda.getData(), getActivity());
        rvAlquiler.setHasFixedSize(true);
        rvAlquiler.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAlquiler.setAdapter(alquilerAdapter);
    }
}