package tec.utpl.sotre.serviceuser.service;

import tec.utpl.sotre.serviceuser.entity.User;
import tec.utpl.sotre.serviceuser.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<User> findCustomerAll();
    public List<User> findCustomersByRegion(Region region);

    public User createCustomer(User user);
    public User updateCustomer (User user);
    public User deleteCustomer (Long id);
    public User getCustomer(Long id);
}
