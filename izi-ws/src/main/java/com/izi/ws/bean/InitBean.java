package com.izi.ws.bean;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.izi.dao.DutyDao;
import com.izi.dao.UserDao;
import com.izi.domain.Duty;
import com.izi.domain.User;


@Component
public class InitBean {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DutyDao dutyDao;
	
	@PostConstruct
	public void initBD() {
		
		
		User user = new User();
		user.setName("Shermi");
		userDao.saveAndFlush(user);
		
		User userX = userDao.getOne(new Long(1));
		
		Duty duty = new Duty();
		duty.setCompleted(false);
		duty.setTitle("despedido");
		duty.setOrder(1);
		duty.setUser(userX);
		dutyDao.saveAndFlush(duty);
		
		
	}

}
