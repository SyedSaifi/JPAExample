package com.example.jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.jpa.entity.Employee;

public class CreateEmployee {

   public static void main(String[] args) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
      
      EntityManager entitymanager = emfactory.createEntityManager();
      try 
      {
		entitymanager.getTransaction().begin();

		  Employee employee = new Employee(); 
		  employee.setEname("Gopal");
		  employee.setSalary(40000);
		  employee.setDeg("Technical Manager");
		  
		  entitymanager.persist(employee);
		  entitymanager.getTransaction().commit();
      } 
      finally
      {
      entitymanager.close();
      emfactory.close();
      }
   }
}