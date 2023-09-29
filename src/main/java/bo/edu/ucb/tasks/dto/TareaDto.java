package bo.edu.ucb.tasks.dto;

public class TareaDto {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String fechaEdicion;
    private String fechaExpiracion;
    private String estado;
    private Integer idUsuario;
    private Integer idEtiqueta;
    
    public TareaDto(){

    }

    public TareaDto(Integer id, String titulo, String descripcion, String fechaCreacion, String fechaEdicion, String fechaExpiracion, String estado, Integer idUsuario, Integer idEtiqueta){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaEdicion = fechaEdicion;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idEtiqueta = idEtiqueta;}

    public Integer getId(){
        return id;}

    public void setId(Integer id){
        this.id = id;}

    public String getTitulo(){
        return titulo;}

    public void setTitulo(String titulo){
        this.titulo = titulo;}
    
    public String getDescripcion(){
        return descripcion;}
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;}
    
    
    public String getFechaCreacion(){
        return fechaCreacion;}
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;}
    
    public String getFechaEdicion(){
        return fechaEdicion;}
    
    public void setFechaEdicion(String fechaEdicion){
        this.fechaEdicion = fechaEdicion;}
    
    public String getFechaExpiracion(){
        return fechaExpiracion;}
    
    public void setFechaExpiracion(String fechaExpiracion){
        this.fechaExpiracion = fechaExpiracion;}

    public String getEstado(){
        return estado;}
    
    public void setEstado(String estado){
        this.estado = estado;}
    
    public Integer getIdUsuario(){
        return idUsuario;}

    public void setIdUsuario(Integer idUsuario){
        this.idUsuario = idUsuario;}
    
    public Integer getIdEtiqueta(){
        return idEtiqueta;}
    
    public void setIdEtiqueta(Integer idEtiqueta){
        this.idEtiqueta = idEtiqueta;}

    @Override
    public String toString(){
        return "TareaDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaEdicion='" + fechaEdicion + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", estado='" + estado + '\'' +
                ", idUsuario=" + idUsuario +
                ", idEtiqueta=" + idEtiqueta +
                '}';
    }

}