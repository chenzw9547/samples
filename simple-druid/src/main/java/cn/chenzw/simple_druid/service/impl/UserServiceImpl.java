package cn.chenzw.simple_druid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chenzw.simple_druid.bean.User;
import cn.chenzw.simple_druid.dao.UserDao;
import cn.chenzw.simple_druid.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	public List<User> queryAll() {
		return userDao.queryAll();
	}

}
