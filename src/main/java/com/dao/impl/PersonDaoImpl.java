package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.PersonDao;
import com.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void savePerson(Person person) {
		getSession().merge(person);
	}

	public List<Person> listPersons() {
		return getSession().createCriteria(Person.class).list();
	}

	public Person getPerson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletePerson(Long id) {
		// TODO Auto-generated method stub
		
	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
