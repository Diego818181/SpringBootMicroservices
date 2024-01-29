package tec.utpl.sotre.serviceactividad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.sotre.serviceactividad.entity.Actividad;
import tec.utpl.sotre.serviceactividad.entity.Curso;
import tec.utpl.sotre.serviceactividad.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class ActividadController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Actividad>> listAllCustomers(@RequestParam(name = "region", required = false) Long regionId){
        List<Actividad> actividades = new ArrayList<>();
        if (regionId == null){
            actividades = customerService.findCustomerAll();

            if(actividades.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        Curso curso = new Curso();
        curso.setId(regionId);
        actividades = customerService.findCustomersByRegion(curso);

        if(actividades.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actividades);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Actividad> getCustomer(@PathVariable("id") Long id){
        Actividad actividad = customerService.getCustomer(id);

        if(null == actividad){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actividad);
    }

    @PostMapping
    public ResponseEntity<Actividad> createCustomer(@RequestBody Actividad actividad){
        Actividad actividadCreated = customerService.createCustomer(actividad);

        return ResponseEntity.status(HttpStatus.CREATED).body(actividadCreated);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Actividad> updateCustomer(@PathVariable Long id, @RequestBody Actividad actividad){
        Actividad actividadDB = customerService.getCustomer(id);

        if(null== actividadDB){
            return ResponseEntity.notFound().build();
        }

        actividad.setId(id);

        actividadDB = customerService.updateCustomer(actividad);

        return ResponseEntity.ok(actividadDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        Actividad actividadDB = customerService.getCustomer(id);

        if(null== actividadDB){
            return ResponseEntity.notFound().build();
        }

        actividadDB = customerService.deleteCustomer(id);

        return ResponseEntity.ok("Cliente eliminado");
    }

}
