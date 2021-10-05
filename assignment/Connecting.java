package com.te.assignment;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



import com.technoelevate.hibernate.hibernatepractice.Student;

public class Connecting {
	EntityManagerFactory factory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;
	public void displayAll() {
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			String findAll = "from Student";
			Query query = entityManager.createQuery(findAll);
			List<Student> list = query.getResultList();
			for (Student student : list) {
				System.out.println(student);
				System.out.println("==============================================================================================");
			}
		}finally {
			entityManager.close();
			factory.close();
		}
	}
	public void displayByID(int id) {
		try {
			factory = Persistence.createEntityManagerFactory("details");
			entityManager = factory.createEntityManager();
			String findById = "from Student where id = :id";
			Query query = entityManager.createQuery(findById);
			query.setParameter("id", id);
			Student student = (Student) query.getSingleResult();
			System.out.println("===================================================================================================");
			System.out.println(student);
			System.out.println("===================================================================================================");
		}finally {
			entityManager.close();
			factory.close();
		}
	}
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Update :");
		System.out.println("1. name");
		System.out.println("2. course");
		System.out.println("3. location");
		String choice = scanner.next();
		try {
			switch(choice) {
			case "1":
				System.out.println("enter the id number :");
				int id1 = scanner.nextInt();
				System.out.println("enter the name to be updated :");
				scanner.nextLine();
				String name = scanner.nextLine();
				factory = Persistence.createEntityManagerFactory("details");
				entityManager = factory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String nameUpdate = "update Student set name = :name where id = :id";
				Query query = entityManager.createQuery(nameUpdate);
				query.setParameter("id", id1);
				query.setParameter("name", name);
				int result = query.executeUpdate();
				System.out.println("Name updated successfully!!!");
				entityTransaction.commit();
				break;
			case "2":
				System.out.println("enter the id number :");
				int id2 = scanner.nextInt();
				System.out.println("enter the course to be updated :");
				scanner.nextLine();
				String course = scanner.nextLine();
				factory = Persistence.createEntityManagerFactory("details");
				entityManager = factory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String nameUpdate1 = "update Student set course = :course where id = :id";
				Query query1 = entityManager.createQuery(nameUpdate1);
				query1.setParameter("id", id2);
				query1.setParameter("course", course);
				int result1 = query1.executeUpdate();
				System.out.println("course updated successfully!!!");
				entityTransaction.commit();
				break;
			case "3":
				System.out.println("enter the id number :");
				int id3 = scanner.nextInt();
				System.out.println("enter the jspiders-location to be updated :");
				scanner.nextLine();
				String location = scanner.nextLine();
				factory = Persistence.createEntityManagerFactory("details");
				entityManager = factory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String nameUpdate2 = "update Student set location = :location where id = :id";
				Query query2 = entityManager.createQuery(nameUpdate2);
				query2.setParameter("id", id3);
				query2.setParameter("location", location);
				int result2 = query2.executeUpdate();
				System.out.println("course updated successfully!!!");
				entityTransaction.commit();
				break;
			default:
				throw new StudentException("please enter a valid option otherwise get lost!!!");
			}
		} catch (StudentException e) {
			System.err.println("==================================================================");
			System.err.println(e.getMessage());
			System.err.println("==================================================================");
		}
	}
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id which you want to delete :");
		int id4 = scanner.nextInt();
		factory = Persistence.createEntityManagerFactory("details");
		entityManager = factory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String delete = "delete Student where id=:id";
		Query query = entityManager.createQuery(delete);
		query.setParameter("id", id4);
		int result = query.executeUpdate();
		entityTransaction.commit();
		System.out.println("Deleted sucessully!!!");
	}
	public void insert() {
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id number :");
		int id5 = scanner.nextInt();
		System.out.println("enter the name :");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("enter the course :");
		String course = scanner.nextLine();
		System.out.println("enter the location :");
		String location = scanner.nextLine();
		student.setId(id5);
		student.setName(name);
		student.setCourse(course);
		student.setLocation(location);
		factory = Persistence.createEntityManagerFactory("details");
		entityManager = factory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Data Inserted!!!");
	}
}