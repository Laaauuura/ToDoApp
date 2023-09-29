package bo.edu.ucb.tasks.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @Column(name = "completada")
    private boolean completada;

    @Column(name = "fecha_completada")
    private Date fechaCompletada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id")
    private Etiqueta etiqueta;

    // Constructor vacío
    public Tarea() {
    }

    // Constructor con parámetros
    public Tarea(String titulo, Date fechaLimite, boolean completada, Date fechaCompletada, Usuario usuario, Etiqueta etiqueta) {
        this.titulo = titulo;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
        this.fechaCompletada = fechaCompletada;
        this.usuario = usuario;
        this.etiqueta = etiqueta;
    }

    // Getters y setters
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaLimite=" + fechaLimite +
                ", completada=" + completada +
                ", fechaCompletada=" + fechaCompletada +
                ", usuario=" + usuario +
                ", etiqueta=" + etiqueta +
                '}';
    }

}
