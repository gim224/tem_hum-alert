package kr.cse.gt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.cse.gt.dao.UserDao;
import kr.cse.gt.model.User;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	public User findByOne(int id) {
		return userDao.getOne(id);
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
		
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public void saveAndFlush(User user) {
		userDao.saveAndFlush(user);
	}
	
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails userDetails = this.findByUsername(username);
		
		if(userDetails == null) {
			throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다");
		}
		
		return userDetails;
	}
	
}
