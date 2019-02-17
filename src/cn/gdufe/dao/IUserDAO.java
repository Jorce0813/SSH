package cn.gdufe.dao;

import cn.gdufe.vo.User;

public interface IUserDAO {
	public User validateUser(String username,String password);
}
