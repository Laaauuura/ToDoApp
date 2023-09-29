package bo.edu.ucb.tasks.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bo.edu.ucb.tasks.bl.EtiquetaBl;
import bo.edu.ucb.tasks.dto.EtiquetaRequestDto;
import bo.edu.ucb.tasks.dto.EtiquetaResponseDto;
import bo.edu.ucb.tasks.entity.Etiqueta;
import bo.edu.ucb.tasks.entity.Usuario;



@RestController
public class EtiquetaAPI {

    private EtiquetaBl etiquetaBl;

    @Autowired
    public EtiquetaAPI(EtiquetaBl etiquetaBl) {
        this.etiquetaBl = etiquetaBl;
    }

    @PostMapping("/api/v1/etiquetas")
    public EtiquetaResponseDto crearEtiqueta(@RequestBody EtiquetaRequestDto etiquetaRequestDto) {
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setNombreEtiqueta(etiquetaRequestDto.getNombreEtiqueta());

        if (etiquetaRequestDto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(etiquetaRequestDto.getUsuarioId());
            etiqueta.setUsuario(usuario);
        }

        Etiqueta nuevaEtiqueta = etiquetaBl.crearEtiqueta(etiqueta);
        return new EtiquetaResponseDto(nuevaEtiqueta);
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
    
    // Mapear las etiquetas a EtiquetaResponseDto y devolver la lista
    List<EtiquetaResponseDto> response = etiquetas.stream()
            .map(EtiquetaResponseDto::new)
            .collect(Collectors.toList());

    return response;
}


    @DeleteMapping("/api/v1/etiquetas/{id}")
    public EtiquetaResponseDto eliminarEtiqueta(@PathVariable Long id) {
        etiquetaBl.eliminarEtiqueta(id);
        return new EtiquetaResponseDto("La etiqueta se eliminó correctamente.");
    }
}
