package com.sts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.sts.model.User;
import com.sts.userrepo.UserRepository;

import com.sts.userrepo.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		fetching user from db
		User user = userRepo.getUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		CustomUserDetails cSD = new CustomUserDetails(user);
		return cSD;
	}

}
