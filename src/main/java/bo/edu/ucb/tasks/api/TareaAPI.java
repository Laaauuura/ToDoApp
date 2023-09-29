package bo.edu.ucb.tasks.api;
import bo.edu.ucb.tasks.dto.TareaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaAPI {

    private final List<TareaDto> tareas = new ArrayList<>();
    
    // Endpoint para obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<TareaDto>> obtenerTodasLasTareas() {
        return ResponseEntity.ok(tareas);
    }

    // Endpoint para crear una nueva tarea
    @PostMapping
    public ResponseEntity<TareaDto> crearTarea(@RequestBody TareaDto tareaDto) {
        tareas.add(tareaDto);
        return ResponseEntity.ok(tareaDto);
    }

    // Endpoint para eliminar una tarea por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Integer id) {
        // Busca y elimina la tarea por ID
        TareaDto tareaEliminada = null;
        for (TareaDto tarea : tareas) {
            if (tarea.getId().equals(id)) {
                tareaEliminada = tarea;
                break;
            }
        }
        if (tareaEliminada != null) {
            tareas.remove(tareaEliminada);
        }
        return ResponseEntity.noContent().build();
    }
}
