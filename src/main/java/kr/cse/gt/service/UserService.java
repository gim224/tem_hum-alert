package kr.cse.gt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cse.gt.dao.UserDao;
import kr.cse.gt.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User findByOne(int id) {
		return userDao.getOne(id);
	}
	
}
