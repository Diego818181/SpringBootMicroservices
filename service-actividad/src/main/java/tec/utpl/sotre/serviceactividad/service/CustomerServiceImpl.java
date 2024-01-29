package tec.utpl.sotre.serviceactividad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.sotre.serviceactividad.entity.Actividad;
import tec.utpl.sotre.serviceactividad.entity.Curso;
import tec.utpl.sotre.serviceactividad.repository.ActividadRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public List<Actividad> findCustomerAll() {
        return actividadRepository.findAll();
    }

    @Override
    public List<Actividad> findCustomersByRegion(Curso curso) {
        return actividadRepository.findByRegion(curso);
    }

    @Override
    public Actividad createCustomer(Actividad actividad) {
        Actividad actividadDB = actividadRepository.findById(actividad.getId()).orElse(null);

        if(actividadDB !=null){
            return actividadDB;
        }

        actividad.setState("CREATED");
        actividadDB = actividadRepository.save(actividad);

        return actividadDB;
    }

    @Override
    public Actividad updateCustomer(Actividad actividad) {
        Actividad actividadDB = actividadRepository.findById(actividad.getId()).orElse(null);

        if(actividadDB ==null){
            return null;
        }

        actividadDB.setFirstName(actividad.getFirstName());
        actividadDB.setLastName(actividad.getLastName());
        actividadDB.setEmail(actividad.getEmail());
        actividadDB.setPhotoUrl(actividad.getPhotoUrl());

        return actividadRepository.save(actividadDB);
    }

    @Override
    public Actividad deleteCustomer(Long id) {
        Actividad actividadDB = actividadRepository.findById(id).orElse(null);

        if(actividadDB ==null){
            return null;
        }

        actividadRepository.delete(actividadDB);

        return actividadDB;
    }

    @Override
    public Actividad getCustomer(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }
}
