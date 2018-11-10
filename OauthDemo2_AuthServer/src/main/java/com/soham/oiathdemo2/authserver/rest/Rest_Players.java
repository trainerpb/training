package com.soham.oiathdemo2.authserver.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soham.oiathdemo2.authserver.dto.Player;
import com.soham.oiathdemo2.authserver.services.PlayerServiceImpl;

@RestController
@RequestMapping("/api/v1/players")
public class Rest_Players {

	@Autowired
	PlayerServiceImpl playerService;

	@RequestMapping(value = "/player", method = RequestMethod.POST)
	public HttpEntity<?> save(@RequestBody Player p) {
		p = playerService.save(p);
		return new ResponseEntity<Player>(p, null != p ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HttpEntity<?> getAll() {

		return new ResponseEntity<List<Player>>(playerService.getAll(), HttpStatus.OK);
	}
}
