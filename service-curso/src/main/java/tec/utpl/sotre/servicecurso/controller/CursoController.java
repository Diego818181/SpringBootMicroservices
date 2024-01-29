package tec.utpl.sotre.servicecurso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.sotre.servicecurso.entity.Curso;
import tec.utpl.sotre.servicecurso.entity.Region;
import tec.utpl.sotre.servicecurso.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CursoController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Curso>> listAllCustomers(@RequestParam(name = "region", required = false) Long regionId){
        List<Curso> cursos = new ArrayList<>();
        if (regionId == null){
            cursos = customerService.findCustomerAll();

            if(cursos.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        Region region = new Region();
        region.setId(regionId);
        cursos = customerService.findCustomersByRegion(region);

        if(cursos.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cursos);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Curso> getCustomer(@PathVariable("id") Long id){
        Curso curso = customerService.getCustomer(id);

        if(null == curso){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> createCustomer(@RequestBody Curso curso){
        Curso cursoCreated = customerService.createCustomer(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreated);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Curso> updateCustomer(@PathVariable Long id, @RequestBody Curso curso){
        Curso cursoDB = customerService.getCustomer(id);

        if(null== cursoDB){
            return ResponseEntity.notFound().build();
        }

        curso.setId(id);

        cursoDB = customerService.updateCustomer(curso);

        return ResponseEntity.ok(cursoDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        Curso cursoDB = customerService.getCustomer(id);

        if(null== cursoDB){
            return ResponseEntity.notFound().build();
        }

        cursoDB = customerService.deleteCustomer(id);

        return ResponseEntity.ok("Cliente eliminado");
    }

}
