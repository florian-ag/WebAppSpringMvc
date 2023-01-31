package fr.formation.inti.dao;

import fr.formation.inti.model.Users;

public interface UserService {
	
	public Users findByEmail(String email);


}
