package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Users findByEmail(String email);
	
}
