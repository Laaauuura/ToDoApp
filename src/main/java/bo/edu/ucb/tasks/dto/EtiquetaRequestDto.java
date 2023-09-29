package bo.edu.ucb.tasks.dto;

public class EtiquetaRequestDto {
    private String nombreEtiqueta;

    public EtiquetaRequestDto() {
    }

    public EtiquetaRequestDto(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
}
