package bo.edu.ucb.tasks.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.stream.Collectors;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TareaAPI {

    private static final Logger LOG = LoggerFactory.getLogger(TareaAPI.class);

    private TareaBl tareaBl;

    @Autowired
    public TareaAPI(TareaBl tareaBl) {
        this.tareaBl = tareaBl;
    }

    @PostMapping("/api/v1/tareas")
    public TareaResponseDto crearTarea(@RequestBody TareaRequestDto tareaRequestDto) {
        LOG.info("Solicitud recibida para crear una nueva tarea con título '{}'", tareaRequestDto.getTitulo());

        Tarea tarea = new Tarea();
        tarea.setTitulo(tareaRequestDto.getTitulo());
        tarea.setFechaLimite(tareaRequestDto.getFechaLimite());
        tarea.setCompletada(tareaRequestDto.isCompletada());

        if (tareaRequestDto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(tareaRequestDto.getUsuarioId());
            tarea.setUsuario(usuario);
        }

        if (tareaRequestDto.getEtiquetaId() != null) {
            Etiqueta etiqueta = new Etiqueta();
            etiqueta.setId(tareaRequestDto.getEtiquetaId());
            tarea.setEtiqueta(etiqueta);
        }

        Tarea nuevaTarea = tareaBl.crearTarea(tarea);
        LOG.info("Tarea creada con éxito. ID de la tarea: {}", nuevaTarea.getId());

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
    @GetMapping("/api/v1/tareas/usuario/{usuarioId}")
        public ResponseEntity<List<TareaResponseDto>> obtenerTareasPorUsuario(@PathVariable Long usuarioId) {
            List<Tarea> tareas = tareaBl.obtenerTareasPorUsuario(usuarioId);
            
            List<TareaResponseDto> response = tareas.stream()
                    .map(TareaResponseDto::new)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }


        @PutMapping("/api/v1/tareas/{id}/estado")
        public ResponseEntity<?> actualizarEstadoTarea(@PathVariable Long id, @RequestBody TareaRequestDto tareaRequestDto) {
            LOG.info("Solicitud recibida para actualizar el estado de la tarea con ID '{}'", id);
    
            boolean nuevoEstado = tareaRequestDto.isCompletada();
            Tarea tareaActualizada = tareaBl.actualizarEstadoTarea(id, nuevoEstado);
    
            if (tareaActualizada != null) {
                LOG.info("Estado de la tarea actualizado con éxito. ID de la tarea actualizada: {}", tareaActualizada.getId());
                return new ResponseEntity<>(new TareaResponseDto(tareaActualizada), HttpStatus.OK);
            } else {
                LOG.warn("No se encontró la tarea con ID '{}' para actualizar el estado.", id);
                return new ResponseEntity<>("No se encontró la tarea con el ID proporcionado.", HttpStatus.NOT_FOUND);
            }
        }


        @DeleteMapping("/api/v1/tareas/{id}")
        public ResponseEntity<?> eliminarTarea(@PathVariable Long id) {
            LOG.info("Solicitud recibida para eliminar la tarea con ID '{}'", id);
        
            boolean tareaEliminada = tareaBl.eliminarTarea(id);
        
            if (tareaEliminada) {
                LOG.info("La tarea se eliminó correctamente.");
                return new ResponseEntity<>("La tarea se eliminó correctamente.", HttpStatus.OK);
            } else {
                LOG.warn("No se encontró la tarea con ID '{}' para eliminar.", id);
                LOG.info("La tarea no se pudo eliminar porque no se encontró.");
                return new ResponseEntity<>("La tarea no se pudo eliminar porque no se encontró.", HttpStatus.NOT_FOUND);
            }
        }
        


}
