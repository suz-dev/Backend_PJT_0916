package dao;

import java.util.List;

import dto.User;

public interface UserDao {
	
	public List<User> findAll();
	public void registUser(User user);
	public User findById(String userId);

}
