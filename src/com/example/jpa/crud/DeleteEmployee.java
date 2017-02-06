package com.example.jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.jpa.entity.Employee;

public class DeleteEmployee {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
      EntityManager entitymanager = emfactory.createEntityManager();
      try 
      {
		entitymanager.getTransaction().begin();
		  
		  Employee employee = entitymanager.find(Employee.class, 1201);
		  entitymanager.remove(employee);
		  entitymanager.getTransaction().commit();
	  } 
      finally
      {
      entitymanager.close();
      emfactory.close();
      }
   }
}