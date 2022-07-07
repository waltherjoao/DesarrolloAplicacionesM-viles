package ec.com.micasaapp.interfaces;

import ec.com.micasaapp.entity.ValoresViviendaEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IMyCasa {

    @GET("b0e27757-d660-4673-b4c4-b8a210eb98bf")
    Call<ValoresViviendaEntity> getViviendaWs();
}
