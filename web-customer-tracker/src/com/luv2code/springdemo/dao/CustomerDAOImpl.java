package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
// Repository is needed so Spring can scan for this class
public class CustomerDAOImpl implements CustomerDAO {
	
	// DAO needs a session factory to communicate with the database
	// The session factory needs a data source, which holds database info (spring-mvc-crud-demo-servlet)
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	// Transactional makes it so we don't explicitly have to begin and end transaction
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

}