package com.victa.victawebsite.repository;

import com.victa.victawebsite.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
    List<User> findByUsername(String username);


}
