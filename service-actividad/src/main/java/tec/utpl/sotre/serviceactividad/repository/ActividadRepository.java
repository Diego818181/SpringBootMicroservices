package tec.utpl.sotre.serviceactividad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.sotre.serviceactividad.entity.Actividad;
import tec.utpl.sotre.serviceactividad.entity.Curso;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad,Long> {
    // public Actividad findByNumberID(String numberId);
    public List<Actividad> findByLastName(String lastName);
    public List<Actividad> findByRegion(Curso curso);
}
