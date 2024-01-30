package tec.utpl.store.servicecurso.service;

import tec.utpl.store.servicecurso.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listAllEstudiantes();
    public Estudiante getEstudiante(Long id);

    public Estudiante createEstudiante(Estudiante estudiante);
    public Estudiante updateEstudiante(Estudiante estudiante);
    public Estudiante deleteEstudiante(Long id);

}
