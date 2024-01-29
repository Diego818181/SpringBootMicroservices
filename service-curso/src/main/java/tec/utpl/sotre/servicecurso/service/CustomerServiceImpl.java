package tec.utpl.sotre.servicecurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.sotre.servicecurso.entity.Curso;
import tec.utpl.sotre.servicecurso.entity.Region;
import tec.utpl.sotre.servicecurso.repository.CursoRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Curso> findCustomerAll() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> findCustomersByRegion(Region region) {
        return cursoRepository.findByRegion(region);
    }

    @Override
    public Curso createCustomer(Curso curso) {
        Curso cursoDB = cursoRepository.findById(curso.getId()).orElse(null);

        if(cursoDB !=null){
            return cursoDB;
        }

        curso.setState("CREATED");
        cursoDB = cursoRepository.save(curso);

        return cursoDB;
    }

    @Override
    public Curso updateCustomer(Curso curso) {
        Curso cursoDB = cursoRepository.findById(curso.getId()).orElse(null);

        if(cursoDB ==null){
            return null;
        }

        cursoDB.setFirstName(curso.getFirstName());
        cursoDB.setLastName(curso.getLastName());
        cursoDB.setEmail(curso.getEmail());
        cursoDB.setPhotoUrl(curso.getPhotoUrl());

        return cursoRepository.save(cursoDB);
    }

    @Override
    public Curso deleteCustomer(Long id) {
        Curso cursoDB = cursoRepository.findById(id).orElse(null);

        if(cursoDB ==null){
            return null;
        }

        cursoRepository.delete(cursoDB);

        return cursoDB;
    }

    @Override
    public Curso getCustomer(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
