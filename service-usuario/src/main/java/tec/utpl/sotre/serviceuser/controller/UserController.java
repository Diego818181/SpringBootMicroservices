package tec.utpl.sotre.serviceuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.sotre.serviceuser.entity.User;
import tec.utpl.sotre.serviceuser.entity.Region;
import tec.utpl.sotre.serviceuser.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class UserController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<User>> listAllCustomers(@RequestParam(name = "region", required = false) Long regionId){
        List<User> users = new ArrayList<>();
        if (regionId == null){
            users = customerService.findCustomerAll();

            if(users.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }

        Region region = new Region();
        region.setId(regionId);
        users = customerService.findCustomersByRegion(region);

        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> getCustomer(@PathVariable("id") Long id){
        User user = customerService.getCustomer(id);

        if(null == user){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createCustomer(@RequestBody User user){
        User userCreated = customerService.createCustomer(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> updateCustomer(@PathVariable Long id, @RequestBody User user){
        User userDB = customerService.getCustomer(id);

        if(null== userDB){
            return ResponseEntity.notFound().build();
        }

        user.setId(id);

        userDB = customerService.updateCustomer(user);

        return ResponseEntity.ok(userDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        User userDB = customerService.getCustomer(id);

        if(null== userDB){
            return ResponseEntity.notFound().build();
        }

        userDB = customerService.deleteCustomer(id);

        return ResponseEntity.ok("Cliente eliminado");
    }

}
