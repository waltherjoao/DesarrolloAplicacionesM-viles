package ec.com.ventaslemas;

public class Apartamento {
    public Apartamento(int imgId, String nombreApartamento, String costoApartamento) {
        this.imgId = imgId;
        this.nombreApartamento = nombreApartamento;
        this.costoApartamento = costoApartamento;
    }

    private int imgId;
    private String nombreApartamento;
    private String costoApartamento;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getNombreApartamento() {
        return nombreApartamento;
    }

    public void setNombreApartamento(String nombreApartamento) {
        this.nombreApartamento = nombreApartamento;
    }

    public String getCostoApartamento() {
        return costoApartamento;
    }

    public void setCostoApartamento(String costoApartamento) {
        this.costoApartamento = costoApartamento;
    }
}
