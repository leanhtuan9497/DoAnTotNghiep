package com.leanhtuan.service.impl;

import java.io.File;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.leanhtuan.dao.UserDao;
import com.leanhtuan.dao.impl.UserDaoImpl;
import com.leanhtuan.model.User;
import com.leanhtuan.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void edit(User newUser) {
		User oldUser = userDao.get(newUser.getId());

		oldUser.setEmail(newUser.getEmail());
		oldUser.setUsername(newUser.getUsername());
		oldUser.setPassword(newUser.getPassword());
		oldUser.setRoleId(newUser.getRoleId());
		oldUser.setPoint(newUser.getPoint());
		oldUser.setMyReferalCode(newUser.getMyReferalCode());
		oldUser.setReferalCode(newUser.getReferalCode());
		if (newUser.getAvatar() != null) {
			// XOA ANH CU DI
			String fileName = oldUser.getAvatar();
			final String dir = "/UNIFY/src/main/resources/upload";
			File file = new File(dir + "/" + fileName);
			if (file.exists()) {
				file.delete();
			}
			// THEM ANH MOI
			oldUser.setAvatar(newUser.getAvatar());
		}

		userDao.edit(oldUser);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> search(String username) {
		return userDao.search(username);
	}

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && BCrypt.checkpw(password, user.getPassword())) {
			return user;
		}

		return null;
	}

	@Override
	public boolean register(String username, String password, String email, String referalCode) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		userDao.insert(new User(email, username, hash, referalCode));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
}
