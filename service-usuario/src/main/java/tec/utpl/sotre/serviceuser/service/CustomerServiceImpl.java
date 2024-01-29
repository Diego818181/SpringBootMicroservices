package tec.utpl.sotre.serviceuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.utpl.sotre.serviceuser.entity.User;
import tec.utpl.sotre.serviceuser.entity.Region;
import tec.utpl.sotre.serviceuser.repository.UserRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findCustomerAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findCustomersByRegion(Region region) {
        return userRepository.findByRegion(region);
    }

    @Override
    public User createCustomer(User user) {
        User userDB = userRepository.findById(user.getId()).orElse(null);

        if(userDB !=null){
            return userDB;
        }

        user.setState("CREATED");
        userDB = userRepository.save(user);

        return userDB;
    }

    @Override
    public User updateCustomer(User user) {
        User userDB = userRepository.findById(user.getId()).orElse(null);

        if(userDB ==null){
            return null;
        }

        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());
        userDB.setEmail(user.getEmail());
        userDB.setPhotoUrl(user.getPhotoUrl());

        return userRepository.save(userDB);
    }

    @Override
    public User deleteCustomer(Long id) {
        User userDB = userRepository.findById(id).orElse(null);

        if(userDB ==null){
            return null;
        }

        userRepository.delete(userDB);

        return userDB;
    }

    @Override
    public User getCustomer(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
