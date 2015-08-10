package com.bluemaple.angular;

import org.springframework.beans.factory.annotation.Autowired;

import com.bluemaple.angulars1.EmpDAO;
import com.bluemaple.angulars1.IempDAo;
import com.bluemaple.js.Loginpage;

import org.springframework.stereotype.Service;

@Service
public class Services implements ServiceImp {

	@Autowired
	private IempDAo dao;

	public IempDAo getDao() {
		return dao;
	}

	public void setDao(IempDAo dao) {
		this.dao = dao;
	}


	public Loginpage getLogin(String username,String password) {
		return dao.getLogin(username,password);
	}

	public Loginpage getReg(Loginpage loginpage) {
		return dao.getReg(loginpage);
	}
}
