package com.raj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raj.dao.UserDAO;
import com.raj.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
			
	}
	
	@Transactional
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
			
	}

	@Transactional
	public void delete(int uid) {
		User user = new User();
		user.setUid(uid);
		sessionFactory.getCurrentSession().delete(user);
	}

@Transactional
	public User get(int uid) {
		String hql = "from User where uid=" + "'"+ uid +"'";
		
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}

}


