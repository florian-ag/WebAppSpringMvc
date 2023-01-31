package fr.formation.inti.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository daoUser;

	@Override
	public Users findByEmail(String email) {
		return daoUser.findByEmail(email);
	}

}
