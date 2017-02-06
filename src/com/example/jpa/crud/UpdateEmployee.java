package com.example.jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.jpa.entity.Employee;

public class UpdateEmployee {
   public static void main( String[ ] args ) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
      
      EntityManager entitymanager = emfactory.createEntityManager();
      try 
      {
		entitymanager.getTransaction().begin();
		  Employee employee = entitymanager.find(Employee.class, 1201);
		  
		  //before update
		  System.out.println(employee);
		  employee.setSalary(46000);
		  entitymanager.getTransaction().commit();
		  
		  //after update
		  System.out.println(employee);
      } 
      finally
      {
      entitymanager.close();
      emfactory.close();
      }
   }
}
