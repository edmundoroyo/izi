package com.izi.ws.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.izi.dao.UserDao;
import com.izi.domain.User;

@Component
public class InitBean {
	
	@Autowired
	UserDao userDao;
	
	@PostConstruct
	public void initBD() {
		
		User user = new User();
		user.setName("Shermi");
		userDao.saveAndFlush(user);
		
	}

}
