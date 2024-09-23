package com.tap.entity;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

public class HibernateManager {
    Session session=null;
	public  HibernateManager()
	{
		session=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).buildSessionFactory().openSession();
	}
	
	public void add(Customer  c)
	{
		session.beginTransaction();
		session.persist(c);
		session.beginTransaction().commit();
	}

	public void add(CustomerDetails cd) {
		session.beginTransaction();
		session.persist(cd);
		session.beginTransaction().commit();
		
	}
	public Customer getbasedId(int id)
	{
		session.beginTransaction();
		Customer c=session.get(Customer.class, id);
		if(c!=null) {
		return c;
		}
		return null;
	}
	public void update(int id,String name,String email){
	   session.beginTransaction();
		Customer c=session.get(Customer.class, id);
		if(c!=null)
		{
			c.setName(name);
			c.getCcid().setEmail(email);
			session.update(c);
		}
		else
			System.out.println("no such record");
		session.beginTransaction().commit();
	}
   public void delete(int id) {
		session.beginTransaction();
		Customer c=session.get(Customer.class, id);
		if(c!=null){
			session.delete(c);
		}
		else
			System.out.println("no such record");
		session.beginTransaction().commit();
	}
    public void getAll() {
		 session.beginTransaction();
		String q="*from Customer";
		Query<Customer> q1 = session.createQuery(q,Customer.class);
	    List<Customer> customerList = q1.list();
		for(Customer c:customerList)
		{
			System.out.println(c.getCid()+" "+c.getName()+" "+c.getCcid().getEmail()+" "+c.getCcid().getMobile());
		}
	   session.beginTransaction().commit();
	}

	public CustomerDetails getCDbasedonId(int id) {
		session.beginTransaction();
		CustomerDetails cd = session.get(CustomerDetails.class, id);
		return cd;
	}
	
}
