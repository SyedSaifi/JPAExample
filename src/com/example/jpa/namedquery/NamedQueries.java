package com.example.jpa.namedquery;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.jpa.entity.Employee;

public class NamedQueries {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      try 
      {
		Query query = entitymanager.createNamedQuery("find employee by id");
		query.setParameter("id", 1204);
		List<Employee> list = query.getResultList();
		for (Employee e : list) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee Name :" + e.getEname());
		} 
      } 
      finally 
      {
    	  entitymanager.close();
          emfactory.close();
	  }
   }
}