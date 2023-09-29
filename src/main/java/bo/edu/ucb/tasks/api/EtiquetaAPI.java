package bo.edu.ucb.tasks.api;

import bo.edu.ucb.tasks.dto.EtiquetaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetaAPI {

    private final List<EtiquetaDto> etiquetas = new ArrayList<>();
    
    // Endpoint para obtener todas las etiquetas
    @GetMapping
    public ResponseEntity<List<EtiquetaDto>> obtenerTodasLasEtiquetas() {
        return ResponseEntity.ok(etiquetas);
    }

    // Endpoint para crear una nueva etiqueta
    @PostMapping
    public ResponseEntity<EtiquetaDto> crearEtiqueta(@RequestBody EtiquetaDto etiquetaDto) {
        etiquetas.add(etiquetaDto);
        return ResponseEntity.ok(etiquetaDto);
    }

    // Endpoint para eliminar una etiqueta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEtiqueta(@PathVariable Integer id) {
        // Busca y elimina la etiqueta por ID
        EtiquetaDto etiquetaEliminada = null;
        for (EtiquetaDto etiqueta : etiquetas) {
            if (etiqueta.getId().equals(id)) {
                etiquetaEliminada = etiqueta;
                break;
            }
        }
        if (etiquetaEliminada != null) {
            etiquetas.remove(etiquetaEliminada);
        }
        return ResponseEntity.noContent().build();
    }

}
