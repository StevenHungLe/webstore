package com.stevenlesoft.webstore.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Abstract class that defines the general operations and properties of a Hibernate Repository
 * must be extended by Hibernate repository implementations
 * @param <PK> type of persistent entity's key ( id )
 * @param <T>  type of the persistent entity
 */
public abstract class AbstractHibernateRepository<PK extends Serializable, T> {

	SessionFactory sessionFactory;
	Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractHibernateRepository()
	{
		persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		sessionFactory = SessionFactoryBuilder.build();
	}
	
	protected Session getSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
	
	
	protected T getByKey(PK key)
	{
		getSession().beginTransaction();
		T entity = getSession().get(persistentClass, key);
		getSession().getTransaction().commit();
		return entity;
	}
	
	
	protected long save(T entity )
	{
		getSession().beginTransaction();
		long entityId = Long.parseLong(getSession().save(entity).toString());
		getSession().getTransaction().commit();
		return entityId;
	}
	
	protected void persist(T entity )
	{
		getSession().beginTransaction();
		getSession().persist(entity);
		getSession().getTransaction().commit();
	}
	
	protected void update(T entity )
	{
		getSession().beginTransaction();
		getSession().update(entity);
		getSession().getTransaction().commit();
	}
	
	protected void delete(T entity )
	{
		getSession().beginTransaction();
		getSession().delete(entity);
		getSession().getTransaction().commit();
	}
	
	protected Criteria createCriteria()
	{
		return getSession().createCriteria(persistentClass);
	}
	
	protected void beginTransaction()
	{
		getSession().beginTransaction();
	}
	
	protected void endTransaction()
	{
		getSession().getTransaction().commit();
	}
	
}
