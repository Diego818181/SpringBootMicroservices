package tec.utpl.store.servicecurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.store.servicecurso.entity.Estudiante;
import tec.utpl.store.servicecurso.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping(value = "/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estudiante> getEstudiante(@PathVariable("id") Long id){
        Estudiante estudiante = estudianteService.getEstudiante(id);
        if (null == estudiante){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listAllEstudiantes();

        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante){
        Estudiante estudianteCreate = estudianteService.createEstudiante(estudiante);

        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable("id") Long id, @RequestBody Estudiante estudiante){
        estudiante.setId(id);

        Estudiante estudianteDB = estudianteService.updateEstudiante(estudiante);

        if (estudianteDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudianteDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEstudiante(@PathVariable("id") Long id){
        Estudiante estudianteDelete = estudianteService.deleteEstudiante(id);

        if(estudianteDelete !=null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Estudiante eliminado");
    }
}
