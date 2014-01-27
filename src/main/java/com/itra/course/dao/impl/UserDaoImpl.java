package com.itra.course.dao.impl;

import java.util.List;

import com.itra.course.dao.UserDao;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itra.course.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

	@Transactional
    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public String getIdCurrentUser() {
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = user.getUsername();
	    List<User> users = sessionFactory.getCurrentSession().createQuery("from User where username = :username").setString( "username", username ).list();
		return users.get(0).getIdUser();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getSimpleUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("authority", "ROLE_USER")).list();
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public User getUserById(String id) {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User where idUser = :id").setString( "id", id ).list();
		return users.get(0);
	}

    @Transactional
    public User getUserByName(String username) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
        return  user;
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public User getCurrentUser() {
		List<User> users = sessionFactory.getCurrentSession().createQuery("from User where idUser = :id").setString( "id", getIdCurrentUser() ).list();
		return users.get(0);
	}
}
