package tec.utpl.store.servicecurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.store.servicecurso.entity.Curso;
import tec.utpl.store.servicecurso.service.CursoService;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> getCurso(@PathVariable("id") Long id){
        Curso curso = cursoService.getCurso(id);
        if (null == curso){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.listAllCursos();

        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        Curso cursoCreate = cursoService.createCurso(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable("id") Long id, @RequestBody Curso curso){
        curso.setId(id);

        Curso cursoDB = cursoService.updateCurso(curso);

        if (cursoDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable("id") Long id){
        Curso cursoDelete = cursoService.deleteCurso(id);

        if(cursoDelete !=null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Curso eliminado");
    }
}
