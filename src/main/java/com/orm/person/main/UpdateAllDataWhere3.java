package com.orm.person.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.orm.entity.Person;


public class UpdateAllDataWhere3 {
	
	// This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

	public static void main(String[] args) {
		Session sessionObj=buildSessionFactory().getCurrentSession();
		 // Getting Transaction Object From Session Object
        sessionObj.beginTransaction();
        
        Scanner scanner=new Scanner(System.in);
       
        System.out.println("Enter the person id");
        int pid=scanner.nextInt();
        //load and get methods are used to load entity as per it;s primary key
        Person person=(Person) sessionObj.load(Person.class,pid);
        
        System.out.println("Enter name!");
        String name=scanner.next();
        person.setName(name);
        
        sessionObj.getTransaction().commit();
		
	}
}
