package cn.gdufe.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.gdufe.dao.IUserDAO;
import cn.gdufe.vo.User;

public class UserDAO extends BaseDAO implements IUserDAO{

	@SuppressWarnings("unchecked")
	@Override
	public User validateUser(String username, String password) {
		// 1.获取session
		Session session = getSession();
		// 2.进行数据库的查询[username+password]-->查询的是User,而不是数据库中的表
		Query query = session.createQuery("from User where username = ? and password = ?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<User> list = query.list();
		if(list.size()!=0){
			return list.get(0);
		}
		// 3.返回查询结果并关闭session
		session.close();
		return null;
	}

}
