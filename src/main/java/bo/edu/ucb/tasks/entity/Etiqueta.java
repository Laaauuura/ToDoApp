package bo.edu.ucb.tasks.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_etiqueta", nullable = false)
    private String nombreEtiqueta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Integer usuario;

    // Constructor vacío
    public Etiqueta() {
    }

    // Constructor con el nombre de etiqueta
    public Etiqueta(String nombreEtiqueta, Integer usuario) {
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

    public Integer getUsuario() {
        return usuario;
    }
    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", nombreEtiqueta='" + nombreEtiqueta + '\'' +
                '}';
    }

    // Otras propiedades y métodos de la entidad
}
