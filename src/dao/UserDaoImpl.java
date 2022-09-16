package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Review;
import dto.User;

public class UserDaoImpl implements UserDao{
	private List<User> userList = new ArrayList();
	private static UserDaoImpl instance = new UserDaoImpl();

	private UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static UserDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void registUser(User user) {
		userList.add(user);
	}
	
	@Override
	public List<User> findAll() {
		return userList;
	}

	@Override
	public User findById(String userId) {
		for(User user : userList) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
}
