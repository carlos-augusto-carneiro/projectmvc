package br.com.mvc.projectmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.projectmvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
    User findById(long id);

}
