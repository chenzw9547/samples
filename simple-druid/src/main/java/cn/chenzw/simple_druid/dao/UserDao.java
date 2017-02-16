package cn.chenzw.simple_druid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.chenzw.simple_druid.bean.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> queryAll() {
		return jdbcTemplate.query("select * from user",
				new BeanPropertyRowMapper<User>(User.class));
	}
}
