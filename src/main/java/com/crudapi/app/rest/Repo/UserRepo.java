package com.crudapi.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudapi.app.rest.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
