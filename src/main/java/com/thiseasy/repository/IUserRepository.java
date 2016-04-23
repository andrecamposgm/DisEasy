package com.thiseasy.repository;

import com.thiseasy.model.User;
import org.springframework.data.repository.CrudRepository;


public interface IUserRepository extends CrudRepository<User, Long> {

}