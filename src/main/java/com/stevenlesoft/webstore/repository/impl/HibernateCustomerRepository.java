package com.stevenlesoft.webstore.repository.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.repository.AbstractHibernateRepository;
import com.stevenlesoft.webstore.repository.CustomerRepository;

/**
 * an implementation of AbstractHibernateRepository
 * relies on methods defined in the super class to carry out its operations
 */
@SuppressWarnings("unchecked")
@Repository
public class HibernateCustomerRepository extends AbstractHibernateRepository<Long, Customer> implements CustomerRepository {
	
	public List<Customer> getAllCustomers() {
		getSession().beginTransaction();
		List<Customer> customerList = (List<Customer>) createCriteria().list();
		getSession().getTransaction().commit();
		return customerList;
	}

	public Customer getCustomerByUsername(String userName) {
		getSession().beginTransaction();
		Customer customer = (Customer) createCriteria().add(Restrictions.eq("customerEmail", userName)).uniqueResult();
		getSession().getTransaction().commit();
		return customer;
	}
	
	public Customer getCustomerById(long id) {
		return (Customer) getByKey(id);
	}

	/**
	 * @param the customer object to persist
	 * @return the generated id of the new customer
	 */
	public long addCustomer(Customer newCustomer) {
		return save(newCustomer);
	}

	/**
	 * update the customer in the database
	 */
	public void updateCustomer(Customer customer) {
		update(customer);
	}
	
	
}
