package bo.edu.ucb.tasks.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.edu.ucb.tasks.bl.EtiquetaBl;
import bo.edu.ucb.tasks.bl.TareaBl;
import bo.edu.ucb.tasks.dto.EtiquetaRequestDto;
import bo.edu.ucb.tasks.dto.EtiquetaResponseDto;
import bo.edu.ucb.tasks.entity.Etiqueta;
import bo.edu.ucb.tasks.entity.Tarea;
import bo.edu.ucb.tasks.entity.Usuario;

@RestController
public class EtiquetaAPI {

    private static final Logger LOG = LoggerFactory.getLogger(EtiquetaAPI.class);

    private EtiquetaBl etiquetaBl;
    private TareaBl tareaBl;

    @Autowired
    public EtiquetaAPI(EtiquetaBl etiquetaBl, TareaBl tareaBl) {
        this.etiquetaBl = etiquetaBl;
        this.tareaBl = tareaBl;
    }

    @PostMapping("/api/v1/etiquetas")
    public EtiquetaResponseDto crearEtiqueta(@RequestBody EtiquetaRequestDto etiquetaRequestDto) {
        LOG.info("Solicitud recibida para crear una nueva etiqueta con nombre '{}'", etiquetaRequestDto.getNombreEtiqueta());

        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setNombreEtiqueta(etiquetaRequestDto.getNombreEtiqueta());

        if (etiquetaRequestDto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(etiquetaRequestDto.getUsuarioId());
            etiqueta.setUsuario(usuario);
        }

        Etiqueta nuevaEtiqueta = etiquetaBl.crearEtiqueta(etiqueta);
        LOG.info("Etiqueta creada con éxito. ID de la etiqueta: {}", nuevaEtiqueta.getId());

        return new EtiquetaResponseDto(nuevaEtiqueta);
    }

    @PutMapping("/api/v1/etiquetas/{id}")
    public ResponseEntity<EtiquetaResponseDto> actualizarEtiqueta(
        @PathVariable Long id,
        @RequestBody EtiquetaRequestDto etiquetaRequestDto
    ) {
        LOG.info("Solicitud recibida para actualizar la etiqueta con ID '{}'", id);

        Etiqueta etiquetaExistente = etiquetaBl.obtenerEtiquetaPorId(id);

        if (etiquetaExistente == null) {
            LOG.warn("No se encontró la etiqueta con ID '{}' para actualizar.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        etiquetaExistente.setNombreEtiqueta(etiquetaRequestDto.getNombreEtiqueta());
        Etiqueta etiquetaActualizada = etiquetaBl.actualizarEtiqueta(etiquetaExistente);
        LOG.info("Etiqueta actualizada con éxito. ID de la etiqueta actualizada: {}", etiquetaActualizada.getId());

        return new ResponseEntity<>(new EtiquetaResponseDto(etiquetaActualizada), HttpStatus.OK);
    }



    @GetMapping("/api/v1/etiquetas/{id}")
    public EtiquetaResponseDto obtenerEtiquetaPorId(@PathVariable Long id) {
        Etiqueta etiqueta = etiquetaBl.obtenerEtiquetaPorId(id);
        if (etiqueta != null) {
            return new EtiquetaResponseDto(etiqueta);
        } else {
            return new EtiquetaResponseDto("No se encontró la etiqueta con el ID proporcionado.");
        }
    }

    @GetMapping("/api/v1/etiquetas")
    public List<EtiquetaResponseDto> obtenerTodasLasEtiquetas() {
        List<Etiqueta> etiquetas = etiquetaBl.obtenerTodasLasEtiquetas();
        List<EtiquetaResponseDto> responseDtos = new ArrayList<>();
        for (Etiqueta etiqueta : etiquetas) {
            responseDtos.add(new EtiquetaResponseDto(etiqueta));
        }
        return responseDtos;
    }

    @GetMapping("/api/v1/etiquetas/usuario/{usuarioId}")
    public List<EtiquetaResponseDto> obtenerEtiquetasPorUsuario(@PathVariable Long usuarioId) {
        List<Etiqueta> etiquetas = etiquetaBl.obtenerEtiquetasPorUsuario(usuarioId);
        List<EtiquetaResponseDto> response = etiquetas.stream()
                .map(EtiquetaResponseDto::new)
                .collect(Collectors.toList());

        return response;
    }


    @DeleteMapping("/api/v1/etiquetas/{id}")
    public ResponseEntity<?> eliminarEtiqueta(@PathVariable Long id) {
        LOG.info("Solicitud recibida para eliminar la etiqueta con ID '{}'", id);

        try {
            // Obtén las tareas asociadas a la etiqueta y elimínalas
            List<Tarea> tareasAsociadas = tareaBl.obtenerTareasPorEtiqueta(id);
            for (Tarea tarea : tareasAsociadas) {
                tareaBl.eliminarTarea(tarea.getId());
            }

            // Luego, elimina la etiqueta
            boolean etiquetaEliminada = etiquetaBl.eliminarEtiqueta(id);

            if (etiquetaEliminada) {
                LOG.info("La etiqueta se eliminó correctamente.");
                return new ResponseEntity<>("La etiqueta se eliminó correctamente.", HttpStatus.OK);
            } else {
                LOG.warn("No se encontró la etiqueta con ID '{}' para eliminar.", id);
                LOG.info("La etiqueta no se pudo eliminar porque no se encontró.");
                return new ResponseEntity<>("La etiqueta no se pudo eliminar porque no se encontró.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOG.error("Error al intentar eliminar la etiqueta con ID '{}': {}", id, e.getMessage());
            return new ResponseEntity<>("Ocurrió un error al eliminar la etiqueta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
