package com.example.akash.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	public void insert(String name,int age,String city) {
		SessionFactory sf=null;
		try {
			sf = new Configuration().configure().buildSessionFactory();
			//session object
			Session session = sf.openSession();
			session.beginTransaction();
			
			//creating user object
			Users user = new Users();
			user.setName(name);
			user.setAge(age);
			user.setCity(city);
			
			//saving user data 
			session.save(user);
			session.getTransaction().commit();
			session.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}	
	}

	public void delete(int id) {
		SessionFactory sf=null;
		try {
			sf = new Configuration().configure().buildSessionFactory();
			//session object
			Session session = sf.openSession();
			session.beginTransaction();
			
			//fetching user object
			Users user = session.get(Users.class, id);
			
			//saving user data 
			if(user != null) {
				session.delete(user);
				System.out.println("User with id : "+id+" deleted");
			}
			session.getTransaction().commit();
			session.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}
	}
	
	public void update(int id,String name,int age,String city) {
		SessionFactory sf=null;
		try {
			sf = new Configuration().configure().buildSessionFactory();
			//session object
			Session session = sf.openSession();
			session.beginTransaction();
			
			//fetching user object
			Users user = session.get(Users.class, id);
			
			//updating user data 
			user.setName(name);
			user.setAge(age);
			user.setCity(city);
			session.update(user);
			session.getTransaction().commit();
			session.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}
	}
	
	public List<Users> findAll() {
		List<Users> users = null;
		SessionFactory sf=null;
		try {
			sf = new Configuration().configure().buildSessionFactory();
			//session object
			Session session = sf.openSession();
			session.beginTransaction();
			users = session.createQuery("from Users").list();
			session.getTransaction().commit();
			session.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
		}
		return users;
	}

}
