package bo.edu.ucb.tasks.dto;

import bo.edu.ucb.tasks.entity.Tarea;

import java.util.Date;

public class TareaResponseDto {
    private Long id;
    private String titulo;
    private Date fechaLimite;
    private boolean completada;
    private Date fechaCompletada;
    private Long usuarioId;
    private Long etiquetaId;

    public TareaResponseDto() {
    }

    public TareaResponseDto(Tarea tarea) {
        this.id = tarea.getId();
        this.titulo = tarea.getTitulo();
        this.fechaLimite = tarea.getFechaLimite();
        this.completada = tarea.isCompletada();
        this.fechaCompletada = tarea.getFechaCompletada();
        this.usuarioId = tarea.getUsuario().getId();
        this.etiquetaId = tarea.getEtiqueta() != null ? tarea.getEtiqueta().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Date getFechaCompletada() {
        return fechaCompletada;
    }

    public void setFechaCompletada(Date fechaCompletada) {
        this.fechaCompletada = fechaCompletada;
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
