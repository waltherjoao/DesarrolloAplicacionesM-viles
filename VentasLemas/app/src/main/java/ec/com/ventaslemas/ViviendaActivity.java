package ec.com.ventaslemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViviendaActivity extends AppCompatActivity {

    private Call<Vivienda> callVivienda;
    RecyclerView rvViviendas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda);
        rvViviendas = findViewById(R.id.rvListadoVivienda);
        callConsumeWs();
    }

    private void callConsumeWs() {
        ILemasApi iLemasApi = LemasApplication.getmInstance().getRestAdapter().create(ILemasApi.class);
        callVivienda = iLemasApi.getViviendaDisponible();
        callVivienda.enqueue(new Callback<Vivienda>() {
            @Override
            public void onResponse(Call<Vivienda> call, Response<Vivienda> response) {
                if (response.isSuccessful()){
                    Vivienda vivienda = response.body();
                    if (vivienda != null) {
                        Toast.makeText(ViviendaActivity.this, vivienda.getMensaje(), Toast.LENGTH_LONG).show();
                        fillRvVivienda(vivienda);
                    }
                } else {
                    Toast.makeText(ViviendaActivity.this, "Fallo en el servidor", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Vivienda> call, Throwable t) {
                Log.e(" >>>>>>> ", t.getMessage());
            }
        });
    }

    private void fillRvVivienda(Vivienda vivienda) {
        ViviendaAdapter viviendaAdapter = new ViviendaAdapter(vivienda.getData(), this);
        rvViviendas.setHasFixedSize(true);
        rvViviendas.setLayoutManager(new LinearLayoutManager(this));
        rvViviendas.setAdapter(viviendaAdapter);
    }
}