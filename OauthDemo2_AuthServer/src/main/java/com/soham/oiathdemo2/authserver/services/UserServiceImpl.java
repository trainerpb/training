package com.soham.oiathdemo2.authserver.services;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soham.oiathdemo2.authserver.dto.DTO_User;
import com.soham.oiathdemo2.authserver.repo.DaoUserAuth;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	DaoUserAuth daoUserAuth;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DTO_User dto_User = daoUserAuth.findMyUserByUsername(username);
		if (null == dto_User) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new User(dto_User.getUsername(), dto_User.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(dto_User.getRole())));
	}

}
