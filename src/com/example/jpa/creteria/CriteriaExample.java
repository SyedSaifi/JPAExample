package com.example.jpa.creteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.jpa.entity.Employee;

public class CriteriaExample {
   public static void main(String[] args) {
   
   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
   EntityManager entitymanager = emfactory.createEntityManager( );
   
   CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
   Root<Employee> from = criteriaQuery.from(Employee.class);

   try 
   {
	//select all records
	System.out.println("Select all records");
	CriteriaQuery<Object> select = criteriaQuery.select(from);
	TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
	List<Object> resultlist = typedQuery.getResultList();
	for (Object o : resultlist) {
		Employee e = (Employee) o;
		System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
	}
	
	
	//Ordering the records 
	System.out.println("Select all records by follow ordering");
	CriteriaQuery<Object> select1 = criteriaQuery.select(from);
	select1.orderBy(criteriaBuilder.asc(from.get("ename")));
	TypedQuery<Object> typedQuery1 = entitymanager.createQuery(select);
	List<Object> resultlist1 = typedQuery1.getResultList();
	for (Object o : resultlist1) {
		Employee e = (Employee) o;
		System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
	} 
	
   	} finally 
   	{
   		entitymanager.close( );
   		emfactory.close( );
   	}
   }
}