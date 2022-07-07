package ec.com.micasaapp.entity;

public class ViviendaEntity {

    public ViviendaEntity(int id, String nombreApartamento, String descripcionApartamento, String imagen, int precio) {
        this.id = id;
        this.nombreApartamento = nombreApartamento;
        this.descripcionApartamento = descripcionApartamento;
        this.imagen = imagen;
        this.precio = precio;
    }

    private int id;
    private String nombreApartamento;
    private String descripcionApartamento;
    private String imagen;
    private int precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreApartamento() {
        return nombreApartamento;
    }

    public void setNombreApartamento(String nombreApartamento) {
        this.nombreApartamento = nombreApartamento;
    }

    public String getDescripcionApartamento() {
        return descripcionApartamento;
    }

    public void setDescripcionApartamento(String descripcionApartamento) {
        this.descripcionApartamento = descripcionApartamento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
