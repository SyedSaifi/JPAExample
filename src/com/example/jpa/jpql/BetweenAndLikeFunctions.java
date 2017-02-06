package com.example.jpa.jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.jpa.entity.Employee;

public class BetweenAndLikeFunctions {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      try 
      {
		//Between
		Query query = entitymanager.createQuery("Select e from Employee e where e.salary Between 30000 and 40000");
		
		List<Employee> list = (List<Employee>) query.getResultList();
		for (Employee e : list) 
		{
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee salary :" + e.getSalary());
		}
		//Like
		Query query1 = entitymanager.createQuery("Select e from Employee e where e.ename LIKE 'M%'");
		List<Employee> list1 = (List<Employee>) query1.getResultList();
		for (Employee e : list1) 
		{
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee name :" + e.getEname());
		} 
	  } 
      finally 
      {
    	  entitymanager.close();
          emfactory.close();
	  }
   }
}