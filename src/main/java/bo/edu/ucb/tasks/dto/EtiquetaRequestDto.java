package bo.edu.ucb.tasks.dto;


public class EtiquetaRequestDto {
    private String nombreEtiqueta;
    private Long usuarioId; // Agregamos un campo para el ID del usuario

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
