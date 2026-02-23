package com.example.applyWise.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.applyWise.entity.Users;


public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByEmail(String email) ;
}
