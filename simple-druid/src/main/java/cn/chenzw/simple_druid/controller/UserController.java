package cn.chenzw.simple_druid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.chenzw.simple_druid.bean.User;
import cn.chenzw.simple_druid.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/query/all", method = RequestMethod.GET)
	public List<User> query() {
		return userService.queryAll();
	}
	
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public List<User> query(@PathVariable(value = "id", required = false) int id) {
		return userService.queryAll();
	}
}
