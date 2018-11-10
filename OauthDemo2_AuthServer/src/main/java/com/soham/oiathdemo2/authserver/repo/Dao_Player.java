package com.soham.oiathdemo2.authserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soham.oiathdemo2.authserver.dto.Player;

@Repository
public interface Dao_Player extends CrudRepository<Player, Long> {

	
}
