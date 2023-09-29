package bo.edu.ucb.tasks.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_etiqueta", nullable = false)
    private String nombreEtiqueta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructor vacío
    public Etiqueta() {
    }

    // Constructor con parámetros
    public Etiqueta(String nombreEtiqueta, Usuario usuario) {
        this.nombreEtiqueta = nombreEtiqueta;
        this.usuario = usuario;
    }

    // Getters y setters
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombreEtiqueta='" + nombreEtiqueta + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}