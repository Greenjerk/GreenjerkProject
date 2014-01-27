package com.itra.course.service;

import com.itra.course.form.RegisterForm;
import com.itra.course.form.UserForm;
import com.itra.course.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public String addUser(RegisterForm form);
    public String updateUser(User user);
    public void removeUser(String username);
    public void blockUser(String username);
	public List<User> getUsers();
    public List<User> getSimpleUsers();
	public User getUserById(String id);
	public String getIdCurrentUser();
    public User getUserByName(String username);
}
