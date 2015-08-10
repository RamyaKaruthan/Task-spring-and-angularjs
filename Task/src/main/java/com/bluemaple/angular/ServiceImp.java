package com.bluemaple.angular;

import com.bluemaple.js.Loginpage;

public interface ServiceImp {

	public Loginpage getLogin(String username,String password);

	public Loginpage getReg(Loginpage loginpage);

}
