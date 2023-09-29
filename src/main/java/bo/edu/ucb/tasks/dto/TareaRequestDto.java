package bo.edu.ucb.tasks.dto;

import java.util.Date;

public class TareaRequestDto {
    private String titulo;
    private Date fechaLimite;
    private boolean completada;
    private Long usuarioId; // ID del usuario al que se asignará la tarea
    private Long etiquetaId; // ID de la etiqueta asociada a la tarea (si es necesario)

    public TareaRequestDto() {
    }

    public TareaRequestDto(String titulo, Date fechaLimite, boolean completada ,Long usuarioId, Long etiquetaId) {
        this.titulo = titulo;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
        this.usuarioId = usuarioId;
        this.etiquetaId = etiquetaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(Long etiquetaId) {
        this.etiquetaId = etiquetaId;
    }
}
