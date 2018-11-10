package com.soham.oiathdemo2.authserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soham.oiathdemo2.authserver.dto.DTO_User;

@Repository
public interface DaoUserAuth extends CrudRepository<DTO_User, Long> {

	public DTO_User findMyUserByUsername(String username);
	
}
