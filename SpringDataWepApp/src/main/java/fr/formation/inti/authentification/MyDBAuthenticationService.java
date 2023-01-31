package fr.formation.inti.authentification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.UserService;
import fr.formation.inti.model.Users;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users userInfo = service.findByEmail(email);
		// System.out.println("UserInfo= " + userInfo);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + email + " was not found in the database");
		}

		// [USER,ADMIN,..]
//		 List<String> roles= dao.getUserRole(email);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//	        if(roles!= null)  {
//	            for(String role: roles)  {
//	                // ROLE_USER, ROLE_ADMIN,..
//	                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
//	                grantList.add(authority);
//	            }
//	        }
		if (("admin").equals(userInfo.getRoleName())) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			grantList.add(authority);
		}

		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		grantList.add(authority);

		UserDetails userDetails = (UserDetails) new User(userInfo.getEmail(), userInfo.getPassword(), grantList);

		return userDetails;
	}

}
