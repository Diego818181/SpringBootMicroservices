package tec.utpl.store.servicecurso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.store.servicecurso.entity.Estudiante;
import tec.utpl.store.servicecurso.repository.EstudianteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante getEstudiante(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante createEstudiante(Estudiante estudiante) {
        estudiante.setState("ACTIVE");
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateEstudiante(Estudiante estudiante) {
        Estudiante estudianteDB = getEstudiante(estudiante.getId());

        if (null == estudianteDB){
            return null;
        }
        estudianteDB.setFirstName(estudiante.getFirstName());
        estudianteDB.setLastName(estudiante.getLastName());
        estudianteDB.setEmail(estudiante.getEmail());
        estudianteDB.setNumberId(estudiante.getNumberId());
        estudianteDB.setPhotoUrl(estudiante.getPhotoUrl());
        estudianteDB.setState(estudiante.getState());
        return estudianteRepository.save(estudianteDB);
    }

    @Override
    public Estudiante deleteEstudiante(Long id) {
        Estudiante estudianteDB = getEstudiante(id);

        if (null == estudianteDB){
            return null;
        }

        estudianteRepository.delete(estudianteDB);
        return estudianteDB;
    }


}
