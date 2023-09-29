package bo.edu.ucb.tasks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.edu.ucb.tasks.bl.TareaBl;

import bo.edu.ucb.tasks.dto.TareaRequestDto;
import bo.edu.ucb.tasks.dto.TareaResponseDto;
import bo.edu.ucb.tasks.entity.Usuario;
import bo.edu.ucb.tasks.entity.Etiqueta;
import bo.edu.ucb.tasks.entity.Tarea;

import java.util.List;
import java.util.ArrayList;

@RestController
public class TareaAPI {

    private TareaBl tareaBl;

    @Autowired
    public TareaAPI(TareaBl tareaBl) {
        this.tareaBl = tareaBl;
    }

    @PostMapping("/api/v1/tareas")
    public TareaResponseDto crearTarea(@RequestBody TareaRequestDto tareaRequestDto) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(tareaRequestDto.getTitulo());
        tarea.setFechaLimite(tareaRequestDto.getFechaLimite());
        tarea.setCompletada(tareaRequestDto.isCompletada());
    
        // Si tienes un ID de usuario válido en el DTO, puedes establecerlo directamente
        if (tareaRequestDto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(tareaRequestDto.getUsuarioId());
            tarea.setUsuario(usuario);
        }
    
        // Si la etiqueta es opcional y se proporciona un ID de etiqueta válido, establece la etiqueta
        if (tareaRequestDto.getEtiquetaId() != null) {
            Etiqueta etiqueta = new Etiqueta();
            etiqueta.setId(tareaRequestDto.getEtiquetaId());
            tarea.setEtiqueta(etiqueta);
        }
    
        Tarea nuevaTarea = tareaBl.crearTarea(tarea);
        return new TareaResponseDto(nuevaTarea);
    }
    

        @GetMapping("/api/v1/tareas/{id}")
        public ResponseEntity<?> obtenerTareaPorId(@PathVariable Long id) {
            Tarea tarea = tareaBl.obtenerTareaPorId(id);
            if (tarea != null) {
                return new ResponseEntity<>(new TareaResponseDto(tarea), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontró la tarea con el ID proporcionado.", HttpStatus.NOT_FOUND);
            }
        }


    @GetMapping("/api/v1/tareas")
    public List<TareaResponseDto> obtenerTodasLasTareas() {
        List<Tarea> tareas = tareaBl.obtenerTodasLasTareas();
        List<TareaResponseDto> responseDtos = new ArrayList<>();
        for (Tarea tarea : tareas) {
            responseDtos.add(new TareaResponseDto(tarea));
        }
        return responseDtos;
    }

    @PutMapping("/api/v1/tareas/{id}/estado")
    public ResponseEntity<?> actualizarEstadoTarea(@PathVariable Long id, @RequestBody TareaRequestDto tareaRequestDto) {
        boolean nuevoEstado = tareaRequestDto.isCompletada();
        Tarea tareaActualizada = tareaBl.actualizarEstadoTarea(id, nuevoEstado);
        
    if (tareaActualizada != null) {
        return new ResponseEntity<>(new TareaResponseDto(tareaActualizada), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("No se encontró la tarea con el ID proporcionado.", HttpStatus.NOT_FOUND);
    }
}


    @DeleteMapping("/api/v1/tareas/{id}")
        public ResponseEntity<?> eliminarTarea(@PathVariable Long id) {
            tareaBl.eliminarTarea(id);
            return new ResponseEntity<>("La tarea se eliminó correctamente.", HttpStatus.OK);
        }

}
