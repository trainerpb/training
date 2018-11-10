package com.soham.oiathdemo2.authserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soham.oiathdemo2.authserver.dto.Player;
import com.soham.oiathdemo2.authserver.repo.Dao_Player;

@Service("playerService")
public class PlayerServiceImpl {

	@Autowired
	Dao_Player dao_Player;
	
	public Player save(Player p) {
		return dao_Player.save(p);
	}
	
	public List<Player> getAll(){
		return (List<Player>) dao_Player.findAll();
	}
}
