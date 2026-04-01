package com.example.applyWise.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.applyWise.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email) ;
}
