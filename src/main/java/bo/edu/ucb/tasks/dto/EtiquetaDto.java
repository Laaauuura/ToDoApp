package bo.edu.ucb.tasks.dto;

public class EtiquetaDto {
    private Integer id;
    private String nombreEtiqueta;
    private Integer idUsuario;


    public EtiquetaDto() {
        // Constructor vacío
    }
    public EtiquetaDto(Integer id, String nombreEtiqueta, Integer idUsuario) {
        this.id = id;
        this.nombreEtiqueta = nombreEtiqueta;
        this.idUsuario = idUsuario;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }
    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Override
    public String toString() {
        return "EtiquetaDto{" +
                "id=" + id +
                ", nombreEtiqueta='" + nombreEtiqueta + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }

    
}
