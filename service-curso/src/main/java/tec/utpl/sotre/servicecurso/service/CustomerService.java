package tec.utpl.sotre.servicecurso.service;

import tec.utpl.sotre.servicecurso.entity.Curso;
import tec.utpl.sotre.servicecurso.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<Curso> findCustomerAll();
    public List<Curso> findCustomersByRegion(Region region);

    public Curso createCustomer(Curso curso);
    public Curso updateCustomer (Curso curso);
    public Curso deleteCustomer (Long id);
    public Curso getCustomer(Long id);
}
