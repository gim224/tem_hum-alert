package kr.cse.gt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.cse.gt.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	public User findByEmail(String email);
	
}
