package tec.utpl.store.servicecurso.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.store.servicecurso.entity.Curso;
import tec.utpl.store.servicecurso.repository.CursoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCurso(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso createCurso(Curso curso) {
        curso.setState("ACTIVE");
        return cursoRepository.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        Curso cursoDB = getCurso(curso.getId());

        if (null == cursoDB){
            return null;
        }
        cursoDB.setName(curso.getName());
        cursoDB.setDescription(curso.getDescription());
        cursoDB.setNumberId(curso.getNumberId());
        cursoDB.setPeriod(curso.getPeriod());
        cursoDB.setState(curso.getState());
        return cursoRepository.save(cursoDB);
    }

    @Override
    public Curso deleteCurso(Long id) {
        Curso cursoDB = getCurso(id);

        if (null == cursoDB){
            return null;
        }

        cursoRepository.delete(cursoDB);
        return cursoDB;
    }


}
