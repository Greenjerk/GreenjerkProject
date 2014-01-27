package com.itra.course.service.impl;

import com.itra.course.dao.*;
import com.itra.course.form.RegisterForm;
import com.itra.course.model.User;
import com.itra.course.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;

//import org.springframework.security.core.userdetails.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userDao;
	
	public void removeUser(String username) {
		userDao.removeUser(userDao.getUserByName(username));
	}

    public void blockUser(String username) {
        User user = userDao.getUserByName(username);
        user.setEnabled(!user.isEnabled());
        userDao.updateUser(user);
    }

	public String addUser(RegisterForm form) {
		User user = new User();
    	user.setIdUser(nextSessionId());
    	user.setUsername(form.getUsername());
    	user.setEmail(form.getEmail());
    	user.setPassword(form.getPassword());
    	user.setEnabled(true);
    	user.setAuthority("ROLE_USER");
		userDao.addUser(user);
		return user.getIdUser();
	}

    public String updateUser(User user) {
        userDao.updateUser(user);
        return user.getIdUser();
    }

	public List<User> getUsers() {
		return userDao.getUsers();
	}

    public List<User> getSimpleUsers() {
        return userDao.getSimpleUsers();
    }
	
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}	

    public String nextSessionId(){
		SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	}

	public String getIdCurrentUser() {		
		return userDao.getIdCurrentUser();
	}

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

}
