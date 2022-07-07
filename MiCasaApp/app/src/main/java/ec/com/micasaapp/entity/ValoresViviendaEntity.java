package ec.com.micasaapp.entity;

import java.util.List;

public class ValoresViviendaEntity {
    private int status;
    private String mensaje;
    private List<ViviendaEntity> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<ViviendaEntity> getData() {
        return data;
    }

    public void setData(List<ViviendaEntity> data) {
        this.data = data;
    }
}
