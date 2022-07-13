package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import com.hibernate.manytomany.entity.Laptop;
import com.hibernate.manytomany.entity.Student;

public class ManytomanyApplication {

	public static void main(String[] args) {
		

		Laptop laptop=new Laptop();
		laptop.setLid(101);
		laptop.setName("apple");
		
		Laptop laptop1=new Laptop();
		laptop1.setLid(102);
		laptop1.setName("lenovo");	
		
		Student s=new Student();
		s.setRollno(1);
		s.setName("Megha");
		s.setMarks(50);
		//s.getLaptop().add(laptop);
		//s.getLaptop().add(laptop1);
		
		Student s1=new Student();
		s1.setRollno(2);
		s1.setName("Ayushi");
		s1.setMarks(30);
		
		
		
		laptop.getStudent().add(s);
		laptop.getStudent().add(s1);
			
		Configuration config=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	    ServiceRegistry registry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	    SessionFactory sf=config.buildSessionFactory(registry);
	    Session session=sf.openSession();
	    
	    session.beginTransaction();
	    session.save(laptop);
	    session.save(laptop1);
	    session.save(s);
	    session.save(s1);
	    
	    session.getTransaction().commit();
			
	}
}
