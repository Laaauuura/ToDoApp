package bo.edu.ucb.tasks.dto;

import bo.edu.ucb.tasks.entity.Etiqueta;

public class EtiquetaResponseDto {
    private Long id;
    private String nombreEtiqueta;
    private String message;

    public EtiquetaResponseDto() {
    }

    public EtiquetaResponseDto(Etiqueta etiqueta) {
        this.id = etiqueta.getId();
        this.nombreEtiqueta = etiqueta.getNombreEtiqueta();
    }

    public EtiquetaResponseDto(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
