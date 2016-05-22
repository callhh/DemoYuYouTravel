package com.example.sample.usermanage;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8484297427613413311L;

	public User(String username, String password)
	{
		setUsername(username);
		setPassword(password);
	}

}
