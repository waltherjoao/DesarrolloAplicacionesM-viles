package ec.com.ventaslemas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ILemasApi {

    @GET("c9452f8f-c444-4483-86b5-5470d5835b48")
    Call<Vivienda> getViviendaDisponible();
}
