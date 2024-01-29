package tec.utpl.sotre.servicecurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.sotre.servicecurso.entity.Curso;
import tec.utpl.sotre.servicecurso.entity.Region;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
    // public Curso findByNumberID(String numberId);
    public List<Curso> findByLastName(String lastName);
    public List<Curso> findByRegion(Region region);
}
