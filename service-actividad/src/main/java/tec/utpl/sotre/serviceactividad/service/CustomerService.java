package tec.utpl.sotre.serviceactividad.service;

import tec.utpl.sotre.serviceactividad.entity.Actividad;
import tec.utpl.sotre.serviceactividad.entity.Curso;

import java.util.List;

public interface CustomerService {
    public List<Actividad> findCustomerAll();
    public List<Actividad> findCustomersByRegion(Curso curso);

    public Actividad createCustomer(Actividad actividad);
    public Actividad updateCustomer (Actividad actividad);
    public Actividad deleteCustomer (Long id);
    public Actividad getCustomer(Long id);
}
