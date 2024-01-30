package tec.utpl.store.servicecurso.service;

import tec.utpl.store.servicecurso.entity.Curso;

import java.util.List;

public interface CursoService {

    public List<Curso> listAllCursos();
    public Curso getCurso(Long id);

    public Curso createCurso(Curso curso);
    public Curso updateCurso(Curso curso);
    public Curso deleteCurso(Long id);

}
