package ec.com.ventaslemas;

import java.util.List;

public class Vivienda {
    private int status;
    private String mensaje;
    private List<DetalleVivienda> data;

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

    public List<DetalleVivienda> getData() {
        return data;
    }

    public void setData(List<DetalleVivienda> data) {
        this.data = data;
    }
}
