package com.bluemaple.angulars1;

import com.bluemaple.js.Loginpage;

public interface IempDAo  {
	
	public Loginpage getLogin(String username,String password);
	public Loginpage getReg(Loginpage loginpage) ;
		
}
