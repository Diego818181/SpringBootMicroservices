package tec.utpl.sotre.serviceuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.sotre.serviceuser.entity.User;
import tec.utpl.sotre.serviceuser.entity.Region;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // public User findByNumberID(String numberId);
    public List<User> findByLastName(String lastName);
    public List<User> findByRegion(Region region);
}
